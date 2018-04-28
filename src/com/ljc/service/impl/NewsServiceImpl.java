package com.ljc.service.impl;

import com.ljc.mapper.NewsMapper;
import com.ljc.mapper.StudentMapper;
import com.ljc.pojo.News;
import com.ljc.pojo.Student;
import com.ljc.service.NewsService;
import com.ljc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/21.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;


    @Override
    public List<News> list() {
        return newsMapper.list();
    }
}
