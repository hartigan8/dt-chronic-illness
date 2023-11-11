package com.example.deudtchronicillness.healthcareapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table (name = "weight")
@Data

public class Weight {

    Long id;


    private String weightType;

    private String result;
    @Id
    private Date dateofMeasurement;
    private Integer targetWeight;




}
