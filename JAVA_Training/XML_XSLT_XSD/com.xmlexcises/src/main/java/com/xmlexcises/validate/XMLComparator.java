package com.xmlexcises.validate;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;


public class XMLComparator {
 
 
    public static void main(String args[]) throws FileNotFoundException, 
                                                  SAXException, IOException {
     XMLComparator x = new XMLComparator();
    boolean ship =  x.compareXML("D:\\Excises6\\com.xmlexcises\\src\\main\\java\\com\\xmlexcises\\validate\\ship.xml", "D:\\Excises6\\com.xmlexcises\\Shipment.out.xml");
    boolean Request3 = x.compareXML("D:\\Excises6\\com.xmlexcises\\src\\main\\java\\com\\xmlexcises\\validate\\Response3.xml", "D:\\Excises6\\com.xmlexcises\\Request3.out.xml");
    boolean Request2 = x.compareXML("D:\\Excises6\\com.xmlexcises\\src\\main\\java\\com\\xmlexcises\\validate\\Response2.xml", "D:\\Excises6\\com.xmlexcises\\Request2.out.xml");
    boolean Request1 = x.compareXML("D:\\Excises6\\com.xmlexcises\\src\\main\\java\\com\\xmlexcises\\validate\\Response1.xml", "D:\\Excises6\\com.xmlexcises\\Request1.out.xml");
    System.out.println("Shipment :: "+ ship);
    System.out.println("Request3 ::" +Request3);
    System.out.println("Request2 ::"+ Request2);
    System.out.println("Request1 ::"+ Request1);
   
    }    
    public static boolean compareXML(String string,String string2) throws SAXException, IOException
    {
    
        // reading two xml file to compare in Java program
        FileInputStream fis1 = new FileInputStream(string);
        FileInputStream fis2 = new FileInputStream(string2);
     
        // using BufferedReader for improved performance
        BufferedReader  source = new BufferedReader(new InputStreamReader(fis1));
        BufferedReader  target = new BufferedReader(new InputStreamReader(fis2));
     
        //configuring XMLUnit to ignore white spaces
        XMLUnit.setIgnoreWhitespace(true);
     
        //comparing two XML using XMLUnit in Java
        ArrayList differences = (ArrayList) compareXML(source, target);
     
        //showing differences found in two xml files
      boolean a =   printDifferences(differences);
      return a;
    }
 
    public static List compareXML(Reader source, Reader target) throws
                  SAXException, IOException{
     
        //creating Diff instance to compare two XML files
        Diff xmlDiff = new Diff(source, target);
     
        //for getting detailed differences between two xml files
        DetailedDiff detailXmlDiff = new DetailedDiff(xmlDiff);
     
        return detailXmlDiff.getAllDifferences();
    }
 
    public static boolean printDifferences(List differences){
        int totalDifferences = differences.size();
        System.out.println("===============================");
        System.out.println("Total differences : " + totalDifferences);
        System.out.println("================================");
        if(totalDifferences == 0)
        {
        	return true;
        }
//        System.out.println(differences);
        for (Object object : differences) {
			System.out.println(object);
		}
        return false;
    }
}