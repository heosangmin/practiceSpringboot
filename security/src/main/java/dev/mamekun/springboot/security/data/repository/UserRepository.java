package dev.mamekun.springboot.security.data.repository;

import dev.mamekun.springboot.security.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);

}
