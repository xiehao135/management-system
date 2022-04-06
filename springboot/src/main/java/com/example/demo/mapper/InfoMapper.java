package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Info;

public interface InfoMapper extends BaseMapper<Info> {
    //一对多查询
    Page<Info> findPage(Page<Info> page);
}
