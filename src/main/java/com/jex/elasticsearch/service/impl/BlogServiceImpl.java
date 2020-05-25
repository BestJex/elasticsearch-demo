package com.jex.elasticsearch.service.impl;


import com.jex.elasticsearch.dao.BlogRepository;
import com.jex.elasticsearch.entity.Blog;
import com.jex.elasticsearch.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Jex
 * @date 2020年05月25日
 *
 */

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> search(String title, String content, Pageable pageable) {
        return blogRepository.findByTitleLikeOrContentLike(title,content,pageable);
    }

    @Override
    public Page<Blog> search(String content, Pageable pageable) {
        return blogRepository.findByContentLike(content,pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

}
