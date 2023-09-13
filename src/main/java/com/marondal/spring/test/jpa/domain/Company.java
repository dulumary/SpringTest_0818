package com.marondal.spring.test.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
@Getter
@Table(name="company")
@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String business;
	private String scale;
	private int headcount;
	
	@UpdateTimestamp
	@Column(name="createdAt", updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private Date updatedAt;

}
