package com.huarui.service.fallback;

import com.huarui.service.DishService;
import org.springframework.stereotype.Service;

/**
 * Created by sloan on 2019/7/15.
 */

@Service
public class DishServiceFallback implements DishService {
    @Override
    public String get(Long id) {

        System.out.println("请求失败...");
        return "请求失败..k8s";
    }
}
