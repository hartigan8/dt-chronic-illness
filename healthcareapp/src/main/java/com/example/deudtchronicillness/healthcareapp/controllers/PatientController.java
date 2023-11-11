package com.example.deudtchronicillness.healthcareapp.controllers;


import com.example.deudtchronicillness.healthcareapp.entities.Patient;
import com.example.deudtchronicillness.healthcareapp.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return this.patientService.getAllPatients();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient newPatient){
        return patientService.saveOnePatient(newPatient);
    }

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable Long patientId){
        return patientService.getOneUser(patientId);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable Long patientId, @RequestBody Patient newPatient){
        return patientService.updateOnePatient(patientId,newPatient);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable Long patientId){
        patientService.deleteById(patientId);
    }



}
