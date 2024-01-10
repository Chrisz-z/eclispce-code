/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22035357
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Tuesday 29-11-2022 11:39
 */

/**
 * @author 22035357
 *
 */
public class Patient {
	private String nric4;
	private String name;
	private String Ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;
	
	public Patient(String nric4,String name,String ward,int bed,String dateWarded,String dateDischarged,int visitorCount) {
		this.nric4 = nric4;
		this.name = name;
		this.Ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = dateDischarged;
		this.visitorCount = visitorCount;	
	}
	public Patient(String nric4,String name,String ward,int bed,String dateWarded) {
		this.nric4 = nric4;
		this.name = name;
		this.Ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = "";
		this.visitorCount = 0;
	}
	public String getNric4() {
		return nric4;
	}
	public String getName() {
		return name;
	}
	public String getWard() {
		return Ward;
	}
	public int getBed() {
		return bed;
	}
	public String getDateWarded(){
		return dateWarded;
	}
	public String getDateDischarged() {
		return dateDischarged;
	}
	public void setDateDischarged(String x) {
		this.dateDischarged = x;
	}
	public int getVisitorCount() {
		return visitorCount;
	}
	public void setVisitorCount(int y) {
		this.visitorCount = y;
	}
	public void display() {
		System.out.printf("%-18S %-3s %s\n","NRIC",":",nric4);
		System.out.printf("%-18S %-3s %s\n","Patient Name",":",name);
		System.out.printf("%-18S %-3s %s\n","ward",":",Ward);
		System.out.printf("%-18S %-3s %s\n","Bed",":",bed);
		System.out.printf("%-18S %-3s %s\n","Date warded",":",dateWarded);
		System.out.printf("%-18S %-3s %s\n","Date discharged",":",dateDischarged);
		System.out.printf("%-18S %-3s %s\n","No of visitor(s)",":",visitorCount);

	}
}
