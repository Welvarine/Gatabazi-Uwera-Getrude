package casestudy.MissionManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CombatMission extends Mission {
    Scanner sc = new Scanner(System.in);
    Resource resource = new Resource();
    String role;
    int id;
    String name;
    Personnel personnel = new Personnel();

    public CombatMission() {
        System.out.println(" This mission involves military engagement or combat operations.");
        System.out.println("----------------------------------------------------------------");
        System.out.println("You must ENTER ATLEAST 3 PEOPLE FOR THE MISSION");
        int minPeople = 3;
        int count = 1;
        boolean momo = true;
        while (momo) {
            System.out.println("Enter Person " + count + " Details");
            while (true) {
                System.out.print("Enter the ID: ");
                String input = sc.nextLine();
                try {
                    id = Integer.parseInt(input);
                    personnel.setPersonnelID(id);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid integer. Please try again.");
                }
            }

            do {
                System.out.print("Enter the person's name: ");
                name = sc.nextLine();
                if (!name.matches("[a-zA-Z ]+")) {
                    System.out.println(" Invalid name. Use letters and spaces only.");
                }
            } while (!name.matches("[a-zA-Z ]+"));
            personnel.setPersonnelName(name);

            // Loop until valid role
            do {
                System.out.print("Enter the person's role: ");
                role = sc.nextLine();
                if (!role.matches("[a-zA-Z ]+")) {
                    System.out.println(" Invalid role. Use letters and spaces only.");
                }
            } while (!role.matches("[a-zA-Z ]+"));
            personnelList.add(new Personnel(id, name, role));
            count++;
            if (count > minPeople) {
                System.out.println("Do you want to add another person?(YES/NO)");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    momo = true;
                } else if (choice.equalsIgnoreCase("no")) {
                    momo = false;
                }
            }
        }
        Date startDate = getDateInput("Start Date (yyyy-MM-dd): ");
        setStartDate(startDate);
        Date endDate = getDateInput("End Date (yyyy-MM-dd): ");
        while (endDate.before(startDate)) {
            System.out.println("End date cannot be before start date. Please re-enter.");
            endDate = getDateInput("End Date (yyyy-MM-dd): ");
            setEndDate(endDate);
        }
        boolean recon = true;
        while (recon) {
            System.out.println("RECON MISSION OPERATIONS");
            System.out.println("------------------------");
            System.out.println("OPERATION 1: ASSIGNING TASKS");
            System.out.println("OPERATION 2: ALLOCATE RESOURCES");
            System.out.println("OPERATION 3: CHECK MISSION PROGRESS");
            System.out.println("OPERATION 4: GENERATE REPORT");
            System.out.println("Enter the operation you want");
            int choice3 = sc.nextInt();
            switch (choice3) {
                case 1:
                    sc.next();
                    System.out.println("DISPLAYING PERSONNEL");
                    for (Personnel p : personnelList) {
                        assignTask(p);
                        System.out.println(p);
                    }
                    sc.nextLine();
                    System.out.println("Do you want to perform other  Combat Mission Operations?");
                    String ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        recon = true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        recon = false;
                    }
                    break;
                case 2:
                    System.out.println("RESOURCE ALLOCATION");
                    System.out.println("-------------------");
                    allocateResources();
                    sc.nextLine();
                    System.out.println("Do you want to perform other  Combat Mission Operations?");
                    ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        recon = true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        recon = false;
                    }
                    break;
                case 3:
                    System.out.println("MISSION PROGRESS :");
                    System.out.println("------------------");
                    trackMissionProgress();
                    sc.nextLine();
                    System.out.println("Do you want to perform other  Combat Mission Operations?");
                    ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        recon = true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        recon = false;
                    }
                    break;
                case 4:
                    generateMissionReport();
                    sc.nextLine();
                    System.out.println("Do you want to perform other  Combat Mission Operations?");
                    ch = sc.nextLine();
                    if (ch.equalsIgnoreCase("YES")) {
                        recon = true;
                    } else if (ch.equalsIgnoreCase("no")) {
                        recon = false;
                    }
                    break;
            }

        }
    }

    public Date getDateInput(String prompt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        while (true) {
            System.out.print(prompt);
            String dateStr = sc.nextLine();
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    @Override
    public void assignTask(Personnel personnel) {
        System.out.println("AVAILABLE TASKS");
        System.out.println("---------------");
        System.out.println("TASK 1: DEFENSE");
        System.out.println("TASK 2: ATTACK");
        System.out.println("TASK 3: STRATEGY");
        System.out.println("Select the Task Number");
        int task = sc.nextInt();
        if(task==1){
            System.out.println("Task is available");
            personnel.setPersonnelTask("DEFENCE");
        }
        else if (task==2){
            personnel.setPersonnelTask("ATTACK");
        }
        else if (task==3){
            personnel.setPersonnelTask("STRATEGY");
        }
        else{
            System.out.println("Task doesn't exist");
        }
    }

    @Override
    public void allocateResources() {
        System.out.println("RESOURCE ALLOCATION");
        System.out.println("-------------------");
        System.out.println("Enter the Resource ID");
        String id = sc.nextLine();
        resource.setResourceId(id);
        System.out.println("Enter the Resource Name");
        String name = sc.nextLine();
        resource.setResourceName(name);
        System.out.println("Enter the Resource Type");
        String type = sc.nextLine();
        resource.setResourceType(type);
        System.out.println("Enter the Quantity");
        int qty = sc.nextInt();
        resource.setQuantity(qty);
        System.out.println("Resource allocation done");
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("MISSION STATUS");
        System.out.println("---------------");
        System.out.println("Status 1: OPEN");
        System.out.println("Status 2: CLOSED");
        System.out.println("Status 3: PENDING");
        System.out.println("Enter the status number of the Mission");
        int stat = sc.nextInt();
        switch (stat) {
            case 1:
                setStatus("OPEN");
                break;
            case 2:
                setStatus("Closed");
                break;
            case 3:
                setStatus("PENDING....");
                break;
            default:
                System.out.println("Invalid Status");
        }
    }

    @Override
    public void generateMissionReport() {
        boolean det = true;
        while (det) {
            System.out.println("MISSION DETAILS");
            System.out.println("----------------");
            System.out.println("DETAIL 1:THE PERSONNEL INVOLVED IN THE MISSION");
            System.out.println("DETAIL 2:RESOURCES DETAILS");
            System.out.println("DETAIL 3:MISSION STATUS");
            System.out.println("Enter the detail number ");
            int choice4 = sc.nextInt();
            if (choice4 == 1) {
                for (Personnel p : personnelList) {
                    System.out.println(p);
                }
                sc.nextLine();
                System.out.println("Do you want to display other details?");
                String ch = sc.nextLine();
                if (ch.equalsIgnoreCase("YES")) {
                    det = true;
                } else if (ch.equalsIgnoreCase("no")) {
                    det = false;
                }
            } else if (choice4 == 2) {
                System.out.println("RESOURCES ALLOCATED IF ANY");
                System.out.println("Resource ID:" + resource.getResourceId());
                System.out.println("Resource Name:" + resource.getResourceName());
                System.out.println("Resource Type" + resource.getResourceType());
                System.out.println("Resource Quantity" + resource.getQuantity());
                System.out.println("----------------------------------------");
                sc.nextLine();
                System.out.println("Do you want to display other details?");
                String ch = sc.nextLine();
                if (ch.equalsIgnoreCase("YES")) {
                    det = true;
                } else if (ch.equalsIgnoreCase("no")) {
                    det = false;
                }
            } else if (choice4 == 3) {
                System.out.println("MISSION STATUS:" + getStatus());
                System.out.println("---------------------------");
                sc.nextLine();
                System.out.println("Do you want to display other details?");
                String ch = sc.nextLine();
                if (ch.equalsIgnoreCase("YES")) {
                    det = true;
                } else if (ch.equalsIgnoreCase("no")) {
                    det = false;
                }
            }
        }
    }
}

