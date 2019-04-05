package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
   Role findRoleByName(String name);
}
