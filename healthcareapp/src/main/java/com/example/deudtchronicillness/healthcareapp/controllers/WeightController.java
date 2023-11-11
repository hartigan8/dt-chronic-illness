package com.example.deudtchronicillness.healthcareapp.controllers;

import com.example.deudtchronicillness.healthcareapp.entities.Weight;
import com.example.deudtchronicillness.healthcareapp.services.WeightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weight")

public class WeightController {

    private WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping("/{patientId}")
    public List<Weight> getWeightDataById(@PathVariable Long patinetId){
        return weightService.getWeightById(patinetId);
    }

    @PostMapping
    public Weight addWeightData(@RequestBody Weight newWeight){
        return weightService.saveWeightData(newWeight);
    }

    @PutMapping("{patientId}")
    public Weight updateWeightData(@PathVariable Long patiendId, @RequestBody Weight newWeight){
        return weightService.updateWeightData(patiendId,newWeight);
    }

    @DeleteMapping("/{patientId}")
    public void deleteWeightData(@PathVariable Long patientId){
        weightService.deleteWeightDataById(patientId);
    }

}
