package com.example.demo.entity;

import com.example.demo.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlf
 * @since 2021-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String pwd;

    private String email;

    private String gender;


}
