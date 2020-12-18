package com.diy.spring.servlet;

import com.diy.spring.annotation.XAutowired;
import com.diy.spring.annotation.XController;
import com.diy.spring.annotation.XRequestMapping;
import com.diy.spring.annotation.XService;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class DiyDispatcherServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private List<String> classNameList = new ArrayList<>();

    Map<String, Object> iocMap = new HashMap<>();

    Map<String, Method> handlerMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception detail :" + Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void init (ServletConfig servletConfig) {
        doLoadingConfig(servletConfig.getInitParameter("contextConfigLocation"));

        doScanner(contextConfig.getProperty("scan-package"));

        doInstance();

        doAutowired();

        initHandlerMapping();

        System.out.println("XSpring Framework is init");

        doTestData();
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");
        System.out.println("url --> " + url);

        if (!handlerMap.containsKey(url)) {
            try {
                resp.getWriter().write("404 not found");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Method method = handlerMap.get(url);
        System.out.println("method --> " + method);

        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        System.out.println("iocMap.get(beanName) --> " + iocMap.get(beanName));

        method.invoke(iocMap.get(beanName), req, resp);
        System.out.println("method.invoke put {" + iocMap.get(beanName) + "}");
    }

    private String toLowerFirstCase(String className) {
        char[] chars = className.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 加载配置文件
     * @param contextConfigLocation 配置文件路径
     */
    private void doLoadingConfig(String contextConfigLocation) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(inputStream);
            System.out.println("property file has been saved in contextConfig");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    /**
     * 处理扫描类
     * @param scanPackage
     */
    private void doScanner(String scanPackage) {
        URL resourcePath = this.getClass().getClassLoader().getResource("/" + scanPackage.replace("\\.", "/"));
        if (resourcePath == null) {
            return;
        }

        File classPath = new File(resourcePath.getPath());
        for (File file : Objects.requireNonNull(classPath.listFiles())) {
           if (file.isDirectory()) {
               System.out.println("{ "+file.getName()+" } is a dictionary");
               doScanner(scanPackage + "." + file.getName());
           } else {
               if (!file.getName().endsWith(".class")) {
                   System.out.println("{ "+file.getName()+" } is not a class file");
                   continue;
               }
               String className = (scanPackage + "." + file.getName()).replace(".class", "");
               classNameList.add(className);
               System.out.println("{ " + className + " } has been saved in classNameList");
           }
        }
    }

    /**
     * 初始化ioc容器
     */
    private void doInstance(){
        if (classNameList.isEmpty()){
            return;
        }
        try {
            for (String className : classNameList) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(XController.class)){
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    Object instance = clazz.newInstance();
                    iocMap.put(beanName, instance);
                    System.out.println("{ " + beanName + " } has been saved in iocMap");
                } else if (clazz.isAnnotationPresent(XService.class)) {
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    XService xService = clazz.getAnnotation(XService.class);
                    if (!"".equals(xService.value())) {
                        beanName = xService.value();
                    }
                    Object instance = clazz.newInstance();
                    iocMap.put(beanName, instance);
                    System.out.println("{ " + beanName +" } has been saved in iocMap");

                    for (Class<?> c : clazz.getInterfaces()) {
                        if (iocMap.containsKey(c.getName())) {
                            throw new Exception("the bean name is exist");
                        }
                        iocMap.put(c.getName(), instance);
                        System.out.println("{ " + c.getName() + " } has been saved in iocMap");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doAutowired(){
        if (iocMap.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : iocMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(XAutowired.class)){
                    continue;
                }
                System.out.println("existence XAutowired");

                XAutowired xAutowired = field.getAnnotation(XAutowired.class);
                String beanName = xAutowired.value().trim();
                if ("".equals(beanName)) {
                    System.out.println("XAutowired value is null");
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);

                try {
                    field.set(entry.getValue(), iocMap.get(beanName));
                    System.out.println("field set { " +entry.getValue() + " }");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 初始化handlerMapping
     */
    private void initHandlerMapping(){
        if (iocMap.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : iocMap.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(XController.class)) {
                continue;
            }
            String baseUrl = "";
            if (clazz.isAnnotationPresent(XRequestMapping.class)) {
                XRequestMapping xRequestMapping = clazz.getAnnotation(XRequestMapping.class);
                baseUrl = xRequestMapping.value();
            }
            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(XRequestMapping.class)) {
                    continue;
                }
                XRequestMapping xRequestMapping = method.getAnnotation(XRequestMapping.class);
                String url = ("/" + baseUrl + "/" + xRequestMapping.value()).replaceAll("/+", "/");
                handlerMap.put(url, method);
                System.out.println("handlerMapping put { " + url + " } - { " +
                        method.getName() + " saved into handlerMap}");
            }
        }
    }

    private void doTestData(){
        System.out.println("------ test data start ------");
        System.out.println("contextConfig.propertyNames()" + contextConfig.propertyNames());
        System.out.println("[classNameList] --> ");
        for (String e : classNameList) {
            System.out.println(e);
        }

        System.out.println("[iocMap] -->");
        for (Map.Entry<String, Object> entry : iocMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("[handlerMapping] --> ");
        for (Map.Entry<String, Method> entry : handlerMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("---- test data end -----");
    }
}
