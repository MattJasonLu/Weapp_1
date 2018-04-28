package com.ljc.service;

import com.ljc.pojo.Issue;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
public interface IssueService {

    List<Issue> list();
    List<Issue> get(String content);
    void add(Issue issue);
    void delete(int id);
    void update(Issue issue);

}
