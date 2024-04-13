import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class App_Main {
    static ArrayList<vaccines> vaccine = new ArrayList<vaccines>();
    static ArrayList<citizen> citizens = new ArrayList<citizen>();
    static ArrayList<slot> slots = new ArrayList<slot>();
    static ArrayList<hospital> hospitals = new ArrayList<hospital>();
    
    public static void main(String[] args) {
        System.out.println("COWIN Portal initialized....");
        Scanner scn = new Scanner(System.in);
        while (true) {
                System.out.println("-----------------------------");
                System.out.println("1. Add Vaccine");
                System.out.println("2. Register Hospital");
                System.out.println("3. Register Citizen");
                System.out.println("4. Add Slot for Vaccination");
                System.out.println("5. Book Slot for Vaccination");
                System.out.println("6. List all slots for a hospital");
                System.out.println("7. Check Vaccination Status");
                System.out.println("8. Exit");
                int val = scn.nextInt();
                
                if(val==1) {                // Add Vaccine
                    String name; 
                    int doses;   
                    int gap;    

                    System.out.print("Provide the Vaccine Name: ");
                    name = scn.nextLine();
                    if (name.length() == 0) {
                        name = scn.nextLine();
                    }
                    System.out.print("Number of Doses to be given: ");
                    doses = Integer.parseInt(scn.nextLine());
                    if (doses > 1) { 
                        System.out.print("Gap that must be taken after dose: ");
                        gap = scn.nextInt();
                    } 
                    else
                    {   gap = 0;
                    }

                    vaccines vac = new vaccines(name, doses, gap);
                    vaccine.add(vac);
                    vac.display_details();
                }
                
                else if(val==2) {               //to Register a Hospital
                    String hospital_name;
                    int code;

                    System.out.print("Hospital Name: ");
                    hospital_name = scn.nextLine();
                    if (hospital_name.length() == 0) {
                        hospital_name = scn.nextLine();
                    }

                    System.out.print("Pincode: ");
                    code = scn.nextInt();
                    hospital h = new hospital(hospital_name, code);
                    hospitals.add(h);
                    h.display();
                }

                else if(val==3) {               //to Register a Citizen
                    String citizen_name;
                    int age;
                    long c_id;

                    System.out.print("Citizen Name: ");
                    citizen_name = scn.nextLine();

                    if (citizen_name.length() == 0) {
                        citizen_name = scn.nextLine();
                    }

                    System.out.print("Age: ");
                    age = Integer.parseInt(scn.nextLine());
                    
                    System.out.print("Unique ID: ");
                    c_id = Long.parseLong(scn.nextLine()); // citizen's Unique ID(Aadhar Number)
                    
                    citizen c = new citizen(citizen_name, age, c_id);
                    if (age >= 18) {
                        citizens.add(c);
                    }
                    c.display();
                }

                else if(val==4) {        // Add Slot for Vaccination
                    int h_id;            
                    int day;             
                    int quantity;       
                    String vaccine_name;    
                    String hosp_name=""; 

                    System.out.print("Enter the Hospital ID: ");
                    h_id = scn.nextInt();
                    System.out.print("Enter the number of Slots to be added: ");
                    int nslots = scn.nextInt();

                    for (int i = 0; i < nslots; i++) {
                        System.out.print("Enter Day Number: ");
                        day = scn.nextInt();

                        System.out.print("Enter Quantity: ");
                        quantity = scn.nextInt();

                        System.out.println("Select Vaccine "); 
                        for (int j = 0; j < vaccine.size(); j++) {
                            System.out.println(j + "." + vaccine.get(j).name);
                        }

                        int option = scn.nextInt(); 
                        vaccine_name = vaccine.get(option).name;

                        for (int k = 0; k < hospitals.size(); k++) {
                            if (hospitals.get(k).unique_hID == h_id) {      
                                hosp_name = hospitals.get(k).hospital_name;
                                break;
                            }
                        }
                        
                        slot s = new slot(nslots, h_id, day, quantity, vaccine_name, hosp_name); 
                        slots.add(s);
                        s.displaySlot();
                    }
                }

                else if(val==5) {               //Book Slot for vaccination
                    System.out.print("Enter Patient Unique ID: ");
                    long userid = scn.nextLong();
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter Option:");
                    int op = scn.nextInt();

                    int code;
                    String vaccine_name;
                    int hospitalId;
                    int slot_taken;
                    String cname;

                    if (op == 1) {
                        System.out.print("Enter the pincode: ");
                        code = scn.nextInt();
                    
                        //displays the information of all the hospital in the area of pincode
                        for (int i = 0; i < hospitals.size(); i++){
                            if (hospitals.get(i).pincode == code) {
                                System.out.println(hospitals.get(i).unique_hID + " " + hospitals.get(i).hospital_name);
                            }
                        }

                        System.out.print("Enter the hospital ID:");
                        hospitalId = scn.nextInt();
                        int flag = 0;
                        for (int i = 0; i < slots.size(); i++) {
                            if (slots.get(i).hospital_id == hospitalId && slots.get(i).quantity > 0) {
                                flag = 1;
                                System.out.println(i + "->" + " Day:" + slots.get(i).days + " Available Qty:" + slots.get(i).quantity + " Vaccine:" + slots.get(i).vaccineName);
                            }
                        }

                        if (flag == 0) {
                            System.out.println("Slots not available.");
                        }
                        else {
                            System.out.print("Choose the slot: ");
                            slot_taken = scn.nextInt();
                            int citizen_index = 0;
                            int totaldose = 0;
                            for (int i = 0; i < citizens.size(); i++) {
                                if (citizens.get(i).getUnique_ID() == userid) {
                                    citizen_index = i;
                                    break;
                                }
                            }

                            if (citizens.get(citizen_index).getStatus() == 1) {
                                System.out.println(citizens.get(citizen_index).getName() + " vaccinated with " + slots.get(slot_taken).vaccineName);
                                citizens.get(citizen_index).setDoseCount(citizens.get(citizen_index).getDosecount() + 1);
                                citizens.get(citizen_index).setVaccine(slots.get(slot_taken).vaccineName);
                                for (int j = 0; j < vaccine.size(); j++) {
                                    if (citizens.get(citizen_index).getVaccineName().equalsIgnoreCase(vaccine.get(j).name)) {
                                        citizens.get(citizen_index).vaccineGap = vaccine.get(j).getGap();
                                        citizens.get(citizen_index).totalDoses = vaccine.get(j).total_doses;
                                        if (citizens.get(citizen_index).getDosecount() == vaccine.get(j).total_doses) {
                                            citizens.get(citizen_index).setStatus(3);
                                        } else {
                                            citizens.get(citizen_index).setStatus(2);
                                        }
                                    }
                                }
                                citizens.get(citizen_index).setDayofvaccine(slots.get(slot_taken).getDays());
                                slots.get(slot_taken).setQuantity(slots.get(slot_taken).getQuantity() - 1);
                            } 
                            else if (citizens.get(citizen_index).getStatus() == 2) {
                                if (slots.get(slot_taken).vaccineName.equalsIgnoreCase(citizens.get(citizen_index).getVaccineName())) {
                                    if (citizens.get(citizen_index).vaccineGap + citizens.get(citizen_index).getDayofvaccine() <= slots.get(slot_taken).getDays()) {
                                        System.out.println(citizens.get(citizen_index).getName() + " vaccinated with " + slots.get(slot_taken).vaccineName);
                                        citizens.get(citizen_index).setDoseCount(citizens.get(citizen_index).getDosecount() + 1);

                                        if (citizens.get(citizen_index).getDosecount() == citizens.get(citizen_index).totalDoses) {
                                            citizens.get(citizen_index).setStatus(3);
                                        } else {
                                            citizens.get(citizen_index).setStatus(2);
                                        }
                                    } else {
                                        System.out.println("You are not allowed to take the next dose before due date");
                                    }
                                } else {
                                    System.out.println("You are not supposed to go with the selected vaccine.");
                                }
                            }
                            else if (citizens.get(citizen_index).getStatus() == 3) {
                                System.out.println("FULLY VACCINATED");
                            } 
                        }
                    } 
                    else if (op == 2) {
                        System.out.print("Enter Vaccine Name: ");
                        vaccine_name = scn.nextLine();
                        int flag = 0;
                        if (vaccine_name.length() == 0) {
                            vaccine_name = scn.nextLine();
                        }

                        for (int i = 0; i < slots.size(); i++) {
                            if (slots.get(i).vaccineName.equals(vaccine_name)) {
                                System.out.println(slots.get(i).getHospital_id() + " " + slots.get(i).getHospName());
                            }
                        }

                        System.out.print("Enter the hospital ID: ");
                        hospitalId = scn.nextInt();
                        for (int i = 0; i < slots.size(); i++) {
                            if (slots.get(i).hospital_id == hospitalId && slots.get(i).quantity > 0 && slots.get(i).vaccineName.equals(vaccine_name)) {
                                flag = 1;
                                System.out.println(i + "->" + " Day: " + slots.get(i).days + " Available Qty:" + slots.get(i).quantity + " Vaccine:" + slots.get(i).vaccineName);
                            }
                        }

                        if (flag == 0) {
                            System.out.println("Slots not available.");
                        }
                        else {
                            System.out.print("Enter the choice: ");
                            slot_taken = scn.nextInt();
                            int citizen_index = 0;
                            for (int j = 0; j < citizens.size(); j++) {
                                if (citizens.get(j).getUnique_ID() == userid) {
                                    citizen_index = j;
                                    break;
                                }
                            }

                            if (citizens.get(citizen_index).getStatus() == 1) {
                                System.out.println(citizens.get(citizen_index).getName() + " vaccinated with " + slots.get(slot_taken).vaccineName);
                                citizens.get(citizen_index).setDoseCount(citizens.get(citizen_index).getDosecount() + 1);
                                citizens.get(citizen_index).setVaccine(slots.get(slot_taken).vaccineName);
                                for (int j = 0; j < vaccine.size(); j++) {
                                    if (citizens.get(citizen_index).getVaccineName().equalsIgnoreCase(vaccine.get(j).name)) {
                                        citizens.get(citizen_index).vaccineGap = vaccine.get(j).getGap();
                                        citizens.get(citizen_index).totalDoses = vaccine.get(j).total_doses;

                                        if (citizens.get(citizen_index).getDosecount() == vaccine.get(j).total_doses) {
                                            citizens.get(citizen_index).setStatus(3);
                                        } else {
                                            citizens.get(citizen_index).setStatus(2);
                                        }
                                    }
                                }
                                citizens.get(citizen_index).setDayofvaccine(slots.get(slot_taken).getDays());
                                slots.get(slot_taken).setQuantity(slots.get(slot_taken).getQuantity() - 1);
                            }
                            else if (citizens.get(citizen_index).getStatus() == 2) {
                                if (slots.get(slot_taken).vaccineName.equalsIgnoreCase(citizens.get(citizen_index).getVaccineName())) {
                                    if (citizens.get(citizen_index).vaccineGap + citizens.get(citizen_index).getDayofvaccine() <= slots.get(slot_taken).getDays()) {
                                        System.out.println(citizens.get(citizen_index).getName() + " vaccinated with " + slots.get(slot_taken).vaccineName);
                                        citizens.get(citizen_index).setDoseCount(citizens.get(citizen_index).getDosecount() + 1);

                                        if (citizens.get(citizen_index).getDosecount() == citizens.get(citizen_index).totalDoses) {

                                            citizens.get(citizen_index).setStatus(3);
                                        } else {
                                            citizens.get(citizen_index).setStatus(2);
                                        }
                                    } else {
                                        System.out.println("You are not allowed to take the next dose before due date");
                                    }
                                } else {
                                    System.out.println("You are not supposed to go with the selected vaccine.");
                                }
                            }
                            else if (citizens.get(citizen_index).getStatus() == 3) {
                                System.out.println("FULLY VACCINATED");
                            }
                        }
                    }
                    else if (op == 3) {
                        //exit
                    }
                }

                else if(val==6)
                {
                    System.out.print("Enter Hospital ID: ");
                    int hospital_id = scn.nextInt();
                    for (int i = 0; i < slots.size(); i++) {
                        if (slots.get(i).hospital_id == hospital_id){
                            slots.get(i).availableSlots();
                        }
                    }
                }
                else if(val==7) {
                    System.out.print("Enter Patient ID:");
                    long id = scn.nextLong();
                    for (int i = 0; i < citizens.size(); i++) {
                        if (citizens.get(i).getUnique_ID()== id) {
                            int s = citizens.get(i).getStatus();
                            if(s== 1) {
                                System.out.println("Citizen REGISTERED");
                            } 
                            else if (s == 2) {
                                System.out.println("PARTIALLY VACCINATED");
                                System.out.println("Vaccine Given: " + citizens.get(i).getVaccineName());
                                System.out.println("Number of Doses Given:" + citizens.get(i).getDosecount());
                                int due_date = citizens.get(i).getDayofvaccine() + citizens.get(i).vaccineGap;
                                System.out.println("Next Dose due date: " + due_date);
                            }
                            else if (s == 3) {
                                System.out.println("FULLY VACCINATED");
                                System.out.println("Vaccine Given: " + citizens.get(i).getVaccineName());
                                System.out.println("Number of Doses Given: " + citizens.get(i).getDosecount());
                            }
                        }
                    }
                }
                else if(val==8) {
                    break;
                }
                else {
                    System.out.println("Invalid Input! Enter between 1-8.");
                }
            }
        }
    }