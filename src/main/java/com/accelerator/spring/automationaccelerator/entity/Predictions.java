package com.accelerator.spring.automationaccelerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Predictions {

    @Id
    private String tcid;
    private String sprintid;
    private String usid;
    private String tagline;
    private String testcasetitle;
    /*@Lob
    @Column(length = 50000)
    private String teststeps;*/
    private String predictions;
    private Double probabilityfailure;
    /*private String testcases;*/


}
