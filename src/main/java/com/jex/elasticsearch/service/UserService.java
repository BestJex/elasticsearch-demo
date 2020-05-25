package com.jex.elasticsearch.service;


import com.jex.elasticsearch.entity.User;

import java.util.List;

/**
 * @date 2020/4/16 10:45
 * @author jex
 */
public interface UserService {
    List<User> queryLikeFromUser(String searchKey);
}
