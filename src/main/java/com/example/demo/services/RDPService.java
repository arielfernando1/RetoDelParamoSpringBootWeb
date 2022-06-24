package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repos.UserRepo;

@Service
@Configurable
public class RDPService {
	@Autowired
	UserRepo repo;
	public List <User> ListAll(){
		return repo.findAll();	
	}
	public void Save(User usr) {
		repo.save(usr);
	}
	public User Get(long id) {
		return repo.findById(id).get();
	}
	public void Delete(long id) {
		repo.deleteById(id);
	}
}
