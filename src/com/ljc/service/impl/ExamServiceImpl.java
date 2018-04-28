package com.ljc.service.impl;

import com.ljc.mapper.ExamMapper;
import com.ljc.pojo.Exam;
import com.ljc.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamMapper examMapper;

    @Override
    public List<Exam> list() {
        return examMapper.list();
    }
}
