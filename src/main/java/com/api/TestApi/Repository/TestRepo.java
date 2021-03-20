package com.api.TestApi.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.TestApi.POJO.TestPOJO;

@Repository
public interface TestRepo extends CrudRepository<TestPOJO,Integer>{
	public List<TestPOJO> findAllByUserId(int id);
	public boolean existsByUserId(int id);

}
