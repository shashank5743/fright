package com.example.fright.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FreightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double weight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logistics_id", referencedColumnName = "id")
    private LogisticsEntity logistics;

}

