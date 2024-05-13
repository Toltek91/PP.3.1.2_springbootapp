package com.toltek.springbootapp.repository;

import com.toltek.springbootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
