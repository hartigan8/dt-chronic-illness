package com.example.deudtchronicillness.healthcareapp.services;

import com.example.deudtchronicillness.healthcareapp.entities.Patient;
import com.example.deudtchronicillness.healthcareapp.repos.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAlPatients(){
        return patientRepository.findAll();
    }

    public Patient saveOnePatient(Patient newPatient){
        return patientRepository.save(newPatient);
    }

    public Patient getOneUser(Long userId){
        return patientRepository.findById(userId).orElse(null);
    }

    public Patient updateOnePatient(Long userId, Patient newPatient) {
        Optional<Patient> patient = patientRepository.findById(userId);
        if (patient.isPresent()){
            Patient foundedPatient = patient.get();
            foundedPatient.setName(newPatient.getName());
            foundedPatient.setSurname(newPatient.getSurname());
            foundedPatient.setHeight(newPatient.getHeight());
            foundedPatient.setDateOfBirth(newPatient.getDateOfBirth());
            patientRepository.save(foundedPatient);
            return foundedPatient;
        }
        else return null;
    }

    public void deleteById(Long userId){
        patientRepository.deleteById(userId);
    }

}

