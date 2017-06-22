package edu.mum.coffee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.coffee.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
