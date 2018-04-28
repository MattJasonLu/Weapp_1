package com.ljc.service;

import com.ljc.mapper.TurnoverMapper;
import com.ljc.pojo.Turnover;

import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
public interface TurnoverService {
    List<Turnover> list();
    List<Turnover> get(String keyword);
    void add(Turnover turnover);
    void delete(int id);
    void update(Turnover turnover);
}
