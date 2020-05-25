package com.jex.elasticsearch.dao;

import com.jex.elasticsearch.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 只需要继承ElasticsearchRepository即可，与JpaRepository相似，里面封装好了基本的CRUD操作方法。以及findByContentLike也跟jpa的用法相似
 * @author Jex
 * @date 2020年05月25日
 * 
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, Long> {
    Page<Blog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
    Page<Blog> findByContentLike(String content,Pageable pageable);
}