package com.wcl.study.springframework.service.impl;

import com.wcl.study.springframework.service.TestRepository;
import com.wcl.study.springframework.annotation.FourthLevelRepository;

@FourthLevelRepository("fourth")
public class FourthLevelNameRepositoryImpl implements TestRepository {

}
