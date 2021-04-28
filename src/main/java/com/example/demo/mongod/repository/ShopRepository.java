package com.example.demo.mongod.repository;

import com.example.demo.mongod.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhanglf
 * @Date 2021/4/28 下午10:00
 */
public interface ShopRepository extends MongoRepository<Shop, String> {

}
