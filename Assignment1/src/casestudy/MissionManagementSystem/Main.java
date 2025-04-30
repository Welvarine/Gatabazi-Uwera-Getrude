package casestudy.MissionManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        Personnel personnel;
        while (condition) {
            System.out.println("MISSION TYPE");
            System.out.println("---------------------------------------");
            System.out.println("MISSION 1: Recon ");
            System.out.println("MISSION 2: Rescue ");
            System.out.println("MISSION 3: Combat ");
            System.out.println("MISSION 4: Humanitarian");
            System.out.println("Enter the mission to complete:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Mission recon = new RiconMission();
                    sc.nextLine();
                    System.out.println("Do you want to Operations other missions");
                    String ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                         condition= true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        condition = false;
                    }
                    break;
                case 2:
                    Mission resuce = new RescueMission();
                    sc.nextLine();
                    System.out.println("Do you want to Operate OTHER MISSIONS");
                    ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        condition= true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        condition = false;
                    }
                    break;
                case 3:
                    Mission combat = new CombatMission();
                    sc.nextLine();
                    System.out.println("Do you want to Operations other missions");
                    ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        condition= true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        condition = false;
                    }
                    break;
                case 4:
                    Mission human = new HumanitarianMission();
                    sc.nextLine();
                    System.out.println("Do you want to Operations other missions");
                     ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        condition= true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        condition = false;
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    sc.nextLine();
                    System.out.println("Do you want to Operations other missions");
                     ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        condition= true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        condition = false;
                    }
                    break;
            }
        }

    }
}


