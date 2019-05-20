package com.xiong.service.fstblood;


import com.xiong.entity.fstblood.XFstbloodUserEntity;
//import com.xiong.entity.fstblood.XFstbloodUserEntity;

import java.util.List;

public interface XFstbloodUserService {
//    List<XFstbloodUserEntity> findAllByPage(int page,int limit);
    void saveUser(XFstbloodUserEntity user);
    void saveUsers(List<XFstbloodUserEntity> users);
}