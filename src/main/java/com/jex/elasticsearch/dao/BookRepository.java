package com.jex.elasticsearch.dao;


import com.jex.elasticsearch.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @date 2020/4/16 10:24
 * @author jex
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Long> {
}
