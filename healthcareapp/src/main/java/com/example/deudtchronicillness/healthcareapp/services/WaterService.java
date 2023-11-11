package com.example.deudtchronicillness.healthcareapp.services;

import com.example.deudtchronicillness.healthcareapp.entities.Water;
import com.example.deudtchronicillness.healthcareapp.repos.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterService {
    @Autowired
    private WaterRepository waterRepository;


    public Water saveOneWater(Water water){
        return waterRepository.save(water);
    }
}
