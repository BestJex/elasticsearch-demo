package com.jex.elasticsearch.dao;

import com.jex.elasticsearch.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 只需要继承ElasticsearchRepository即可，与JpaRepository相似，里面封装好了基本的CRUD操作方法。
 * @author jex
 * @date 2020/5/20 23:38
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

}
