package com.example.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.entites.MenuNode;

 
public class Json2Excel { 
	/**
	 * 
	 * Scrivo una lista di oggetti MenuNode in un file Excel
	 * 
	 * @param List<MenuNode> menus
	 * @param filePath
	 * @param version
	 * @throws IOException 
	 */
  public static void writeObjects2ExcelFile(List<MenuNode> menus, String filePath,String version) throws IOException {
	  String[] baseColumns = {"ServiceId","NodeName","NodeType","GroupType","FlowType","ResourceId"};
	  //Riassegno dinamicamente le prime colonne del file Excel in base alle profondità dei nodi del file JSON dato
	  
	  //1.Metto in maxDepth la profondità max
	  int i = 0;
	  int maxDepth = 0;
	  while(i<menus.size()) {
		  if(menus.get(i).getDepth() > maxDepth) {
			  maxDepth = menus.get(i).getDepth();

		  }
		  i++;
	  }
	  
	  //2. Creato il nuovo array columns metto le prime celle 
	  //in base alla dimensione presente in maxDepth
	  String[] columns = new String[baseColumns.length+maxDepth+1];
	  for(i = 0; i <= maxDepth; i++) {

		  columns[i] = "" + i;

	  }
	  
	  //3. Riempio l'array columns con le restanti colonne di base
	  int j=0;
	  for(i=maxDepth+1; i<columns.length; i++) {

		  columns[i] = baseColumns[j];
		  j++;
	  }

	  //Creo il folgio di lavoro e gli assegno il nome, lo stile cella e dell'header
	  Workbook workbook = new XSSFWorkbook();

	  String a = "Menu" +  version;
	  Sheet sheet = workbook.createSheet(a);

	  Font headerFont = workbook.createFont();
	  headerFont.setBold(true);
	  headerFont.setColor(IndexedColors.BLUE.getIndex());

	  CellStyle headerCellStyle = workbook.createCellStyle();
	  headerCellStyle.setFont(headerFont);

	  // Riga per l'header
	  Row headerRow = sheet.createRow(0);

	  // Header
	  for (int col = 0; col < columns.length; col++) {
		  Cell cell = headerRow.createCell(col);
		  cell.setCellValue(columns[col]);
		  cell.setCellStyle(headerCellStyle);
	  }
	  //inserimento righe
	  int rowIdx = 1;
	  for (MenuNode menu : menus) {
		  Row row = sheet.createRow(rowIdx++);

		  row.createCell(menu.getDepth()).setCellValue("X");
		  if(menu.getNodeId() != null && menu.getNodeType().equals("service") ) { row.createCell((columns.length-6)).setCellValue(menu.getNodeId());}
		  if(menu.getNodeName()!= null ) {row.createCell((columns.length-5)).setCellValue(menu.getNodeName());}
		  if(menu.getNodeType() != null ) {row.createCell(columns.length-4).setCellValue(menu.getNodeType());}
		  if(menu.getGroupType() != null ) {row.createCell(columns.length-3).setCellValue(menu.getGroupType());}
		  if(menu.getFlowType() != null ) {row.createCell(columns.length-2).setCellValue(menu.getFlowType());}
		  if(menu.getResource() != null ) {row.createCell(columns.length-1).setCellValue(menu.getResource().getId());}

	  }

	  FileOutputStream fileOut = new FileOutputStream(filePath);
	  workbook.write(fileOut);
	  fileOut.close();
	  workbook.close();
  }
}
