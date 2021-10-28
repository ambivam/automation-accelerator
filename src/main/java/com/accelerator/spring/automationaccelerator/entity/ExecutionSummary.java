package com.accelerator.spring.automationaccelerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionSummary {

    private String tcid;
    private String testcasetitle;
    private String browser;
    private Double browserversion;
    private String os;
    private String osversion;
    private String status;
    @Id
    private String build;

    private String module;
    @CreationTimestamp
    @Column(name="executeddate ", nullable = false, updatable = false, insertable = false)
    private Timestamp executeddate;
}
