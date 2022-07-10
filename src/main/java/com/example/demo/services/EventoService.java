package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Evento;
import com.example.demo.repos.EventoRepo;

@Service
@Configurable
public class EventoService {
	@Autowired
	EventoRepo repo;
	public List<Evento> ListAll(){
		return repo.findAll();
	}
	public void Save(Evento evt) {
		repo.save(evt);
	}

}
