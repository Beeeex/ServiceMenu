package com.example.demo;

import java.io.IOException;
import java.util.List;

import com.example.entites.MenuNode;
import com.example.services.Json2Excel;
import com.example.services.JsonImporter;
import com.example.services.NodeAnalyzer;


public class ServiceMenuApplication {

	
	 public static void main(String[] args) throws IOException {
		    // Leggo un file JSON e lo metto in una collezione di oggetti MenuNode
			  List<MenuNode> menus = JsonImporter.readJsonFile2ObjectList("ServiceMenu.json");
		    
		    List<MenuNode> AnalyzedMenus = NodeAnalyzer.NodeAnalyzerMethod(menus,0);
		      
		   // Converto una collezione MenuNode di oggetti in un file Excel
			  Json2Excel.writeObjects2ExcelFile(AnalyzedMenus, "output/ServiceMenu.xlsx");
		  }
	

}
