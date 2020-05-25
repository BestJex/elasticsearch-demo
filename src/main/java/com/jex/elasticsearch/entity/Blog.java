package com.jex.elasticsearch.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 *
 * @author Jex
 * @date 2020年05月25日
 *
 */

@Data
@ToString
@Document(indexName="search_blog",type="blog",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Blog {

    private long id;

    private String uid;

    private String title;

    private String content;

    private Date createDate;

    private Date updateDate;

}