package com.nitesh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.springboot.entity.Persons;

@RestController
public class RedisController {


	@Autowired
	private RedisTemplate<String, Persons> template;


	@PostMapping("/add")
	public String addPerson(@RequestBody Persons pr) {

		template.opsForHash().put("Persons", pr.getPid(), pr);

		return "Success";
	}



	@GetMapping("/get/{id}")
	public Persons getPerson(@PathVariable Integer id) {

		return (Persons) template.opsForHash().get("Persons", id);
	}



	@GetMapping("/get")
	public List<Object> getAll(){

		return template.opsForHash().values("Persons");
	}


	@DeleteMapping("/delete/{id}")
	public String deletePerson(@PathVariable Integer id) {

		template.opsForHash().delete("Persons", id);

		return "Person Successfully deleted";
	}


}
