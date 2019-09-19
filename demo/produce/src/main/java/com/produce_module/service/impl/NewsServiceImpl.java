package com.produce_module.service.impl;

import com.produce_module.entities.News;
import com.produce_module.dao.NewsMapper;
import com.produce_module.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getAll() {
        return newsMapper.getAll();
    }
}
