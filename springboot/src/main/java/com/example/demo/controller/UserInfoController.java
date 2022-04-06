package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/userinfo") //在Vue中引用时需要声明
public class UserInfoController {
    @Resource
    UserInfoMapper userInfoMapper;
    //后台分页模糊查询
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        Page<UserInfo> userInfoPage = userInfoMapper.selectPage(new Page<>(pageNum,pageSize), Wrappers.<UserInfo>lambdaQuery().like(UserInfo::getId,search));
        return Result.success(userInfoPage);
    }
}
