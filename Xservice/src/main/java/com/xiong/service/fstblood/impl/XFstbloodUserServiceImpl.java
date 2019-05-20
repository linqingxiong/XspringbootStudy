package com.xiong.service.fstblood.impl;

import com.xiong.entity.fstblood.XFstbloodUserEntity;
import com.xiong.dao.fstblood.XFstbloodUserRepository;
//import com.xiong.entity.fstblood.XFstbloodUserEntity;
import com.xiong.service.fstblood.XFstbloodUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @Author xiong
 * @Description //TODO
 * @Date 14:46 2019/5/16
 **/

@SuppressWarnings({"ALL", "AlibabaClassNamingShouldBeCamel"})
@Service("XFstbloodUserService")
public class XFstbloodUserServiceImpl implements XFstbloodUserService {
    @Autowired
    private XFstbloodUserRepository repository;

//    @Override
//    public List<XFstbloodUserEntity> findAllByPage(int page, int limit) {
//        Pageable pageable = PageRequest.of(page,limit);
//
//
//        repository
//    }

    @Override
    public void saveUser(XFstbloodUserEntity user) {
        repository.save(user);
    }

    @Override
    @Transactional(transactionManager = "transactionManagerFstblood",rollbackFor = Exception.class)
    public void saveUsers(List<XFstbloodUserEntity> users) {
        users.forEach(user -> repository.save(user));
    }

}
