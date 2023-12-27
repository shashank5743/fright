package com.example.fright.repositry;


import com.example.fright.entity.LogisticsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsRepository extends CrudRepository<LogisticsEntity, Long> {
}

