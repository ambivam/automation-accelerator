package com.accelerator.spring.automationaccelerator.repository;

import com.accelerator.spring.automationaccelerator.entity.TestCaseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;



public interface TestCaseRepository extends JpaRepository<TestCaseTable,String> {

    @Modifying
    @Query(value = "insert into TestCaseTable(tcid,testcasetitle,teststeps,status) values (:tcid,:testcasetitle,:teststeps,:status)",nativeQuery=true)
    @Transactional
    void insertTestInfo(@Param("tcid") String tcid,@Param("testcasetitle") String testcasetitle,
                        @Param("teststeps") String teststeps,@Param("status") String status);
}
