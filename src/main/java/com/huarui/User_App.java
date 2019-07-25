package com.huarui;

import com.huarui.config.MySelfRule;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
//@EnableAutoConfiguration
@MapperScan(value = "com.huarui.dao")
@ComponentScan(basePackages = {"com.huarui"})
@EnableCircuitBreaker
//@RibbonClient(name="HUARUIDISHES",configuration = MySelfRule.class)
@RibbonClients(value = {
		@RibbonClient(name = "HUARUIDISHES",configuration = MySelfRule.class),

})
@EnableFeignClients(basePackages = {"com.huarui"})
public class User_App
{



	@Bean
	public ServletRegistrationBean getServlet(){

		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");

		return registrationBean;

	}

	public static void main(String[] args)
	{


		SpringApplication.run(User_App.class, args);
	}
}
