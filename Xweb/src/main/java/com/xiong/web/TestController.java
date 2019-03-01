package com.xiong.web;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.xiong.config.redis.util.RedisUtil;
import com.xiong.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping
    public Result testRedis(){
//        redisUtil.set("11","22");
        Map map = new HashMap();
        map.put("11","12");
        map.put("22","23");
        map.put("33","34");
        map.put("44","45");


        return new Result.Builder().success().build();
    }

    /**
     * @Author xiong
     * @Description 获取连接池数据
     * @Date 15:33 2019/3/1
     * @Param []
     * @return com.xiong.core.model.Result
     **/
    @GetMapping("/druid/stat")
    public Result druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return new Result.Builder().success(DruidStatManagerFacade.getInstance().getDataSourceStatDataList()).build();
    }
}
