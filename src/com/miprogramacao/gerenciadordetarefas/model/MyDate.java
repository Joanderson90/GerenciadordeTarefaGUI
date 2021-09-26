package com.miprogramacao.gerenciadordetarefas.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
	
	private Date date;
	private SimpleDateFormat dateFormat;
	
		
		
	
	public MyDate() {
		
		this.date = new Date();
		this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	public String getCurrentDate(){
		
		return this.dateFormat.format(date);
	}
	
	public String getCurrentDay(){
		
		SimpleDateFormat temp  = new SimpleDateFormat("dd");
		
		return temp.format(date);
	}
	
	public String getCurrentMonth(){
		
		SimpleDateFormat temp  = new SimpleDateFormat("MM");
		
		return temp.format(date);
	}
	
	public String getCurrentYear(){
		
		SimpleDateFormat temp  = new SimpleDateFormat("yyyy");
		
		return temp.format(date);
	}
	
	public int compareTo(String date1, String date2) {
		
		date1 = date1.replace("/", "");
		date2 = date2.replace("/", "");
		
		int d1 = Integer.parseInt(date1);
		int d2 = Integer.parseInt(date2);
		int valComparete;
		
		if(d1 > d2) valComparete = 1;
		else if(d1 < d2) valComparete = -1;
		else valComparete = 0;
		
		return valComparete;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}
	
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	

}
