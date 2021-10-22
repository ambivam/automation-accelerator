package com.accelerator.spring.automationaccelerator.excel;

import com.accelerator.spring.automationaccelerator.entity.Predictions;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

@Component
public class PredictionResults {


    public List<Predictions> readPredictionsFromExcel(String fileName){
        Vector dataHolder=read(fileName);
        return saveToDatabase(dataHolder);
    }

    private Vector read(String fileName)    {
        Vector cellVectorHolder = new Vector();
        try{
            FileInputStream myInput = new FileInputStream(fileName);
            //POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            XSSFSheet mySheet = myWorkBook.getSheetAt(2);
            Iterator rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                //Vector cellStoreVector=new Vector();
                List list = new ArrayList();
                while(cellIter.hasNext()){
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    list.add(myCell);
                }
                cellVectorHolder.addElement(list);
            }
        }catch (Exception e){e.printStackTrace(); }
        return cellVectorHolder;
    }
    private List<Predictions> saveToDatabase(Vector dataHolder) {
        String sprintid="";
        String usid="";
        String tcid="";
        String   tagline="";
        String testcasetitle="";
        String teststeps = "";
        Double probabilityfailure = 0.0;
        String predictions = "";
        /*String testcases = "";*/

        List<Predictions> predictionResultsList = new ArrayList<Predictions>();
        int loopIter = 0;
        for(Iterator iterator = dataHolder.iterator();iterator.hasNext();) {

            List list = (List) iterator.next();
            sprintid = list.get(0).toString();
            usid = list.get(1).toString();
            tcid = list.get(2).toString();
            tagline = list.get(3).toString();
            testcasetitle = list.get(4).toString();
            teststeps = list.get(5).toString();

            System.out.println("The double precision is :"+list.get(6).toString());
            if(loopIter != 0 ){
                probabilityfailure = Double.parseDouble(list.get(6).toString());
            }
            predictions = list.get(7).toString();
            if(loopIter != 0 ){
                predictionResultsList.add(new Predictions(tcid,sprintid,usid,tagline,testcasetitle,predictions,probabilityfailure));
            }
            ++loopIter;
        }
        System.out.println("predictionResultsList length is " +predictionResultsList.size());
        return predictionResultsList;

    }

}
