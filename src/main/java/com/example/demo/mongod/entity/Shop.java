package com.example.demo.mongod.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author zhanglf
 * @Date 2021/4/28 下午9:42
 */
@Data
@Document(collection="eatall")
public class Shop {
    @Id
    private String id;
    private String shopId;
    private String shopScore;
    private String commentNum;
    private String avgPrice;
    private String label1;
    private String label2;
    private String address;
    private String recommend;
    private String detailScore;
    private String img;
    private String detailUrl;
}
