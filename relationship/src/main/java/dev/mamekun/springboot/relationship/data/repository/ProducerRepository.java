package dev.mamekun.springboot.relationship.data.repository;

import dev.mamekun.springboot.relationship.data.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

}
