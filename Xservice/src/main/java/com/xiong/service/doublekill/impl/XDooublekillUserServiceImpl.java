package com.xiong.service.doublekill.impl;

import com.xiong.dao.doublekill.XDoublekillUserRepository;
import com.xiong.service.doublekill.XDoublekillUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("XDooublekillUserService")
public class XDooublekillUserServiceImpl implements XDoublekillUserService {
    @Autowired
    private XDoublekillUserRepository repository;
}
