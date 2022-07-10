package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Evento;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {

}
