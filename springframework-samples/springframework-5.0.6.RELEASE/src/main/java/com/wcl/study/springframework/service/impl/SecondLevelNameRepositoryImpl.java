package com.wcl.study.springframework.service.impl;

import com.wcl.study.springframework.annotation.SecondLevelRepository;
import com.wcl.study.springframework.service.NameRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SecondLevelRepository("second") // spring3.0也仅支持两层注解派生，从@Repository派生的第二层以及更多层注解（即本注解）可以支持
                                 // 直到spring4.0版本才可以支持二层以上的注解派生特性
public class SecondLevelNameRepositoryImpl implements NameRepository {
    @Override
    public Collection<String> getAllNames() {
        List<String> list = new ArrayList<>();
        list.add("xiaomage");
        list.add("damage");
        return list;
    }
}
