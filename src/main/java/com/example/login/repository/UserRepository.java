package com.example.login.repository;

import com.example.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmail(String email);

    @Query(value = "select u.user_id,u.name,u.last_name,u.email,r.role from user u JOIN user_role ur ON(ur.user_id=u.user_id) JOIN role r ON (ur.role_id=r.role_id)",nativeQuery = true)
    List<List<String>> Userdetail();
}