/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bit.minicc;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class SymbolTable {
	private ArrayList<SymbolEntry> symbolList;
	
	public SymbolTable(){
		this.setSymbolList(new ArrayList<SymbolEntry>());
	}
	
        public void insertSymbol(SymbolEntry se){
            this.getSymbolList().add(se);
        }
        
        public ArrayList<SymbolEntry> getSymbolList(){
            return symbolList;
        }
        
        public void setSymbolList(ArrayList<SymbolEntry> symbolList){
            this.symbolList = symbolList;
        }
        
	public SymbolEntry insertSymbol(String name){
		SymbolEntry se = new SymbolEntry();
		se.name = name;
		return se;
	}
	
	public SymbolEntry findByName(String name){
		SymbolEntry se = null;
		for(SymbolEntry e: getSymbolList()){
			if(e.name.equals(name)){
				se = e;
				break;
			}
		}
		
		return se;
	}
	
	public void print(){
		System.out.println("-----------------------------------------");
		System.out.println("index\t\tname\t\tkind");
		int i = 1;
		for(SymbolEntry e: getSymbolList()){
			System.out.println("" + i + "\t\t" + e.name + "\t\t" + e.kind);
                        i++;
		}
		System.out.println("-----------------------------------------");
	}
}
