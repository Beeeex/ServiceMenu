package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.entites.MenuNode;

public class NodeAnalyzer {

	 /**
	   * 
	   * Data una lista di oggetti Java(MenuNode) e un intero j(depth)
	   * analizzo i nodi all'interno della lista di partenza e li dispongo 
	   * con ordine in una lista vuota settando la profondità dei nodi 
	   * ricorsivamente finché il metodo getNode() fatto sui suoi elementi 
	   * è non nullo
	   * 
	   * @param List<MenuNode> list
	   * @param int j
	   * @return List<MenuNode>
	   */
	  
	  public static List<MenuNode> NodeAnalyzerMethod(List<MenuNode> list,int j){
		  List<MenuNode> stampa = new ArrayList<MenuNode>();
		  int i = 0;
		  
		  while(i<list.size()) {
			  list.get(i).setDepth(j);
		  stampa.add(list.get(i));
		  i++;
		  
		  
		  if(list.get(i-1).getNodes() != null) {
			  stampa.addAll(NodeAnalyzerMethod(list.get(i-1).getNodes(),j+1));
		  }
		  }
		  	return stampa; 
	  }
}
