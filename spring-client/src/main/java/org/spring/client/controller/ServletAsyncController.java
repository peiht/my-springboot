package org.spring.client.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * 测试servlet实现异步
 * @author hitopei
 */
@RestController
public class ServletAsyncController {

    /**
     * servlet实现异步任务
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @RequestMapping("servletReq")
    public void servletReq(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        AsyncContext asyncContext = httpServletRequest.startAsync();
        //异步监听器，监听完成、超时、报错、开始执行时的事件
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println("完成了....");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.out.println("超时了....");
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                System.out.println("报错了....");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                System.out.println("开始");
            }
        });

        //设置异步超时
        asyncContext.setTimeout(20000);
        //异步开始
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("内部线程" + Thread.currentThread().getName());
                    //返回体设置
                    asyncContext.getResponse().setCharacterEncoding("utf-8");
                    asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                    asyncContext.getResponse().getWriter().println("这是异步请求返回");
                }catch (Exception e){
                    System.out.println("异常，"+ e);
                }
                asyncContext.complete();
            }
        });

        System.out.println("主线程" + Thread.currentThread().getName());
    }


    /**
     * callable 实现异步 超时使用spring web config配置
     * @return
     */
    @GetMapping("callableAsync")
    public Callable<String> callableAsync(){
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                System.out.println("当前线程:" + Thread.currentThread().getName());
                return "callable";
            }
        };
    }

    /**
     * WebAsyncTask  实现异步
     * @return
     */
    @GetMapping("webAsyncTask")
    public WebAsyncTask<String> webAsyncTask(){
        System.out.println("外部线程"+Thread.currentThread().getName());

        Callable<String> callable = () -> {
            System.out.println("内部线程开始" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("内部线程返回" + Thread.currentThread().getName());
            return "success";
        };

        //超时设置
//        WebAsyncTask<String> wat = new WebAsyncTask<String>(3000L, callable);
//        wat.onTimeout(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "超时";
//            }
//        });
        WebAsyncTask<String> wat = new WebAsyncTask<String>(callable);

        return wat;
    }


    /**
     * DeferredResult实现超时
     * @return
     */
    @GetMapping("deferredResult")
    public DeferredResult<String> deferredResult(){
        System.out.println("外部线程"+Thread.currentThread().getName());

        DeferredResult<String> result = new DeferredResult<>(60*1000L);
        result.onTimeout(new Runnable() {
            @Override
            public void run() {
                System.out.println("DeferredResult超时");
                result.setResult("超时了！");
            }
        });

        result.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("DeferredResult完成");
                result.setResult("完成了！");
            }
        });

        ThreadPoolExecutor executors = new ThreadPoolExecutor(4,4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部线程" + Thread.currentThread().getName());
                result.setResult("DeferredResult");
            }
        });
        return result;
    }
}
