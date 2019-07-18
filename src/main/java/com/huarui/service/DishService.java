package com.huarui.service;

import com.huarui.service.fallback.DishServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by sloan on 2019/7/15.
 */

@Service("dishService")
@FeignClient(value = "HUARUIDISHES",fallback = DishServiceFallback.class)
public interface DishService {


    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") Long id);
}
