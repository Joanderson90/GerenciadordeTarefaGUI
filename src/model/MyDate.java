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
		
		LocalDate localDate1 = getLocalDate(date1);
		LocalDate localDate2 = getLocalDate(date2);

		int valComparete = localDate1.compareTo(localDate2);
		
		return valComparete;
	}
	
	private LocalDate getLocalDate(String date) {
		
		LocalDate localDate;
		
		//Format date day/dayOfMonth/year  example: 12/08/2021
		
		int year = Integer.parseInt(date.substring(6, 10));
		int month = Integer.parseInt(date.substring(3, 5));
		int dayOfMonth = Integer.parseInt(date.substring(0, 2));
		
		localDate = LocalDate.of(year, month, dayOfMonth);
		
		return localDate;
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
