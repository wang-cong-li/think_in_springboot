package com.wcl.study.springframework.service.impl;

import com.wcl.study.springframework.annotation.StringRepository;
import com.wcl.study.springframework.service.BaseService;

import java.util.Arrays;
import java.util.Collection;

@StringRepository("baseService")
public class BaseServiceImpl implements BaseService {
    @Override
    public Collection<String> getBaseInfo() {
        return Arrays.asList("value0","value1");
    }
}
