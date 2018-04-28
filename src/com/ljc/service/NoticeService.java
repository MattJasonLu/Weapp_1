package com.ljc.service;

import com.ljc.pojo.Notice;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
public interface NoticeService {
    void add(Notice notice);
    void delete(String id);
    List<Notice> get(String content);
    List<Notice> list();
}
