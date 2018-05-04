package com.ljc.service;

import com.ljc.pojo.Course;
import com.ljc.pojo.Score;

import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/4/23.
 */
public interface ScoreService {

    void add(Score score);

    void delete(int id);

    List<Score> list();

    List<Score> get(Map params);

    void update(Score score);

}
