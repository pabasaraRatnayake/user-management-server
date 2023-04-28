package com.example.usermanagementserver.repository;

import com.example.usermanagementserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository <User, Long>{

}
