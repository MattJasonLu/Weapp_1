package com.ljc.service;

import com.ljc.pojo.Issue;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
public interface IssueService {

    void add(Issue issue);
    void delete(int id);
    List<Issue> list();
    Issue get(int id);
    List<Issue> getByContent(String keyword);
    void update(Issue issue);
    List<Issue> getFix();

    List<Issue> getLost();

}
