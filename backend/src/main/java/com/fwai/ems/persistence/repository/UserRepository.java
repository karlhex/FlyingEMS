package com.fwai.ems.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.fwai.ems.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

		Optional<User> findFirstByEmail(String email);

		Optional<User> findFirstById(Integer id);
}
