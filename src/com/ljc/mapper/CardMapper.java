package com.ljc.mapper;

import com.ljc.pojo.Card;
import com.ljc.pojo.Score;

import java.util.List;

/**
 * Created by matt on 2018/4/23.
 */
public interface CardMapper {

    void add(Card card);

    Card get(int id);

    void update(Score score);

    void active(int id);

    void invalid(int id);

}
