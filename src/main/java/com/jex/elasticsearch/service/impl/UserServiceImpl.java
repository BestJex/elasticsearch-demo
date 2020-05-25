package com.jex.elasticsearch.service.impl;


import com.jex.elasticsearch.dao.UserRepository;
import com.jex.elasticsearch.entity.User;
import com.jex.elasticsearch.service.UserService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date 2020/4/16 10:45
 * @author jex
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> queryLikeFromUser(String searchKey) {
        List<User> list = new ArrayList<>();
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchKey);

        //  重点是下面这行代码
        builder.analyzer("myanalyzer").field("username").field("password").field("ip");
        Iterable<User> search = userRepository.search(builder);
        Iterator<User> iterator = search.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
