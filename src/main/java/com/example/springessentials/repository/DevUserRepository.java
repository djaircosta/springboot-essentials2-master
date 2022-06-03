package com.example.springessentials.repository;

import com.example.springessentials.domain.Anime;
import com.example.springessentials.domain.DevUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevUserRepository extends JpaRepository<DevUser, Long> {

    DevUser findByUsername(String username);

}
