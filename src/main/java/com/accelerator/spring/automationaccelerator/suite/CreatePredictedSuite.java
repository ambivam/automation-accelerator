package com.accelerator.spring.automationaccelerator.suite;

import com.accelerator.spring.automationaccelerator.entity.Predictions;
import com.accelerator.spring.automationaccelerator.repository.PredictionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("dbsuite")
public class CreatePredictedSuite {

    @Autowired
    PredictionsRepository eRepo;

    @Value("${probability}")
    Double probabilityFailure;

    @Value("${suitename}")
    String suiteName;

    public void createPredictedTestSuite(){
        List<Predictions> tcList = eRepo.findByProbabilityfailureGreaterThan(probabilityFailure);

        /*System.out.println("first row create testcase is "+predictions.getUsid()+"_"+predictions.getTcid());*/
        createSuite(tcList);
    }

    private void createSuite(List<Predictions> tcList){

        TestNG myTestNG = new TestNG();
        XmlSuite mySuite = new XmlSuite();
        mySuite.setName(suiteName);
        mySuite.setParallel(XmlSuite.ParallelMode.TESTS);

        XmlTest myTest = new XmlTest(mySuite);
        myTest.setName(suiteName);
        List<XmlClass> myClasses = new ArrayList<XmlClass>();

        int loopIndex = 0;

        for(Predictions prediction : tcList ){
            try{
                if(loopIndex == 0){
                    String temp = "com.accelerator.spring.automationaccelerator.googletest."+prediction.getUsid()+"_"+prediction.getTcid();
                    //String temp = "com.accelerator.spring.automationaccelerator.googletest.Google2Test";
                    System.out.println("Created class is "+temp);
                    myClasses.add(new XmlClass(temp));
                }
                ++loopIndex;

            }catch(Exception e){
                System.out.println("Unable to find class "+prediction.getUsid()+"_"+prediction.getTcid());
            }
        }
        myTest.setXmlClasses(myClasses);
        System.out.println("1");
        List<XmlTest> myTests = new ArrayList<XmlTest>();
        myTests.add(myTest);
        System.out.println("2");
        mySuite.setTests(myTests);
        System.out.println("3");
        List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
        mySuites.add(mySuite);
        System.out.println("4");
        myTestNG.setXmlSuites(mySuites);
        System.out.println("5");
        mySuite.setFileName(mySuite+".xml");
        mySuite.setThreadCount(3);

        for(XmlSuite suite : mySuites)
        {
            createXmlFile(suite,suiteName);
        }
        System.out.println("File generated successfully.");


    }

    private void createXmlFile(XmlSuite mSuite,String suitename)
    {
        FileWriter writer;
        String dir = System.getProperty("user.dir");
        try {
            writer = new FileWriter(new File(dir+"//suites//"+suitename+".xml"));
            writer.write(mSuite.toXml());
            writer.flush();
            writer.close();
            //System.out.println(new File("myTemp.xml").getAbsolutePath());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
