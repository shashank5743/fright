package com.example.fright.repositry;


import com.example.fright.entity.FreightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightRepository  extends CrudRepository<FreightEntity, Long> {

    List<FreightEntity> findAll();
}

