package com.jex.elasticsearch.service;


import com.jex.elasticsearch.entity.RequestLog;
import com.jex.elasticsearch.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @date 2020/4/16 10:45
 * @author jex
 */
public interface RequestLogService {

     String esInsert(Integer num) ;


     Iterable<RequestLog> esFindAll ();

     String esUpdateById(RequestLog requestLog) ;

     Optional<RequestLog> esSelectById(Long id) ;

     Iterable<RequestLog> esFindOrder() ;

     Iterable<RequestLog> esFindOrders();

     Iterable<RequestLog> search() ;
}
