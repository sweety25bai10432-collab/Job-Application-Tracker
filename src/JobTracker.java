import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class JobTracker {

    private ArrayList<JobApplication> applications;
    private Scanner scanner;

    public JobTracker() {

        applications = FileManager.loadApplications();
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("\nLoading saved applications...");
        System.out.println(applications.size() +
                " applications loaded successfully.");

        int choice;

        do {

            displayMenu();

            choice = readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    addApplication();
                    break;

                case 2:
                    viewApplications();
                    break;

                case 3:
                    searchApplications();
                    break;

                case 4:
                    filterApplications();
                    break;

                case 5:
                    updateApplication();
                    break;

                case 6:
                    deleteApplication();
                    break;

                case 7:
                    Statistics.showStatistics(applications);
                    break;

                case 8:
                    showFollowUps();
                    break;

                case 9:
                    sortApplications();
                    break;

                case 10:
                    exportApplications();
                    break;

                case 0:
                    FileManager.saveApplications(applications);
                    System.out.println("\nData saved successfully.");
                    System.out.println("Thank you for using Job Application Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void displayMenu() {

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║       JOB APPLICATION TRACKER            ║");
        System.out.println("║            Career Manager                ║");
        System.out.println("╚══════════════════════════════════════════╝");

        System.out.println("\n1. Add New Application");
        System.out.println("2. View All Applications");
        System.out.println("3. Search Applications");
        System.out.println("4. Filter Applications");
        System.out.println("5. Update Application");
        System.out.println("6. Delete Application");
        System.out.println("7. Application Statistics");
        System.out.println("8. Upcoming Follow-ups");
        System.out.println("9. Sort Applications");
        System.out.println("10. Export Applications");
        System.out.println("0. Exit");
    }

    private void addApplication() {

        System.out.println("\n========== ADD APPLICATION ==========");

        int id = getNextId();

        System.out.print("Company Name: ");
        String company = scanner.nextLine();

        System.out.print("Job Position: ");
        String position = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Application Date (dd-MM-yyyy): ");
        String date = scanner.nextLine();

        System.out.print("Type (Internship/Full Time): ");
        String type = scanner.nextLine();

        String status = chooseStatus();

        System.out.print("Salary/Stipend: ");
        String salary = scanner.nextLine();

        System.out.print("Source: ");
        String source = scanner.nextLine();

        System.out.print("Deadline (dd-MM-yyyy): ");
        String deadline = scanner.nextLine();

        System.out.print("Follow-up Date (dd-MM-yyyy): ");
        String followUp = scanner.nextLine();

        String priority = choosePriority();

        System.out.print("Notes: ");
        String notes = scanner.nextLine();

        JobApplication application =
                new JobApplication(
                        id,
                        company,
                        position,
                        location,
                        date,
                        type,
                        status,
                        salary,
                        source,
                        deadline,
                        followUp,
                        priority,
                        notes
                );

        applications.add(application);

        FileManager.saveApplications(applications);

        System.out.println("\nApplication added successfully!");
        System.out.println("Application ID: " + id);
    }

    private void viewApplications() {

        System.out.println("\n========== ALL APPLICATIONS ==========");

        if (applications.isEmpty()) {

            System.out.println("No applications found.");
            return;
        }

        for (JobApplication application : applications) {
            application.display();
        }
    }

    private void searchApplications() {

        System.out.println("\n========== SEARCH ==========");

        System.out.print("Enter company or position: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (JobApplication app : applications) {

            if (app.getCompany().toLowerCase().contains(keyword)
                    || app.getPosition().toLowerCase().contains(keyword)) {

                app.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching application found.");
        }
    }

    private void filterApplications() {

        System.out.println("\n========== FILTER ==========");

        System.out.println("1. Applied");
        System.out.println("2. Shortlisted");
        System.out.println("3. Online Test");
        System.out.println("4. Interview");
        System.out.println("5. Selected");
        System.out.println("6. Rejected");
        System.out.println("7. Internship");
        System.out.println("8. Full Time");

        int choice = readInt("Choose filter: ");

        String filter = "";

        switch (choice) {

            case 1:
                filter = "Applied";
                break;

            case 2:
                filter = "Shortlisted";
                break;

            case 3:
                filter = "Online Test";
                break;

            case 4:
                filter = "Interview";
                break;

            case 5:
                filter = "Selected";
                break;

            case 6:
                filter = "Rejected";
                break;

            case 7:
                filter = "Internship";
                break;

            case 8:
                filter = "Full Time";
                break;

            default:
                System.out.println("Invalid filter.");
                return;
        }

        boolean found = false;

        for (JobApplication app : applications) {

            if (app.getStatus().equalsIgnoreCase(filter)
                    || app.getType().equalsIgnoreCase(filter)) {

                app.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No applications found.");
        }
    }

    private void updateApplication() {

        System.out.println("\n========== UPDATE APPLICATION ==========");

        int id = readInt("Enter Application ID: ");

        JobApplication application = findApplication(id);

        if (application == null) {

            System.out.println("Application not found.");
            return;
        }

        System.out.println("\nCurrent Status: " +
                application.getStatus());

        String newStatus = chooseStatus();

        application.setStatus(newStatus);

        System.out.println("Status updated successfully!");

        FileManager.saveApplications(applications);
    }

    private void deleteApplication() {

        System.out.println("\n========== DELETE APPLICATION ==========");

        int id = readInt("Enter Application ID: ");

        JobApplication application = findApplication(id);

        if (application == null) {

            System.out.println("Application not found.");
            return;
        }

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {

            applications.remove(application);

            FileManager.saveApplications(applications);

            System.out.println("Application deleted successfully.");

        } else {

            System.out.println("Deletion cancelled.");
        }
    }

    private void showFollowUps() {

        System.out.println("\n========== FOLLOW-UPS ==========");

        boolean found = false;

        for (JobApplication app : applications) {

            if (!app.getFollowUpDate().isEmpty()) {

                if (DateUtils.isOverdue(app.getFollowUpDate())) {

                    System.out.println("\nOVERDUE");
                    System.out.println("Company: " + app.getCompany());
                    System.out.println("Position: " + app.getPosition());
                    System.out.println("Date: " + app.getFollowUpDate());

                    found = true;

                } else if (DateUtils.isUpcoming(app.getFollowUpDate())) {

                    System.out.println("\nUPCOMING");
                    System.out.println("Company: " + app.getCompany());
                    System.out.println("Position: " + app.getPosition());
                    System.out.println("Date: " + app.getFollowUpDate());

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No upcoming follow-ups.");
        }
    }

    private void sortApplications() {

        System.out.println("\n========== SORT APPLICATIONS ==========");

        System.out.println("1. Company");
        System.out.println("2. Application Date");
        System.out.println("3. Priority");

        int choice = readInt("Choose option: ");

        switch (choice) {

            case 1:

                applications.sort(
                        Comparator.comparing(
                                JobApplication::getCompany
                        )
                );

                break;

            case 2:

                applications.sort(
                        Comparator.comparing(
                                JobApplication::getDate
                        )
                );

                break;

            case 3:

                applications.sort(
                        Comparator.comparing(
                                JobApplication::getPriority
                        )
                );

                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Applications sorted successfully.");

        viewApplications();
    }

    private void exportApplications() {

        String fileName = "applications_report.txt";

        try {

            java.io.PrintWriter writer =
                    new java.io.PrintWriter(
                            new java.io.FileWriter(fileName)
                    );

            writer.println("JOB APPLICATION REPORT");
            writer.println("======================");
            writer.println();

            writer.println("Total Applications: "
                    + applications.size());

            writer.println();

            for (JobApplication app : applications) {

                writer.println("ID: " + app.getId());
                writer.println("Company: " + app.getCompany());
                writer.println("Position: " + app.getPosition());
                writer.println("Location: " + app.getLocation());
                writer.println("Status: " + app.getStatus());
                writer.println("Priority: " + app.getPriority());
                writer.println("--------------------------------");
            }

            writer.close();

            System.out.println(
                    "Report exported to " + fileName
            );

        } catch (java.io.IOException e) {

            System.out.println("Error exporting report.");
        }
    }

    private String chooseStatus() {

        System.out.println("\nSelect Status:");

        System.out.println("1. Applied");
        System.out.println("2. Shortlisted");
        System.out.println("3. Online Test");
        System.out.println("4. Interview");
        System.out.println("5. Selected");
        System.out.println("6. Rejected");

        int choice = readInt("Enter choice: ");

        switch (choice) {

            case 1:
                return "Applied";

            case 2:
                return "Shortlisted";

            case 3:
                return "Online Test";

            case 4:
                return "Interview";

            case 5:
                return "Selected";

            case 6:
                return "Rejected";

            default:
                return "Applied";
        }
    }

    private String choosePriority() {

        System.out.println("\nSelect Priority:");

        System.out.println("1. High");
        System.out.println("2. Medium");
        System.out.println("3. Low");

        int choice = readInt("Enter choice: ");

        switch (choice) {

            case 1:
                return "High";

            case 2:
                return "Medium";

            case 3:
                return "Low";

            default:
                return "Medium";
        }
    }

    private JobApplication findApplication(int id) {

        for (JobApplication app : applications) {

            if (app.getId() == id) {
                return app;
            }
        }

        return null;
    }

    private int getNextId() {

        int max = 0;

        for (JobApplication app : applications) {

            if (app.getId() > max) {
                max = app.getId();
            }
        }

        return max + 1;
    }

    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value = Integer.parseInt(
                        scanner.nextLine()
                );

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}