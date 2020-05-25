package com.jex.elasticsearch.dao;


import com.jex.elasticsearch.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jex
 * @date 2020-04-16 22:59
 */
@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, Long> {
}
