package projectprog;
import java.util.Scanner;
import java.util.Date;

class Doctor{
    private String name, ID, specialty;
    public Doctor(){
        this.name="";
        this.specialty="";
        this.ID="";
    }
    public Doctor(String name, String ID, String specialty){
        this.name=name;
        this.ID=ID;
        this.specialty=specialty;
    }
    public Prescription assignprescription(Patient patient){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter patient's disease: ");
        String d=input.nextLine();
        System.out.println("Enter patient's presciption: ");
        String x=input.nextLine();
        System.out.println("Enter duration in days: ");
        int y=input.nextInt();
        Prescription p=new Prescription(patient.getpatientID(),x, y,d );
        patient.setprescription(p);
        return p; 
    }
    public void addabill(Patient p,int amount){
        System.out.println("Patient name: "+ p.getpatientname() + "\nPatient ID: "+ p.getpatientID() + "\nAmount: "+ amount);
    }         
}

class Patient {
    private String patientname,patientID,gender;
    private Date dateofbirth,appointmentdate;
    private Prescription prescription;
    public Patient(){
        this.patientname = "";
        this.patientID = "";
        this.gender = "";
        this.dateofbirth = new Date(0,0,0);
        this.appointmentdate = new Date(0,0,0);
    }
    public Patient(String patientname,String patientID,String gender, Date dateofbirth, Date appointmentdate){
        this.patientname = patientname;
        this.patientID = patientID;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.appointmentdate = appointmentdate;
    }
    public void setpatientname(String patientname){
        this.patientname = patientname;
    }
    public void setID(String patientID){
        this.patientID = patientID;
    }
    public void setgender(String gender){
        this.gender = gender;
    }
    public void setdateofbirth(Date dateofbirth){
        this.dateofbirth = dateofbirth;
    }
    public void setappointmentdate(Date appointmentdate){
        this.appointmentdate = appointmentdate;
    }
    public void setprescription(Prescription p){
        this.prescription = p;
    }
    public String getpatientname(){
        return this.patientname;
    }
    public String getpatientID(){
        return this.patientID;
    }
    public String getgender(){
        return this.gender;
    }
    public Date getdateofbirth(){
        return dateofbirth;
    }
    public Date getappointmentdate(){
        return this.appointmentdate;
    }
    public void makereservation(Date appointmentdate){
        System.out.println("Appointment Successfully booked");
    }
    public void printprescription(Prescription prescription){
        prescription.tostring();
    }
}
class Prescription{
    private String patientID, medications, diseasename;
    private int durationindays;
    public Prescription(){
        this.patientID = "";
        this.medications = "";
        this.durationindays = 0;
        this.diseasename = "";
    }
    public Prescription(String patientID, String medications, int durationdays, String diseasename ){
        this.patientID = patientID;
        this.medications = medications;
        this.durationindays = durationdays;
        this.diseasename = diseasename;
    }
    public void setpatientID(String patientID){
        this.patientID = patientID;
        }
    public String getpatientID(){
            return patientID;
        }
    public void setmedications(String medications){
        this.medications = medications;
        }
    public String getmedications(){
            return medications;
    }
    public void setdurationindays(int durationindays){
        this.durationindays = durationindays;
        }
    public int getdurationindays(){
            return durationindays;
        }
    public void setdiseasename(String diseasename){
        this.diseasename = diseasename;
        }
    public String getdiseasename(){
            return diseasename;
        }
    public void tostring(){
        System.out.println("patient ID: "+patientID+"\nmedications: "+medications+"\nduration in days: "+durationindays+"\ndiseasename: "+diseasename);
    }
}
public class MedicalSystemAdmin{
    public static void main(String[] args){
         Scanner input=new Scanner(System.in);
         
         
         int option=0, option2=0, option3=0;
         while(option!=3){
             System.out.println("Select an option\n 1) Add new doctor\n 2) Add new patient \n 3) Exit");
             option=input.nextInt();
             input.nextLine();
             switch(option){
                 case 1: 
                     System.out.println("Enter doctor name: ");
                     String name=input.nextLine();
                     System.out.println("Enter doctor ID: ");
                     String ID=input.nextLine();
                     System.out.println("Enter doctor specialty: ");
                     String specialty=input.nextLine();
                     Doctor dr=new Doctor(name,ID,specialty);
                     System.out.println("Enter patient name: ");
                          String nm=input.nextLine();
                          System.out.println("Enter patient ID: ");
                          String id=input.nextLine();
                          String gdr="";
                          boolean correct= false;
                          while (!correct) {
                                        try {
                                         System.out.print("Enter patient gender (M/F): ");
                                         gdr = input.nextLine();
                                         if (!gdr.equalsIgnoreCase("M") && !gdr.equalsIgnoreCase("F")) {
                                         throw new Exception("Invalid input. Please enter M or F.");
                                         }
                                         correct = true;
                                         } 
                                        catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        }
                                        }
                          
                          System.out.println("Enter patient year of birth: ");
                          int year=input.nextInt();
                          System.out.println("Enter patient month of birth: ");
                          int month=input.nextInt();
                          System.out.println("Enter patient day of birth: ");
                          int day=input.nextInt();
                          Date dob=new Date(year,month, day);
                          System.out.println("Enter patient year of appointement: ");
                          int yearap=input.nextInt();
                          System.out.println("Enter patient month of appointement: ");
                          int monthap=input.nextInt();
                          System.out.println("Enter patient day of appointement: ");
                          int dayap=input.nextInt();
                          Date doa=new Date(yearap,monthap, dayap);
                          Patient pt=new Patient(nm,id,gdr,dob,doa);
                          
                     
                     while(option2!=3){
                          System.out.println("Select an option\n 1) Add a bill\n 2) Add new prescription \n 3) Exit");
                          option2=input.nextInt();
                          input.nextLine();
                          switch(option2){
                                     case 1:
                                         System.out.println("Enter amount: ");
                                         int amount=input.nextInt();
                                         dr.addabill(pt, amount);
                                         break;
                                     
                                     case 2:
                                         dr.assignprescription(pt);
                                         break;
                                     case 3:
                                         break;
                          }}
                     break;
                case 2: 
                          System.out.println("Enter patient name: ");
                          String nm2=input.nextLine();
                          System.out.println("Enter patient ID: ");
                          String id2=input.nextLine();
                          String gdr2="";
                          boolean correct2= false;
                          while (!correct2) {
                                        try {
                                         System.out.print("Enter patient gender (M/F): ");
                                         gdr2 = input.nextLine();
                                         if (!gdr2.equalsIgnoreCase("M") && !gdr2.equalsIgnoreCase("F")) {
                                         throw new Exception("Invalid input. Please enter M or F.");
                                         }
                                         correct2= true;
                                         } 
                                        catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        }
                                        }
                          
                          System.out.println("Enter year of birth: ");
                          int year2=input.nextInt();
                          System.out.println("Enter month of birth: ");
                          int month2=input.nextInt();
                          System.out.println("Enter day of birth: ");
                          int day2=input.nextInt();
                          Date dob2=new Date(year2,month2, day2);
                          System.out.println("Enter year of appointement: ");
                          int yearap2=input.nextInt();
                          System.out.println("Enter month of appointement: ");
                          int monthap2=input.nextInt();
                          System.out.println("Enter day of appointement: ");
                          int dayap2=input.nextInt();
                          Date doa2=new Date(yearap2,monthap2, dayap2);
                          Patient pt2=new Patient(nm2,id2,gdr2,dob2,doa2);
                         
                     while(option3!=3){
                          System.out.println("Select an option\n 1) Reserve appointment \n 2) Print prescription \n 3) Exit");
                          option3=input.nextInt();
                          input.nextLine();
                          switch(option3){
                                     case 1:
                                         pt2.makereservation(doa2);
                                         break;
                                     
                                     case 2:
                                          String str=pt2.getpatientID();
                                          System.out.println("Enter patient medication: ");
                                          String med=input.nextLine();
                                         
                                          System.out.println("Enter duration days: ");
                                          int dd=input.nextInt();
                                          input.nextLine();
                                          System.out.println("Enter disease name: ");
                                          String disease=input.nextLine();
                                          Prescription pp=new Prescription(str,med,dd,disease);
                                          pt2.printprescription(pp);
                                         break;
                                     case 3:
                                         break;
                          }}
                     break;
                case 3:
                    break;
             
             
         }
    }  
}
    }
