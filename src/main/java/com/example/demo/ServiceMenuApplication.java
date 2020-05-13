package com.example.demo;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.example.entites.MenuContent;
import com.example.entites.MenuNode;
import com.example.services.Json2Excel;
import com.example.services.JsonImporter;
import com.example.services.NodeAnalyzer;


public class ServiceMenuApplication {


	public static void main(String[] args) throws IOException {
		try {
			//Leggo le props dal file config.properties
			FileReader props=new FileReader("config.properties");
			Properties prop=new Properties();
			prop.load(props);
			
			// Leggo un file JSON e lo metto in una collezione di oggetti MenuNode
			MenuContent menus = JsonImporter.readJsonFile2ObjectList(prop.getProperty("input"));
			//Analizzo il file JSON importato
			List<MenuNode> analyzedMenus = NodeAnalyzer.NodeAnalyzerMethod(menus.getNodes(),0);
			// Converto una collezione MenuNode di oggetti in un file Excel
			Json2Excel.writeObjects2ExcelFile(analyzedMenus, prop.getProperty("output"),menus.getVersion());}
		catch(IOException e){
			e.printStackTrace();
		}

	}



}
