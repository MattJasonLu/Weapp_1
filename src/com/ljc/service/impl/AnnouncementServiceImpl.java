package com.ljc.service.impl;

import com.ljc.mapper.AnnouncementMapper;
import com.ljc.pojo.Announcement;
import com.ljc.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    AnnouncementMapper announcementMapper;

    @Override
    public void add(Announcement announcement) {
        announcementMapper.add(announcement);
    }

    @Override
    public void delete(int id) {
        announcementMapper.delete(id);
    }

    @Override
    public List<Announcement> get(Announcement announcement) {
        return announcementMapper.get(announcement);
    }

    @Override
    public List<Announcement> get(String content) {
        return announcementMapper.get(content);
    }

    @Override
    public void update(Announcement announcement) {
        announcementMapper.update(announcement);
    }

    @Override
    public List<Announcement> list() {
        return announcementMapper.list();
    }
}
