package com.ljc.mapper;

import com.ljc.pojo.Announcement;

import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
public interface AnnouncementMapper {

    public void add(Announcement announcement);

    public void delete(int id);

    public List<Announcement> get(Announcement announcement);

    public List<Announcement> get(String content);

    public void update(Announcement announcement);

    public List<Announcement> list();

    public int count();
}
