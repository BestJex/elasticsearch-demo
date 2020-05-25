package com.jex.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
//search_request_log 必须是驼峰式写法，不能是search_requestLog ,不然会报错
@Document(indexName = "search_request_log",type = "request_log")
public class RequestLog {

    //Id注解Elasticsearch里相应于该列就是主键，查询时可以使用主键查询
    @Id
    private Long id;
    private String orderNo;
    private String userId;
    private String userName;
    private String createTime;
}