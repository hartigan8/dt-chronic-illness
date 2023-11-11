package com.example.deudtchronicillness.healthcareapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table ( name = "step" )
@Data


public class Step {

    private Long id;


    private Integer targetstep;
    private Integer endofTheDayStep;

    @Id
    private Date date;

}
