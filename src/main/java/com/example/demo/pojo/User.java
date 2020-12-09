package com.example.demo.pojo;


import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
@Data
public class User implements Serializable {

    private Integer id;//主键ID
    private String username;//用户名
    private String address;//地址
//    private String del;//删除操作

}
