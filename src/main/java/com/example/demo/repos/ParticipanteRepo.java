package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Participante;

@Repository
public interface ParticipanteRepo extends JpaRepository<Participante, Long> {

}
