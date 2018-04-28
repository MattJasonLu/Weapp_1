package com.ljc.mapper;

import com.ljc.pojo.Issue;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
public interface IssueMapper {
    void add(Issue issue);
    void delete(int id);
    List<Issue> list();
    List<Issue> get(String content);
    void update(Issue issue);
}
