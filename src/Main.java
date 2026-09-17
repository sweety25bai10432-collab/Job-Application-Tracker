public class Main {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("        JOB APPLICATION TRACKER");
        System.out.println("             Career Manager");
        System.out.println("==========================================");

        JobTracker tracker = new JobTracker();

        tracker.start();
    }
}