package com.accelerator.spring.automationaccelerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseTable {

    @Id
    private String tcid;
    /*private String tagline;*/
    private String testcasetitle;
    /*@Column(length = 50000)*/
    private String teststeps;
    private String status;

}
