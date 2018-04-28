package com.ljc.service.impl;

import com.ljc.mapper.TurnoverMapper;
import com.ljc.pojo.Turnover;
import com.ljc.service.TurnoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Service
public class TurnoverServiceImpl implements TurnoverService {

    @Autowired
    TurnoverMapper turnoverMapper;

    @Override
    public List<Turnover> list() {
        return turnoverMapper.list();
    }

    @Override
    public List<Turnover> get(String keyword) {
        return turnoverMapper.get(keyword);
    }

    @Override
    public void add(Turnover turnover) {
        turnoverMapper.add(turnover);
    }

    @Override
    public void delete(int id) {
        turnoverMapper.delete(id);
    }

    @Override
    public void update(Turnover turnover) {
        turnoverMapper.update(turnover);
    }
}
