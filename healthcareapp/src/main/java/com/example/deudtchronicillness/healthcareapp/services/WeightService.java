package com.example.deudtchronicillness.healthcareapp.services;

import com.example.deudtchronicillness.healthcareapp.entities.Weight;
import com.example.deudtchronicillness.healthcareapp.repos.WeightRepository;

import java.util.List;
import java.util.Optional;

public class WeightService {

    private WeightRepository weightRepository;
    public List<Weight> getWeightById(Long patientId) {
        return weightRepository.findByPatientId(patientId);
    }


    public Weight saveWeightData(Weight newWeight) {
        return weightRepository.save(newWeight);
    }

    public Weight updateWeightData(Long patientId, Weight newWeight) {
    Optional<Weight> weight = weightRepository.findById(patientId);
    if(weight.isPresent()){
        Weight foundedWeight = weight.get();
        foundedWeight.setResult(newWeight.getResult());
        foundedWeight.setWeightType(newWeight.getWeightType());
        foundedWeight.setTargetWeight(newWeight.getTargetWeight());
        weightRepository.save(foundedWeight);
        return foundedWeight;
    }
    else return null;

    }

    public void deleteWeightDataById(Long patientId) {
        weightRepository.deleteById(patientId);
    }
}
