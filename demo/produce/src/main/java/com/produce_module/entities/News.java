package com.produce_module.entities;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table ;

/**
 *
 * 新闻实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@ToString
@Table(name = "news")
public class News {
    //新闻ID
    @Id
    @Column(name = "news_id")
    private String newsId ;
    //新闻名称
    @Column(name = "news_name")
    private String newsName ;
    // 新闻内容
    @Column(name = "news_content")
    private String content ;
}
