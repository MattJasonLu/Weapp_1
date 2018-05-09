package com.ljc.service.impl;

import com.ljc.mapper.ScoreMapper;
import com.ljc.pojo.Score;
import com.ljc.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/5/2.
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public void add(Score score) {
        scoreMapper.add(score);
    }

    @Override
    public void delete(int id) {
        scoreMapper.delete(id);
    }

    @Override
    public List<Score> list() {
        return scoreMapper.list();
    }

    @Override
    public List<Score> get(String keyword) {
        return scoreMapper.get(keyword);
    }

    @Override
    public Score get(String studentId, String courseId) {
        return scoreMapper.get(studentId, courseId);
    }

    @Override
    public void update(Score score) {
        scoreMapper.update(score);
    }
}
