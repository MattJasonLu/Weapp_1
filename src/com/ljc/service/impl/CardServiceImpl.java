package com.ljc.service.impl;

import com.ljc.mapper.CardMapper;
import com.ljc.pojo.Card;
import com.ljc.pojo.Score;
import com.ljc.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by matt on 2018/5/9.
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardMapper cardMapper;

    @Override
    public void add(Card card) {
        cardMapper.add(card);
    }

    @Override
    public Card get(int id) {
        return cardMapper.get(id);
    }

    @Override
    public void update(Score score) {
        cardMapper.update(score);
    }

    @Override
    public void active(int id) {
        cardMapper.active(id);
    }

    @Override
    public void invalid(int id) {
        cardMapper.invalid(id);
    }
}
