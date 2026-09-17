public class JobApplication {

    private int id;
    private String company;
    private String position;
    private String location;
    private String date;
    private String type;
    private String status;
    private String salary;
    private String source;
    private String deadline;
    private String followUpDate;
    private String priority;
    private String notes;

    public JobApplication(int id, String company, String position,
                          String location, String date, String type,
                          String status, String salary, String source,
                          String deadline, String followUpDate,
                          String priority, String notes) {

        this.id = id;
        this.company = company;
        this.position = position;
        this.location = location;
        this.date = date;
        this.type = type;
        this.status = status;
        this.salary = salary;
        this.source = source;
        this.deadline = deadline;
        this.followUpDate = followUpDate;
        this.priority = priority;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getSalary() {
        return salary;
    }

    public String getSource() {
        return source;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public String getPriority() {
        return priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void display() {

        System.out.println("----------------------------------------");
        System.out.println("ID              : " + id);
        System.out.println("Company         : " + company);
        System.out.println("Position        : " + position);
        System.out.println("Location        : " + location);
        System.out.println("Application Date: " + date);
        System.out.println("Type            : " + type);
        System.out.println("Status          : " + status);
        System.out.println("Salary/Stipend  : " + salary);
        System.out.println("Source          : " + source);
        System.out.println("Deadline        : " + deadline);
        System.out.println("Follow-up Date  : " + followUpDate);
        System.out.println("Priority        : " + priority);
        System.out.println("Notes           : " + notes);
        System.out.println("----------------------------------------");
    }

    public String toFileString() {

        return id + "|" +
                company + "|" +
                position + "|" +
                location + "|" +
                date + "|" +
                type + "|" +
                status + "|" +
                salary + "|" +
                source + "|" +
                deadline + "|" +
                followUpDate + "|" +
                priority + "|" +
                notes;
    }
}