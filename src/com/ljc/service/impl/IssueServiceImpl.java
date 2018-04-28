package com.ljc.service.impl;

import com.ljc.mapper.IssueMapper;
import com.ljc.pojo.Issue;
import com.ljc.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Override
    public List<Issue> list() {
        return issueMapper.list();
    }

    @Override
    public List<Issue> get(String content) {
        return issueMapper.get(content);
    }

    @Override
    public void add(Issue issue) {
        issueMapper.add(issue);
    }

    @Override
    public void delete(int id) {
        issueMapper.delete(id);
    }

    @Override
    public void update(Issue issue) {
        issueMapper.update(issue);
    }
}
