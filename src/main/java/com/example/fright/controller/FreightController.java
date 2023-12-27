package com.example.fright.controller;


import com.example.fright.entity.FreightEntity;
import com.example.fright.service.FreightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/freight")
public class FreightController {
    private final FreightService freightService;

    @Autowired
    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    @GetMapping
    public List<FreightEntity> getAllFreight() {
        return freightService.getAllFreight();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreightEntity> getFreightById(@PathVariable Long id) {
        FreightEntity freight = freightService.getFreightById(id);
        if (freight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(freight, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FreightEntity> createFreight(@Valid @RequestBody FreightEntity freight) {
        try {
            FreightEntity createdFreight = freightService.createFreight(freight);
            return new ResponseEntity<>(createdFreight, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFreight(@PathVariable Long id) {
        try {
            freightService.deleteFreight(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
