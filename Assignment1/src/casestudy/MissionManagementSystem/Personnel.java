package casestudy.MissionManagementSystem;

import java.util.Scanner;

public class Personnel {
    private int personnelID;
    private String personnelName;
    private String personnelRole;
    private String personnelTask;
    Scanner sc= new Scanner(System.in);
    public String getPersonnelTask() {
        return personnelTask;
    }

    public void setPersonnelTask(String personnelTask) {
        this.personnelTask = personnelTask;
    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        if(sc.hasNextInt()){
            this.personnelID = personnelID;
        }
        else{
            System.out.println("Only integers allowed please");
        }
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        if(personnelName.matches("[a-zA-Z]+")){
            this.personnelName = personnelName;
        }
        else {
            System.out.println("Only Alphabets please");
        }

    }

    public String getPersonnelRole() {

        return personnelRole;
    }

    public void setPersonnelRole(String personnelRole) {
        if(personnelRole.matches("[a-zA-Z]+")){
            this.personnelRole = personnelRole;
        }
        else {
            System.out.println("Only Alphabets please");
        }
    }

    public Personnel(int personnelID, String personnelName,String personnelRole) {
        this.personnelID = personnelID;
        this.personnelName = personnelName;
        this.personnelRole=personnelRole;

    }
    public Personnel(){

    }

    public Personnel(String personnelRole) {
        this.personnelRole = personnelRole;
    }

    public static void assignedMission(){

    }

    @Override
    public String toString() {
        return "Personnel ID:"+personnelID+ " Personnel Name:"+personnelName+
                " Personnel Role:"+personnelRole+" Personnel Task:"+personnelTask;

    }
}
