package com.example.deudtchronicillness.healthcareapp.repos;

import com.example.deudtchronicillness.healthcareapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
