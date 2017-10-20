package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class students {

	
	int index;
	String name;
	String student_ID;
	String card_ID;
	
	Date date;
	String entryTime;
	
	
	public students(int index, String name, String student_ID, String card_ID) {
		super();
		this.index = index;
		this.name = name;
		this.student_ID = student_ID;
		this.card_ID = card_ID;
		
		this.date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.entryTime = dateFormat.format(date);		
		
		
	}

	//constructor for recalling the student list
	public students(int index, String name, String student_ID, String card_ID, String entryTime) {
		super();
		this.index = index;
		this.name = name;
		this.student_ID = student_ID;
		this.card_ID = card_ID;
		
		this.entryTime = entryTime;	
		
		
	}

	
	

	public String getEntryTime() {
		return entryTime;
	}



	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}






	public int getIndex() {
		return index;
	}




	public void setIndex(int index) {
		this.index = index;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getStudent_ID() {
		return student_ID;
	}




	public void setStudent_ID(String student_ID) {
		this.student_ID = student_ID;
	}




	public String getCard_ID() {
		return card_ID;
	}




	public void setCard_ID(String card_ID) {
		this.card_ID = card_ID;
	}
	
	
	
}
