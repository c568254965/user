package com.huarui.controller;



import com.huarui.config.MyRestTemplate;
import com.huarui.service.AccountService;
import com.huarui.service.DishService;
import com.huarui.service.mq.MqProducer;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
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
	public static String DISH_PREFIX = "/csrr/dish";

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get()
	{

		log.info("this is get.....");
		return accountService.findAccountById(1L).getName();

	}

	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	public String get1()
	{

		log.info("this is get1.....");
		return accountService.findAccountById(1L).getName();

	}

	@RequestMapping(value = "/testDish", method = RequestMethod.GET)
	public String testDish()
	{

		return myRestTemplate.initMyRestTemplate().getForObject(DISH_URI +DISH_PREFIX + "/get/1", String.class);
	}


	@RequestMapping(value = "/testDishFeign", method = RequestMethod.GET)
	public String testDishFeigh()
	{

		System.out.println("通过feign请求....");
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
