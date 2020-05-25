package com.jex.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;


/**
 * @Date 2020/4/16 10:19
 * @Author jex
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "search_book", type = "book")
public class Book {

    @Id
    @Field(type = FieldType.Integer)
    private Integer bookId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String bookCode;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String bookName;
    @Field(type = FieldType.Integer)
    private Integer bookPrice;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String bookAuthor;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String bookDesc;
    @Field(type = FieldType.Date)
    private Date created;
}
