package com.example.deudtchronicillness.healthcareapp.repos;

import com.example.deudtchronicillness.healthcareapp.entities.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightRepository extends JpaRepository<Weight,Long> {
    List<Weight> findByPatientId(Long patientId);

}
