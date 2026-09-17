import java.util.ArrayList;

public class Statistics {

    public static void showStatistics(ArrayList<JobApplication> applications) {

        int applied = 0;
        int shortlisted = 0;
        int onlineTest = 0;
        int interview = 0;
        int selected = 0;
        int rejected = 0;

        int internship = 0;
        int fullTime = 0;

        for (JobApplication app : applications) {

            switch (app.getStatus().toLowerCase()) {

                case "applied":
                    applied++;
                    break;

                case "shortlisted":
                    shortlisted++;
                    break;

                case "online test":
                    onlineTest++;
                    break;

                case "interview":
                    interview++;
                    break;

                case "selected":
                    selected++;
                    break;

                case "rejected":
                    rejected++;
                    break;
            }

            if (app.getType().equalsIgnoreCase("Internship")) {
                internship++;
            }

            if (app.getType().equalsIgnoreCase("Full Time")) {
                fullTime++;
            }
        }

        int total = applications.size();

        System.out.println("\n========== APPLICATION STATISTICS ==========");

        System.out.println("Total Applications : " + total);

        System.out.println("\nBy Status");
        System.out.println("--------------------------------");
        System.out.println("Applied            : " + applied);
        System.out.println("Shortlisted        : " + shortlisted);
        System.out.println("Online Test        : " + onlineTest);
        System.out.println("Interview          : " + interview);
        System.out.println("Selected           : " + selected);
        System.out.println("Rejected           : " + rejected);

        System.out.println("\nBy Type");
        System.out.println("--------------------------------");
        System.out.println("Internship         : " + internship);
        System.out.println("Full Time          : " + fullTime);

        if (total > 0) {

            double interviewRate =
                    ((double) interview / total) * 100;

            double selectionRate =
                    ((double) selected / total) * 100;

            System.out.printf("\nInterview Rate     : %.2f%%%n", interviewRate);
            System.out.printf("Selection Rate     : %.2f%%%n", selectionRate);
        }

        System.out.println("============================================");
    }
}