package com.api.TestApi.Service;

import java.util.List;

public interface TestService {

	void storeAllData();

	List<String> getPostById(int id);

	List<Object> getUserInfo(int id);

}
