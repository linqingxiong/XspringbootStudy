package com.xiong.controller;

import com.xiong.config.annotation.WebLog;
import com.xiong.core.model.Result;
import com.xiong.entity.fstblood.XFstbloodUserEntity;
import com.xiong.service.fstblood.XFstbloodUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainController
 * @Description TODO
 * @Author YuanMa
 * @Date 2019/5/16 10:04
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "main")
public class MainController {

    @Autowired
    XFstbloodUserService xFstbloodUserService;

    @WebLog
    @RequestMapping(value = "test")
    public Result test() {
        return new Result.Builder().success("success").build();
    }

    @WebLog
    @RequestMapping(value = "addusers")
    public Result addUsers() {
        List<XFstbloodUserEntity> users = new ArrayList<>();
        XFstbloodUserEntity user1 = new XFstbloodUserEntity("aaa", 10, "4", "1");
        XFstbloodUserEntity user2 = new XFstbloodUserEntity("bbb", 10, "4", "2");
        XFstbloodUserEntity user3 = new XFstbloodUserEntity("ccc", 10, "4", "3");
        XFstbloodUserEntity user4 = new XFstbloodUserEntity("ddd", 10, "4", "3");
        XFstbloodUserEntity user5 = new XFstbloodUserEntity("eee", 10, "4", "5");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        xFstbloodUserService.saveUsers(users);
        return new Result.Builder().success().build();
    }

//    @WebLog
//    @RequestMapping(value = "all",method = RequestMethod.GET)
//    public Result findAll(@RequestParam(value = "page")Integer page,@RequestParam(value = "limit")Integer limit){
//        xFstbloodUserService.
//    }
}
