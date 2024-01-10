/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22035357
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Tuesday 29-11-2022 11:29
 */

/**
 * @author 22035357
 *
 */
public class Ward {
	private String Ward;
	private String description;
	private int bedCount;
	private double bedCharge;
	
	public Ward(String ward,String description,int bedCount, double bedCharge) {
		this.Ward = ward;
		this.description = description;
		this.bedCount = bedCount;
		this.bedCharge = bedCharge;
	}
	public String getWard() {
		return Ward;
	}
	public String getDescription() {
		return description;
	}
	public int getBedCount() {
		return bedCount;
	}
	public double getBedCharge() {
		return bedCharge;
	}
}
