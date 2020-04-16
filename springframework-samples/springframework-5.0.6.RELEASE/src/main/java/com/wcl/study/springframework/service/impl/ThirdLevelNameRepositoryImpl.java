package com.wcl.study.springframework.service.impl;

import com.wcl.study.springframework.annotation.ThirdLevelRepository;
import com.wcl.study.springframework.service.NameRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ThirdLevelRepository("third")
public class ThirdLevelNameRepositoryImpl implements NameRepository {
    @Override
    public Collection<String> getAllNames() {
        List<String> list = new ArrayList<>();
        list.add("xiaomage");
        list.add("damage");
        return list;
    }
}
