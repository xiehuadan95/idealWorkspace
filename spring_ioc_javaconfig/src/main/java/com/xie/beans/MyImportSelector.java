package com.xie.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * @Author xiehu
 * @Date 2022/9/1 10:21
 * @Version 1.0
 * @Description 实现ImportSelector返回多个bean
 */
@Component
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //可以以字符串的形式返回多个bean 注册进ioc容器，必须是类的完整限定名，getBean的时候不能根据名字来获取，只能根据类型来获取
        return new String[]{"com.xie.beans.Person",Wife.class.getName()};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }
}
