package com.jex.elasticsearch.dao;

import com.jex.elasticsearch.entity.Doc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 
 * @author Jex
 * @date 2020年05月27日 
 * 
 */

public interface DocRepository extends ElasticsearchRepository<Doc, Long> {

    Page<Doc> findByContent(String content, Pageable pageable);


    Page<Doc> findByFirstCode(String firstCode, Pageable pageable);


    Page<Doc> findBySecondCode(String secondCode, Pageable pageable);

}
