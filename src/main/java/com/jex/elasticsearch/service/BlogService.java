package com.jex.elasticsearch.service;


import com.jex.elasticsearch.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author Jex
 * @date 2020年05月25日
 * 
 */
public interface BlogService {

    //保存EsBlog实体
    void save (Blog blog);

    //基于title和content进行搜索，返回分页
    Page<Blog> search(String title, String content, Pageable pageable);

    //基于content进行搜索，返回分页
    Page<Blog> search(String content,Pageable pageable);

    //返回所有数据集合
    Page<Blog> findAll(Pageable pageable);

}
