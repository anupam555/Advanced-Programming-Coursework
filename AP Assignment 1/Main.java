package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<vaccines> vaccine = new ArrayList<vaccines>();
    static ArrayList<citizen> citizens = new ArrayList<citizen>();
    static ArrayList<slot> slots = new ArrayList<slot>();
    static ArrayList<hospital> hospitals = new ArrayList<hospital>();
    public static void main(String[] args) {
        // write your code here
        System.out.println("CoWin Portal initialized....");
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
                if(val==1) {
                    String name;
                    int doses;
                    int gap;
                    System.out.print("Vaccine name: ");
                    name = scn.nextLine();
                    if (name.length() == 0) {
                        name = scn.nextLine();
                    }
                    System.out.print("Number of doses: ");
                    doses = Integer.parseInt(scn.nextLine());
                    if (doses > 1) {
                        System.out.print("Gap between doses: ");
                        gap = scn.nextInt();
                    } else
                        gap = 0;

                    vaccines vac = new vaccines(name, doses, gap);
                    vaccine.add(vac);
                    vac.display_details();
                }
                    else if(val==2) {
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

                    else if(val==3) {
                    String citizen_name;
                    int age;
                    long cid;

                    System.out.print("Citizen Name: ");
                    citizen_name = scn.next();
                    if (citizen_name.length() == 0) {
                        citizen_name = scn.nextLine();
                    }

                    System.out.print("Age: ");
                    age = scn.nextInt();

                    System.out.print("Unique ID: ");
                    cid = scn.nextLong();

                    citizen c = new citizen(citizen_name, age, cid);
                    if (age >= 18) {
                        citizens.add(c);
                    }
                    c.display();
                }
                    else if(val==4) {
                    int hid;
                    int day;
                    int quantity;
                    String vacc_name;
                    String hosp_name = "";
                    System.out.print("Enter the Hospital ID: ");
                    hid = scn.nextInt();

                    System.out.print("Enter the number of Slots to be added: ");
                    int nslots = scn.nextInt();

                    for (int i = 0; i < nslots; i++) {
                        System.out.print("Enter Day Number: ");
                        day = scn.nextInt();

                        System.out.print("Enter Quantity: ");
                        quantity = scn.nextInt();

                        System.out.print("Select Vaccine ");
                        for (int j = 0; j < vaccine.size(); j++) {
                            System.out.print(j + "." + vaccine.get(j).name);
                        }

                        int option = scn.nextInt();
                        vacc_name = vaccine.get(option).name;
                        for (int k = 0; k < hospitals.size(); k++)
                            if (hospitals.get(k).unique_hID == hid) {
                                hosp_name = hospitals.get(k).hospital_name;
                                break;
                            }
                        slot s = new slot(nslots, hid, day, quantity, vacc_name, hosp_name);
                        slots.add(s);
                        s.displaySlot();
                    }
                }
                    else if(val==5) {
                    System.out.print("Enter Patient Unique ID");
                    long userid = scn.nextLong();
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.println("Enter Option:");
                    int op = scn.nextInt();
                    int cde;
                    String vname;
                    int hospitalid;
                    int optslot;
                    String cname;
                    if (op == 1) {
                        System.out.println("Enter the pincode: ");
                        cde = scn.nextInt();
                        for (int i = 0; i < hospitals.size(); i++) {
                            if (hospitals.get(i).pcode == cde) {
                                System.out.println(hospitals.get(i).unique_hID + " " + hospitals.get(i).hospital_name);
                            }
                        }
                        System.out.print("Enter the hospital ID:");
                        hospitalid = scn.nextInt();
                        int flag = 0;
                        for (int i = 0; i < slots.size(); i++) {
                            if (slots.get(i).hospital_id == hospitalid && slots.get(i).quantity > 0) {
                                flag = 1;
                                System.out.println(i + "->" + "Day:" + slots.get(i).days + "Available Qty:" + slots.get(i).quantity + " Vaccine:" + slots.get(i).vaccinedose);
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Slots not available.");
                        } else {
                            System.out.println("Enter the choice: ");
                            optslot = scn.nextInt();
                            int citi_index = 0;
                            int totaldose = 0;
                            for (int i = 0; i < citizens.size(); i++) {
                                if (citizens.get(i).getuniqueid() == userid) {
                                    citi_index = i;
                                    break;
                                }
                            }

                            if (citizens.get(citi_index).getStatus() == 1) {
                                System.out.println(citizens.get(citi_index).getName() + " vaccinated with " + slots.get(optslot).vaccinedose);
                                citizens.get(citi_index).setDoseCount(citizens.get(citi_index).getDosecount() + 1);
                                citizens.get(citi_index).setVaccine(slots.get(optslot).vaccinedose);
                                for (int j = 0; j < vaccine.size(); j++) {
                                    if (citizens.get(citi_index).getVaccineName().equalsIgnoreCase(vaccine.get(j).name)) {
                                        citizens.get(citi_index).vaccinegap = vaccine.get(j).getGap();
                                        citizens.get(citi_index).totaldoses = vaccine.get(j).total_doses;
                                        if (citizens.get(citi_index).getDosecount() == vaccine.get(j).total_doses) {
                                            citizens.get(citi_index).setStatus(3);
                                        } else {
                                            citizens.get(citi_index).setStatus(2);
                                        }
                                    }
                                }
                                citizens.get(citi_index).setDayofvaccine(slots.get(optslot).getDays());
                                slots.get(optslot).setQuantity(slots.get(optslot).getQuantity() - 1);
                            } else if (citizens.get(citi_index).getStatus() == 3) {
                                System.out.println("FULLY VACCINATED");
                            } else if (citizens.get(citi_index).getStatus() == 2) {
                                if (slots.get(optslot).vaccinedose.equalsIgnoreCase(citizens.get(citi_index).getVaccineName())) {
                                    if (citizens.get(citi_index).vaccinegap + citizens.get(citi_index).getDayofvaccine() <= slots.get(optslot).getDays()) {
                                        System.out.println(citizens.get(citi_index).getName() + " vaccinated with " + slots.get(optslot).vaccinedose);
                                        citizens.get(citi_index).setDoseCount(citizens.get(citi_index).getDosecount() + 1);

                                        if (citizens.get(citi_index).getDosecount() == citizens.get(citi_index).totaldoses) {
                                            citizens.get(citi_index).setStatus(3);
                                        } else {
                                            citizens.get(citi_index).setStatus(2);
                                        }
                                    } else {
                                        System.out.println("You are not allowed to take the next dose before due date");
                                    }
                                } else {
                                    System.out.println("You are not supposed to go with the selected vaccine.");
                                }
                            }
                        }
                    } else if (op == 2) {
                        System.out.print("Enter Vaccine Name: ");
                        vname = scn.nextLine();
                        int flag = 0;
                        if (vname.length() == 0) {
                            vname = scn.nextLine();
                        }
                        for (int i = 0; i < slots.size(); i++) {
                            if (slots.get(i).vaccinedose.equals(vname)) {
                                System.out.println(slots.get(i).getHospital_id() + " " + slots.get(i).getHname());
                            }
                        }
                        System.out.print("Enter the hospital ID: ");
                        hospitalid = scn.nextInt();
                        for (int i = 0; i < slots.size(); i++) {
                            if (slots.get(i).hospital_id == hospitalid && slots.get(i).quantity > 0 && slots.get(i).vaccinedose.equals(vname)) {
                                flag = 1;
                                System.out.println(i + "->" + " Day: " + slots.get(i).days + " Available Qty:" + slots.get(i).quantity + " Vaccine:" + slots.get(i).vaccinedose);
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Slots not available.");
                        } else {
                            System.out.print("Enter the choice: ");
                            optslot = scn.nextInt();
                            int citi_index = 0;
                            for (int j = 0; j < citizens.size(); j++) {
                                if (citizens.get(j).getuniqueid() == userid) {
                                    citi_index = j;
                                    break;
                                }
                            }
                            if (citizens.get(citi_index).getStatus() == 1) {
                                System.out.println(citizens.get(citi_index).getName() + " vaccinated with " + slots.get(optslot).vaccinedose);
                                citizens.get(citi_index).setDoseCount(citizens.get(citi_index).getDosecount() + 1);
                                citizens.get(citi_index).setVaccine(slots.get(optslot).vaccinedose);
                                for (int j = 0; j < vaccine.size(); j++) {
                                    if (citizens.get(citi_index).getVaccineName().equalsIgnoreCase(vaccine.get(j).name)) {
                                        citizens.get(citi_index).vaccinegap = vaccine.get(j).getGap();
                                        citizens.get(citi_index).totaldoses = vaccine.get(j).total_doses;

                                        if (citizens.get(citi_index).getDosecount() == vaccine.get(j).total_doses) {
                                            citizens.get(citi_index).setStatus(3);
                                        } else {
                                            citizens.get(citi_index).setStatus(2);
                                        }
                                    }
                                }
                                citizens.get(citi_index).setDayofvaccine(slots.get(optslot).getDays());
                                slots.get(optslot).setQuantity(slots.get(optslot).getQuantity() - 1);
                            } else if (citizens.get(citi_index).getStatus() == 3) {
                                System.out.println("FULLY VACCINATED");
                            } else if (citizens.get(citi_index).getStatus() == 2) {
                                if (slots.get(optslot).vaccinedose.equalsIgnoreCase(citizens.get(citi_index).getVaccineName())) {
                                    if (citizens.get(citi_index).vaccinegap + citizens.get(citi_index).getDayofvaccine() <= slots.get(optslot).getDays()) {
                                        System.out.println(citizens.get(citi_index).getName() + " vaccinated with " + slots.get(optslot).vaccinedose);
                                        citizens.get(citi_index).setDoseCount(citizens.get(citi_index).getDosecount() + 1);

                                        if (citizens.get(citi_index).getDosecount() == citizens.get(citi_index).totaldoses) {

                                            citizens.get(citi_index).setStatus(3);
                                        } else {
                                            citizens.get(citi_index).setStatus(2);
                                        }
                                    } else {
                                        System.out.println("You are not allowed to take the next dose before due date");
                                    }
                                } else {
                                    System.out.println("You are not supposed to go with the selected vaccine.");
                                }
                            }
                        }
                    } else if (op == 3) {
                        //exit
                        int c=0;
                    }
                }
                    else if(val==6) {
                    System.out.print("Enter Hospital ID: ");
                    int hospital_id = scn.nextInt();
                    for (int i = 0; i < slots.size(); i++) {
                        if (slots.get(i).hospital_id == hospital_id) {
                            slots.get(i).availableSlots();
                        }
                    }
                }
                    else if(val==7) {
                    System.out.print("Enter Patient ID:");
                    long id = scn.nextLong();
                    for (int i = 0; i < citizens.size(); i++) {
                        if (citizens.get(i).getuniqueid() == id) {
                            int s = citizens.get(i).getStatus();
                            if (s == 1) {
                                System.out.println("Citizen REGISTERED");
                            } else if (s == 2) {
                                System.out.println("PARTIALLY VACCINATED");
                                System.out.println("Vaccine Given:");
                                System.out.print(citizens.get(i).getVaccineName());
                                System.out.println("Number of Doses Given:");
                                System.out.print(citizens.get(i).getDosecount());
                                System.out.println("Next Dose due date:");
                                System.out.println(citizens.get(i).getDayofvaccine() + citizens.get(i).vaccinegap);
                            } else if (s == 3) {
                                System.out.println("FULLY VACCINATED");
                                System.out.println("Vaccine Given:");
                                System.out.print(citizens.get(i).getVaccineName());
                                System.out.println("Number of Doses Given:");
                                System.out.print(citizens.get(i).getDosecount());
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