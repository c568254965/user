package com.huarui.service;

import com.huarui.service.fallback.DishServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sloan on 2019/7/15.
 */

@Service("dishService")                              //禁用hystrix降级..configuration = FeignDisableHystrixConfiguration.class
@FeignClient(value = "HUARUIDISHES",fallback = DishServiceFallback.class)
public interface DishService {


    /**
     * 如果返回对象是map,可以用同属性名的对象接收。
     */

    @GetMapping("/csrr/dish/get/{id}")
    public String get(@PathVariable("id") Long id);
//
//    @RequestMapping(value = "uri",consumes = "application/json",method = RequestMethod.GET)
//    public String get1(@RequestBody);
}
