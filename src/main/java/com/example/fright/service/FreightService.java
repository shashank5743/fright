package com.example.fright.service;


import com.example.fright.entity.FreightEntity;
import com.example.fright.entity.LogisticsEntity;
import com.example.fright.repositry.FreightRepository;
import com.example.fright.repositry.LogisticsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FreightService {
    private final FreightRepository freightRepository;
    private final LogisticsRepository logisticsRepository;

    public FreightService(FreightRepository freightRepository, LogisticsRepository logisticsRepository) {
        this.freightRepository = freightRepository;
        this.logisticsRepository = logisticsRepository;
    }


    public List<FreightEntity> getAllFreight() {
        return freightRepository.findAll();
    }

    public FreightEntity getFreightById(Long id) {
        return freightRepository.findById(id).orElse(null);
    }

    public FreightEntity createFreight(FreightEntity freight) {
        // Validate freight data
        if (freight.getWeight() <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }

        // Create logistics information
        LogisticsEntity logistics = new LogisticsEntity();
        logistics.setDeliveryTime(LocalDateTime.now().plusDays(3));
        logistics.setDeliveryAddress("123 Main Street, City");

        freight.setLogistics(logistics);

        return freightRepository.save(freight);
    }

    public void deleteFreight(Long id) {
        freightRepository.deleteById(id);
    }
}

