package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_UUID;

/**
 * @author zhanglf
 * @Date 2021/4/11 下午9:36
 */
@Data
public class BaseEntity {
    @TableId(type = ASSIGN_UUID)
    private String id;
}
