package com.rimi.service;

import com.rimi.entity.User;

import java.util.List;

/**
 * 查询用户
 *
 * @author wjy
 * @date 2019/9/29 0029 23:34
 */
public interface selectUserSerivce {

    /**
     * 查询用户操作
     * @return
     */
    List<User> selectAllUser();

}
