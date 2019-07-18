package com.huarui.controller;



import com.huarui.config.MyRestTemplate;
import com.huarui.service.AccountService;
import com.huarui.service.DishService;
import com.huarui.service.mq.MqProducer;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController
{


	@Autowired
	AccountService accountService;


	@Autowired
	MyRestTemplate myRestTemplate;

	@Autowired
	DishService dishService;

	@Autowired
	MqProducer mqProducer;

	public static String DISH_URI = "http://HUARUIDISHES";

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get()
	{
		return accountService.findAccountById(1L).getName();
	}

	@RequestMapping(value = "/testDish", method = RequestMethod.GET)
	public String testDish()
	{

		return myRestTemplate.initMyRestTemplate().getForObject(DISH_URI + "/get/1", String.class);
	}


	@RequestMapping(value = "/testDishFeign", method = RequestMethod.GET)
	public String testDishFeigh()
	{


		return  dishService.get(1L)+",from feign";
	}




	@RequestMapping(value = "/orderDish/{userId}/{dishId}", method = RequestMethod.GET)
	public String orderDish(@PathVariable("userId") Long userId,@PathVariable("dishId") Long dishId)
	{


		System.out.println("userId:"+userId+",dishId:"+dishId);

		mqProducer.orderDish(userId,dishId);
		return "您点的菜已经交给后厨处理...请耐心等待";
	}

}
