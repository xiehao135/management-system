package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.sql.Date;

@TableName("userinfo")
@Data
public class UserInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String address;
    private Date date;
    private String name;
    private String tag;
}
