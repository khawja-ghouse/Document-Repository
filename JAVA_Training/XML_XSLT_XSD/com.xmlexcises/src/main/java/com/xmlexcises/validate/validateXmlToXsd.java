package com.xmlexcises.validate;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class validateXmlToXsd {

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		} catch (SAXException e1) {
			e1.printStackTrace();
			return false;
		}

		return true;

	}
	public static void main(String[] args) {
		validateXmlToXsd validateObj = new validateXmlToXsd();
		boolean a = validateObj.validateXMLSchema("D:\\Khawja_Ghouse\\D-Drive\\Reactiveworks-training\\New folder (2)\\Excises6\\com.xmlexcises\\src\\main\\resources\\eventframework.xsd",
				"D:\\Khawja_Ghouse\\D-Drive\\Reactiveworks-training\\New folder (2)\\Excises6\\com.xmlexcises\\src\\main\\resources\\eventframework.xml");
		System.out.println("Dispatcher validation::" + a);
//		boolean b = validateObj.validateXMLSchema("D:\\XMLexcises\\com.reactiveworks.xml\\featureMetaInfo.xsd",
//				"D:\\XMLexcises\\com.reactiveworks.xml\\featureMetaInfo.xml");
//		System.out.println("featuremetaInfo validation:: " + b);
	}
}
