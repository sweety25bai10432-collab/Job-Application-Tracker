import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "data/applications.txt";

    public static void saveApplications(ArrayList<JobApplication> applications) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_NAME))) {

            for (JobApplication application : applications) {
                writer.println(application.toFileString());
            }

        } catch (IOException e) {
            System.out.println("Error saving applications.");
        }
    }

    public static ArrayList<JobApplication> loadApplications() {

        ArrayList<JobApplication> applications = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return applications;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length == 13) {

                    JobApplication application =
                            new JobApplication(
                                    Integer.parseInt(data[0]),
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4],
                                    data[5],
                                    data[6],
                                    data[7],
                                    data[8],
                                    data[9],
                                    data[10],
                                    data[11],
                                    data[12]
                            );

                    applications.add(application);
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading applications.");
        }

        return applications;
    }
}
