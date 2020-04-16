package com.wcl.study.springframework.service.impl;

import com.wcl.study.springframework.composed_annotation.TransactionalService;
import com.wcl.study.springframework.service.ComposedAnnotationService;

@TransactionalService(name = "composed")
public class ComposedAnnotationServiceImpl implements ComposedAnnotationService {
}
