package com.marondal.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.test.mybatis.domain.RealEstate;

@Repository
public interface RealEstateRepository {
	
	// 전달받은 id와 일치하는 한행의 매물정보를 돌려주는 기능
	public RealEstate selectRealEstate(@Param("id") int id);
	
	// 전달받은 월세보다 낮은 매물 정보 행들을 돌려주는 기능
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);

	// 가격 넓이 조건때 맞는 매물 정보 행을 돌려주는 기능
	public List<RealEstate> selectRealEstateByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	public int insertRealEstateByObject(RealEstate realEstate);
	
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	
	public int updateRealEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	
	
	public int deleteRealEstate(@Param("id") int id);

}
