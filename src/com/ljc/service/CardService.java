package com.ljc.service;

import com.ljc.mapper.CardMapper;
import com.ljc.pojo.Card;
import com.ljc.pojo.Score;

/**
 * Created by matt on 2018/5/9.
 */
public interface CardService {
    void add(Card card);

    Card get(int id);

    void update(Score score);

    void active(int id);

    void invalid(int id);
}
