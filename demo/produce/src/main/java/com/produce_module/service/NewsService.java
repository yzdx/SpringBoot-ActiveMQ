package com.produce_module.service;

import com.produce_module.entities.News;

import java.util.List;


public interface NewsService {
    /**
     *  获取全部消息
     * @return
     */
    List<News> getAll();
}
