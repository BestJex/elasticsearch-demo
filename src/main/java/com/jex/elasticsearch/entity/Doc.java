package com.jex.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * @author Jex
 * @date 2020年05月27日 
 * 
 */

@Data
//NoArgsConstructor 无参构造函数必写，不然查询会报错
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "search_doc",type = "doc", shards = 1, replicas = 0)
public class Doc {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String firstCode;

    @Field(type = FieldType.Keyword)
    private String secondCode;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    @Field(type = FieldType.Integer)
    private Integer type;



}
