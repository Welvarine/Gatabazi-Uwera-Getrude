package casestudy.MissionManagementSystem;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Mission {
    private String missionID;
    private String missionName;
    private Date startDate;
    private Date endDate;
    private String status;
    List<Personnel> personnelList = new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public String getMissionID() {
        return missionID;
    }

    public void setMissionID(String missionID) {
        if(sc.hasNextInt()){
            this.missionID = missionID;
        }
        else{
            System.out.println("Only integers allowed ");
        }

    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        if(missionName.matches("[a-zA-Z]+")){
            this.missionName = missionName;
        }
        else {
            System.out.println("Only Alphabets");
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status.equalsIgnoreCase("PLANNED")|| status.equalsIgnoreCase("IN PROGRESS") || status.equalsIgnoreCase("COMPLETED") ||
        status.matches("[a-zA-Z]+")){
            this.status = status;
        }
        else{
            System.out.println("Wrong Status");
        }

    }

    public abstract void assignTask(Personnel personnel);
    public abstract void allocateResources();
    public abstract void trackMissionProgress();
    public abstract void generateMissionReport();

}
