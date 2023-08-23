package com.marondal.spring.test.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.marondal.spring.test.database.domain.Store;

@Repository
public interface StoreRepository {
	
	// store 테이블의 모든 행 조회
	public List<Store> selectStoreList();

}
