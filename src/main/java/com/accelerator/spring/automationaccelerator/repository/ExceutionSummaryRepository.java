package com.accelerator.spring.automationaccelerator.repository;

import com.accelerator.spring.automationaccelerator.entity.ExecutionSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;

public interface ExceutionSummaryRepository extends JpaRepository<ExecutionSummary,String> {
    @Modifying
    @Query(value = "insert into ExecutionSummary(tcid,testcasetitle,browser,browserversion,os,osversion,status,build,module,executeddate) values (:tcid,:testcasetitle,:browser,:browserversion,:os,:osversion,:status,:build,:module,:executeddate)", nativeQuery = true)
    @Transactional
    void insertSummaryInfo(@Param("executeddate") Timestamp executeddate, @Param("tcid") String tcid, @Param("testcasetitle") String testcasetitle,
                           @Param("browser") String browser, @Param("browserversion") String browserversion,
                           @Param("os") String os, @Param("osversion") String osversion,
                           @Param("status") String status, @Param("build") String build,
                           @Param("module") String module);
}


