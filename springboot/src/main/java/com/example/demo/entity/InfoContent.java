package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("info_content")
@Data
public class InfoContent {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer info_id;
    private String content;
}