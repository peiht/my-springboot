package org.spring.server.org.annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author hitopei
 * 注解处理器
 * 需要继承AbstractProcessor
 *
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("org.spring.server.org.annotation.GeneratePrint")
public class MyGetterProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return true;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv){
        super.init(processingEnv);
    }
}
