package com.example.demo.mongod.rest;

import com.example.demo.mongod.entity.Shop;
import com.example.demo.mongod.repository.ShopRepository;
import com.example.demo.mongod.util.MongodPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglf
 * @Date 2021/4/28 下午9:42
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    // 分页获取mongodb中的店铺信息
    @GetMapping("page")
    public Map<String, Object> getShopByPage() {
        Pageable pageable = new MongodPageable();
        Page<Shop> list = shopRepository.findAll(pageable);
        Map<String, Object> result = new HashMap<>();
        result.put("data", list);
        return result;
    }

}
