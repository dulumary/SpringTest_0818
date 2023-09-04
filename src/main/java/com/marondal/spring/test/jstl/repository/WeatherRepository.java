package com.marondal.spring.test.jstl.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.test.jstl.domain.Weather;

@Repository
public interface WeatherRepository {

	public List<Weather> selectWeatherHistory();
	
	public int insertWeather(
			@Param("date") Date date
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microDust
			, @Param("windSpeed") double windSpeed);
}
