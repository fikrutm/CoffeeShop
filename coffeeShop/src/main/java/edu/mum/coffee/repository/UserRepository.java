package edu.mum.coffee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.coffee.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
