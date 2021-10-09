package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
		
		LocalDate ld = LocalDate.of(
				Integer.parseInt(date1.substring(6, 10)),
				Integer.parseInt(date1.substring(3, 5)),
				Integer.parseInt(date1.substring(0, 2)));
		
		LocalDate ld2 = LocalDate.of(
				Integer.parseInt(date2.substring(6, 10)),
				Integer.parseInt(date2.substring(3, 5)), 
				Integer.parseInt(date2.substring(0, 2)));
		
		
		
		int valComparete = ld.compareTo(ld2);
		
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
