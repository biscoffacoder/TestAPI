package com.api.TestApi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.TestApi.POJO.TestPOJO;
import com.api.TestApi.Repository.TestRepo;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TestRepo repo;


	@Override
	public void storeAllData() {
		final String uri = "https://jsonplaceholder.typicode.com/posts/";
		final String uri1 = "https://api.covid19india.org/data.json";
		//
		//TODO: Autowire the RestTemplate in all the examples


		ResponseEntity<TestPOJO[]> response = restTemplate.getForEntity(uri, TestPOJO[].class);
		TestPOJO[] testPojo = response.getBody();

		System.out.println(testPojo[2]);
		for(TestPOJO obj:testPojo) 
		{
			repo.save(obj);

		}
		


	}


	@Override
	public List<String> getPostById(int id) {
		List<String> responseList;
		if(repo.existsById(id)) {
			responseList = new ArrayList<String>();
	
		Optional<TestPOJO> response = repo.findById(id);
		
		responseList.add("userId -  "+response.get().getUserId() +" postId - "+response.get().getId()+" post - "+response.get().getTitle()+ " Body - "+response.get().getBody());
		
		}else 
		{
			responseList = new ArrayList<String>();
			responseList.add("No Data found for given ID, ID should be between 1-100 and save Data must be called before executing this call");
			
		}
		
		
		return responseList;
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Object> getUserInfo(int id) {
		List<Object> usersList;
		if(repo.existsByUserId(id)) {
			usersList = new ArrayList<Object>();
			List<TestPOJO> response = repo.findAllByUserId(id);
			usersList.add(response);
			
		}else 
		{
			usersList = new ArrayList<Object>();
			usersList.add("No Data found for given user ID, ID should be between 1-10 and save Data must be called before executing this call");
			
		}
		// TODO Auto-generated method stub
		return usersList;
	}

}
