package com.example.services;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.entites.MenuContent;
import com.example.entites.MenuNode;
import com.google.gson.Gson;
 
public class Json2Excel { 
  /**
   * 
   * Converto un file JSON e mi prendo la versione del file JSON
   * 
   * @param pathFile
   * @return String
   */
  
  private static String versioner(String filePath){
	  Gson gson = new Gson();
	  String version = " ";

	    try (Reader reader = new FileReader("input/ServiceMenu.json")) {

	        // Converto un file JSON in un oggetto Java e ne prendo la versione
	        MenuContent menu = gson.fromJson(reader, MenuContent.class);
	        return version = menu.getVersion();

	        

	    } catch (IOException e) {
	        e.printStackTrace();
	        }
    return version;
  }
  
  
  
  /**
   * 
   * Scrivo una lista di oggetti MenuNode in un file Excel
   * 
   * @param List<MenuNode> menus
   * @param filePath
   * @throws IOException 
   */
  public static void writeObjects2ExcelFile(List<MenuNode> menus, String filePath) throws IOException {
    String[] COLUMNs = {"0", "1", "2","3","4","5","6","ServiceId","NodeName","NodeType","GroupType","FlowType","ResourceId"};
    
    Workbook workbook = new XSSFWorkbook();
     
    String a = "Menu" +  versioner("ServiceMenu.json");
    Sheet sheet = workbook.createSheet(a);
 
    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setColor(IndexedColors.BLUE.getIndex());
 
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);
 
    // Riga per l'header
    Row headerRow = sheet.createRow(0);
 
    // Header
    for (int col = 0; col < COLUMNs.length; col++) {
      Cell cell = headerRow.createCell(col);
      cell.setCellValue(COLUMNs[col]);
      cell.setCellStyle(headerCellStyle);
    }
    //inserimento righe
    int rowIdx = 1;
    for (MenuNode menu : menus) {
      Row row = sheet.createRow(rowIdx++);
      
      row.createCell(menu.getDepth()).setCellValue("X");
      if(menu.getNodeId() != null && menu.getNodeType().equals("service") ) { row.createCell(7).setCellValue(menu.getNodeId());}
      if(menu.getNodeName()!= null ) {row.createCell(8).setCellValue(menu.getNodeName());}
      if(menu.getNodeType() != null ) {row.createCell(9).setCellValue(menu.getNodeType());}
      if(menu.getGroupType() != null ) {row.createCell(10).setCellValue(menu.getGroupType());}
      if(menu.getFlowType() != null ) {row.createCell(11).setCellValue(menu.getFlowType());}
      if(menu.getResource() != null ) {row.createCell(12).setCellValue(menu.getResource().getId());}
 
    }
 
    FileOutputStream fileOut = new FileOutputStream(filePath);
    workbook.write(fileOut);
    fileOut.close();
    workbook.close();
  }
}
