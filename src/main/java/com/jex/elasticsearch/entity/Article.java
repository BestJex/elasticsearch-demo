package com.jex.elasticsearch.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。
 * indexName索引名称 理解为数据库名 限定小写
 * type 理解为数据库的表名称
 * shards = 5 默认分区数
 * replicas = 1 每个分区默认的备份数
 * refreshInterval = "1s" 刷新间隔
 * indexStoreType = "fs" 索引文件存储类型
 *
 * @author jex
 * @date 2020/5/20 23:38
 */
@Data
@ToString
//加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。indexName索引名称 理解为数据库名 限定小写，type 理解为数据库的表名称。一个索引名只能对应一种个类型
@Document(indexName = "search_article", type = "article")
public class Article {
    /**
     * 主键ID
     */
    @Field(type = FieldType.Keyword)
    private String id;

    /**
     * 文章标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;

    /**
     * 文章内容
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Date, pattern = "yyyy-MM-dd HH:mm:ss", format = DateFormat.custom)
    private String createTime;
}
