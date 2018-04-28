package com.ljc.service.impl;

import com.ljc.mapper.NoticeMapper;
import com.ljc.pojo.Notice;
import com.ljc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public void add(Notice notice) {
        noticeMapper.add(notice);
    }

    @Override
    public void delete(String id) {
        noticeMapper.delete(id);
    }

    @Override
    public List<Notice> get(String content) {
        return noticeMapper.get(content);
    }

    @Override
    public List<Notice> list() {
        return noticeMapper.list();
    }
}
