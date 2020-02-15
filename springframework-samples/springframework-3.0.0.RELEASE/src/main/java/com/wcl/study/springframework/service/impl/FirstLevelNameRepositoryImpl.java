package com.wcl.study.springframework.service.impl;

import com.wcl.study.springframework.annotation.FirstLevelRepository;
import com.wcl.study.springframework.service.NameRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@FirstLevelRepository("first") // spring3.0也仅支持两层注解派生，从@Repository派生的第一层注解（即本注解）可以支持
public class FirstLevelNameRepositoryImpl implements NameRepository {
    @Override
    public Collection<String> getAllNames() {
        List<String> list = new ArrayList<>();
        list.add("xiaomage");
        list.add("damage");
        return list;
    }
}
