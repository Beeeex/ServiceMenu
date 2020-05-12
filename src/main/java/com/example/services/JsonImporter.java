package com.example.services;
import java.io.*;
import java.util.List;

import com.example.entites.MenuContent;
import com.example.entites.MenuNode;
import com.google.gson.Gson;


public class JsonImporter{
	public static void main(String[] args) {
		}
	
	/**
	   * 
	   * Converto un file JSON in una lista di oggetti Java
	   * 
	   * @param pathFile
	   * @return List<MenuNode>
	   */
	  public static List<MenuNode> readJsonFile2ObjectList(String filePath){
		  Gson gson = new Gson();
		  List<MenuNode> list = null;

		    try (Reader reader = new FileReader("input/ServiceMenu.json")) {

		        // Converto un file JSON in una lista di oggetti Java 
		        MenuContent menu = gson.fromJson(reader, MenuContent.class);
		        return list = menu.getNodes();

		        

		    } catch (IOException e) {
		        e.printStackTrace();
		        }
	    return list;
	  }
	
}