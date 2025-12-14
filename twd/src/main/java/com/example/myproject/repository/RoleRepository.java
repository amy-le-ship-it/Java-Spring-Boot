package com.example.myproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myproject.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    com.example.myproject.domain.Role findByName(String name);
}
