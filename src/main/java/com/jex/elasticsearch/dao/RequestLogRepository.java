package com.jex.elasticsearch.dao;

import com.jex.elasticsearch.entity.RequestLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jex
 * @date 2020/5/20 23:38
 */
@Repository
public interface RequestLogRepository extends ElasticsearchRepository<RequestLog, String> {

}
