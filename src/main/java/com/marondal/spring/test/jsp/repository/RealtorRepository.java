package com.marondal.spring.test.jsp.repository;

import org.springframework.stereotype.Repository;

import com.marondal.spring.test.jsp.domain.Realtor;

@Repository
public interface RealtorRepository {
	
	public int insertRealtor(Realtor realtor);

}
