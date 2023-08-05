package com.nitesh.springboot.entity;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Persons")
public class Persons implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 6470701312365807883L;

	@Id
	private Integer pid;

	private String name;

	private String city;

	private Integer age;

}
