package com.example.deudtchronicillness.healthcareapp.controllers;

import com.example.deudtchronicillness.healthcareapp.entities.Water;
import com.example.deudtchronicillness.healthcareapp.services.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    WaterService waterService;

    @PostMapping
    public Water addWaterData(@RequestBody Water newWater){
        return waterService.saveOneWater(newWater);
    }
}
