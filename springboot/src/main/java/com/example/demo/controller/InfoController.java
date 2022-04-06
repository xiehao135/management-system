package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/info") //在Vue中引用时需要声明
public class InfoController {
    @Resource
    InfoMapper infoMapper;

    //后台分页模糊查询
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Info> wrapper = Wrappers.<Info>lambdaQuery();
        if(StringUtils.isNotBlank(search)){
            wrapper.like(Info::getId,search);
        }
        Page<Info> infoPage = infoMapper.findPage(new Page<>(pageNum,pageSize));
        return Result.success(infoPage);
    }
}