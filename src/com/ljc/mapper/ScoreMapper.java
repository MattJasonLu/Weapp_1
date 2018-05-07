package com.ljc.mapper;

import com.ljc.pojo.Course;
import com.ljc.pojo.Score;

import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/4/23.
 */
public interface ScoreMapper {

    void add(Score score);

    void delete(int id);

    List<Score> list();

    List<Score> get(Map params);

    Score get(String studentId, String courseId);

    void update(Score score);

}
