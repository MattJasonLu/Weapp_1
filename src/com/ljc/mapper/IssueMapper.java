package com.ljc.mapper;

import com.ljc.pojo.Issue;
import org.hamcrest.core.Is;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
public interface IssueMapper {
    void add(Issue issue);
    void delete(int id);
    List<Issue> list();
    Issue get(int id);

    List<Issue> getFix();

    List<Issue> getLost();

    void update(Issue issue);
}
