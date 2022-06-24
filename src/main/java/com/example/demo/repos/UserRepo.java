package com.example.demo.repos;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUserByUsername(@Param("email") String email);
}
