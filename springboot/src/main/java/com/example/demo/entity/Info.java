package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("user")
@Data
public class Info {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    //表示以下数据并不是在数据库中存在
    @TableField(exist = false)
    private List<InfoContent> contentList;
}