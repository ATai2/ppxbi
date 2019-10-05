package com.ppx.learnspring.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        importingClassMetadata.getAnnotatedMethods()
        return new String[0];
    }
}
