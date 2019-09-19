package com.produce_module;

import com.produce_module.dao.NewsMapper;
import com.produce_module.entities.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoyyApplicationTests {

    @Autowired
    private NewsMapper newsMapper ;

    @Test
    public void contextLoads() {
        List<News> all = newsMapper.getAll();
        System.out.println(all);
    }

}
