package com.produce_module.dao;

import com.produce_module.entities.News;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {

    /**
     *  获取全部消息
     * @return
     */
    List<News> getAll();
}
