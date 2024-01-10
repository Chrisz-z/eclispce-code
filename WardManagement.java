import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 
 * Student ID:
 * Class:
 * Date/Time Last modified:
 */


public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		
		//-------------------
		wardArr[0] = new Ward("A","1 Bed, attached bath/toilet",10,535.00);
		wardArr[1] = new Ward("B1","4 Bed,attached bath/toilet",20,266.43);
		wardArr[2] = new Ward("B2","6 Bed, common bath/toilet",20,83.00);
		wardArr[3] = new Ward("C","8 Bed, common bath/toilet",50,37.00);
		//-------------------


		
		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		//-------------------
		
		patientList.add(new Patient("111A","John Lee","A",2,"01/12/2022","",0));
		patientList.add(new Patient("222B","Mary Jane","B1",11,"02/12/2022","",0));
		patientList.add(new Patient("333C","Abdul Musri","B1",12,"03/12/2022","",0));
		patientList.add(new Patient("444D","Jane Tan","B2",2,"12/12/2022","",3));
		patientList.add(new Patient("555E","Paul Tan","C",2,"02/12/2022","",4));
		patientList.add(new Patient("666F","Paul Ng","C",3,"03/12/2022","09/11/2022",0));
		patientList.add(new Patient("777G","Wong Kuan","C",4,"02/12/2022","",0));

		//-------------------
		



		//display standard menu and ask for option
		int option = -99;
		publicMenu();

		
		//indefinite while loop
		while(option != 9) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList,wardArr);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}
	

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu 
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		
		//-------------------
		// When the program is executed, a menu should be displayed with the following options listed:
		System.out.println("1. View all Ward Info");
		System.out.println("2. Display Patient List");
		System.out.println("3. Admit Patient");
		System.out.println("4. Discharge Patient");
		System.out.println("5. Remove Patient");
		System.out.println("6. Register Visit");
		System.out.println("7. End Visit");
		System.out.println("8. Display Ward Overview");
		System.out.println("9. Logout");
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {

		//-------------------
		System.out.println();
		Helper.line(60, "*");
		System.out.println("*****                    WARD INFO                     *****");
		Helper.line(60, "*");
		System.out.printf("%-5S %-30S %-10S %S","Ward","Description","Bed Count","Bed Charge\n");
		for (int i = 0; i < wardArr.length; i++){
			String Ward = wardArr[i].getWard();
			String Description = wardArr[i].getDescription();
			int BedCount  = wardArr[i].getBedCount();
			double BedCharge = wardArr[i].getBedCharge();
			System.out.printf("%-5s %-30s %-10d %.2f\n",Ward,Description,BedCount,BedCharge);
		}
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {

		//-------------------
		for (int i = 0;i < patientList.size();i++) {
			Helper.line(35, "*");
			System.out.println("*****        PATIENT "+(i+1)+"        *****");
			Helper.line(35, "*");
			patientList.get(i).display();
		}
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList,Ward[] wardArr) {
		
		
		
		//-------------------
		String NRIC = Helper.readString("Enter patient 4 digit NRIC > ");
		String Name= Helper.readString("Enter patient Name > ");
		String Ward = Helper.readString("Enter ward > ");
		int bed = Helper.readInt("Enter bed > ");
		String date = Helper.readString("Enter date warded > ");
		
		// NRIC validation
		boolean ICcheck = false;
		if(NRIC.length()== 4) {
			char[] checkIc = NRIC.toCharArray();
			for (int a = 0 ; a < 3; a++) {
				if (Character.isDigit(checkIc[a])== true) {
					if (Character.isAlphabetic(checkIc[3])== true)
					ICcheck = true;
					}
				}
		//name validation
		}
		boolean Ncheck = true;
		char[] check = Name.toCharArray();
		for (int i = 0 ; i < Name.length(); i++) {
			if (Character.isDigit(check[i])== true) {
				Ncheck = false;
			}
		// ward validation
		}
		boolean Wcheck = false;
		for(int i = 0 ; i < wardArr.length ; i++) {
			if(wardArr[i].getWard().equalsIgnoreCase(Ward)) {
				Wcheck = true;
			}
		// bed validation
		}
		boolean Bcheck = false;
		ArrayList<Integer> wardBed = new ArrayList<>();
		for(int j = 0 ; j < patientList.size(); j++) {
			if (Ward.equalsIgnoreCase(patientList.get(j).getWard())) {
				wardBed.add(patientList.get(j).getBed());
			}
		}
		for(int i = 0 ; i < wardBed.size() ; i++) {
			if(wardBed.get(i) != bed) {
				Bcheck = true;
			}
		}
		
		
		// checking whether to add patient
		if (!ICcheck){
			System.out.println("\nInvalid NRIC");
		}
		if (!Ncheck) {
			System.out.println("\nInvalid Name");
		}
		if (!Wcheck) {
			System.out.println("\nInvalid Ward");
		}
		if (!Bcheck) {
			System.out.println("\nBed already occupied");
		}
		if(ICcheck && Ncheck && Wcheck && Bcheck) {
			patientList.add(new Patient(NRIC.toUpperCase(),Name,Ward.toUpperCase(),bed,date));
			patientList.get(patientList.size()-1).display();
			System.out.println("\nPatient added");
		}
		//-------------------
		
	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		String Name = Helper.readString("Enter patient Name > ");
		boolean discharged = false;
		for (int i = 0;i < patientList.size();i++) {
			if (patientList.get(i).getName().equalsIgnoreCase(Name)){
				if(patientList.get(i).getDateDischarged() == ""){
					discharged = false;
					System.out.println(" ");
					patientList.get(i).display();
					String Date = Helper.readString("\nEnter date discharged > ");
					patientList.get(i).setDateDischarged(Date);
					patientList.get(i).setVisitorCount(0);
					System.out.println("\n*** Patient is discharged ***");
					patientfound = true;
				}else{
					discharged = true;
				}
			}
		}
		if(discharged == true) {
		patientfound = true;
		System.out.println("\n***  patient discharged already  ***");
		}
		//-------------------

		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		String Name = Helper.readString("Enter patient Name > ");
		for (int i = 0;i < patientList.size();i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(Name)){
				System.out.println(" ");
				patientList.get(i).display();
				patientfound = true;
				String Del = Helper.readString("\nConfirm deletion (y/n) > ");
				if (Del.equalsIgnoreCase("y")) {
					patientList.remove(i);
					System.out.println("\n*** Patient has been deleted ***");
				}else{
					System.out.println("\n*** Deletion cancelled ***");
				}
			}
		}
		//-------------------

		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		String Name = Helper.readString("Enter patient Name > ");
		for (int i = 0;i < patientList.size();i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(Name)){
				System.out.println(" ");
				patientList.get(i).display();
				patientfound = true;
				int vis = patientList.get(i).getVisitorCount();
				if(patientList.get(i).getDateDischarged() != ""){
					System.out.println("\n*** Patient has been discharged ***");
				}else if (vis == 4) {
					System.out.println("\n*** No other visitors allowed  ***");
				}else{
					System.out.println("\n*** Only " + (4-vis) +" visitor(s) allowed ***\n");
					int nvis = Helper.readInt("Enter number of new visitors > ");
					if (nvis > (4-vis)) {
						System.out.println("\n*** Visitors exceed ***");
					}else {
						patientList.get(i).setVisitorCount(nvis+vis);
						System.out.println("\n*** Please proceed to ward ***");
					}
				}
				
			}
		}
		//-------------------

		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		String Name = Helper.readString("Enter patient Name > ");
		for (int i = 0;i < patientList.size();i++) {
			if(patientList.get(i).getName().equalsIgnoreCase(Name)){
				System.out.println(" ");
				patientList.get(i).display();
				patientfound = true;
				int vis = patientList.get(i).getVisitorCount();
				if(patientList.get(i).getDateDischarged() == ""){
					System.out.println(" ");
					int lvis = Helper.readInt("Enter number of visitor(s) leaving > ");
					if (lvis > vis) {
						System.out.println("\n*** Visitor(s) leaving is more than visited ***");
					}else {
						patientList.get(i).setVisitorCount(vis-lvis);
						System.out.println("\n*** " + lvis + " visitor(S) has left");
					}
				}else {
					System.out.println("\n*** Patient has been discharged ***");
				}
			}
		}
		//-------------------

		return patientfound;
	}

	
	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] wardArr) {

		//-------------------
		int[] patientCount = new int [wardArr.length];
		int[] visitorCount = new int [wardArr.length];
		for (int i = 0;i < patientList.size();i++) {
			for (int j = 0;j < wardArr.length;j++) {
				 boolean wardMatch = patientList.get(i).getWard().equals(wardArr[j].getWard());
				 boolean isDischarged = patientList.get(i).getDateDischarged() == "";
			if(isDischarged && wardMatch) {
				visitorCount[j] += patientList.get(i).getVisitorCount();
				patientCount[j]++;
			}
			}
		}
		int Ptotal = 0;
		int Vtotal = 0;
		for (int a = 0;a < wardArr.length;a++){
			Ptotal += patientCount[a];
			Vtotal += visitorCount[a];
		}
		Helper.line(82, "=");
		System.out.printf("%-5S %-30S %-15S %-15S %S\n","Ward","Description","Bed Count","Total Patient","Total Visitor");
		Helper.line(82, "=");
		for (int b = 0;b < wardArr.length;b++) {
			String Ward = wardArr[b].getWard();
			String Description = wardArr[b].getDescription();
			int BedCount  = wardArr[b].getBedCount();
			System.out.printf("%-5s %-30s %-15d %-15d %d\n",Ward,Description,BedCount,patientCount[b],visitorCount[b]);
		}
		System.out.printf("%42S %11d %15d","total",Ptotal,Vtotal);
	}	
		//-------------------

}


