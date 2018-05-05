package com.ljc.service;

import com.ljc.pojo.Announcement;

import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
public interface AnnouncementService {

    void add(Announcement announcement);

    void delete(int id);

    List<Announcement> getByKeyword(String keyword);

    void update(Announcement announcement);

    List<Announcement> list();
}
