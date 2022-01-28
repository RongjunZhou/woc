package com.example.woc.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 信安小军
 * @create: 2022-01-15 03:54
 **/

@Data//get set toString hashcode方法
@AllArgsConstructor//全参构造方法
@NoArgsConstructor//无参构造
public class Account {
    @Id
    @GeneratedValue
    private Integer id;//主键
    private String username;
    private String password;
    private String email;
}
