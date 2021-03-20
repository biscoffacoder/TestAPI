package com.api.TestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.TestApi.Service.TestService;

@RestController
public class TestController {
	@Autowired
	TestService service;

	@GetMapping("/posts/{id}")
	public List<String> getPostsById(@PathVariable("id") int id)
	{
		 
		return service.getPostById(id);
	}
	
	@GetMapping("users/{id}")
	public List<Object> getUserInfo(@PathVariable("id")int id)
	{
		
		return service.getUserInfo(id);
	}

	@GetMapping("/storeAll")
	public String storeAllData() 
	{
		service.storeAllData();
		return "Data has been stored to Repository";
	}

}
