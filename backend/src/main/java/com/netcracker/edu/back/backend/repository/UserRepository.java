package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    Page<User> findAllByRoleNotIn(Pageable pageable, Role role);
    Page<User> findAllByRoleIn(Pageable pageable, Role role);
    User findByLogin(String login);
    User findByEmail(String email);
}
