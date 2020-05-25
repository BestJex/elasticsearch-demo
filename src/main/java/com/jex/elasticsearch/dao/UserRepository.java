package com.jex.elasticsearch.dao;


import com.jex.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jex
 * @date 2020-04-16 23:20
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {
}
