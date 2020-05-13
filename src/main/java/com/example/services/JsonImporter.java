package com.example.services;
import java.io.*;

import com.example.entites.MenuContent;

import com.google.gson.Gson;


public class JsonImporter{	
	/**
	   * 
	   * Converto un file JSON in una lista di oggetti Java
	   * 
	   * @param pathFile
	   * @return List<MenuNode>
	   */
	  public static MenuContent readJsonFile2ObjectList(String filePath){
		  Gson gson = new Gson();
		  MenuContent x = null;

		    try (Reader reader = new FileReader(filePath)) {

		        // Converto un file JSON in una lista di oggetti Java 
		        MenuContent menu = gson.fromJson(reader, MenuContent.class);
		        return x = menu;

		        

		    } catch (IOException e) {
		        e.printStackTrace();
		        }
	    return x;
	  }
	  
}