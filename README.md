# 💼 Job Application Tracker

> A simple Java console application to manage job and internship applications in one place.

---
## Student Details

**Name:** Sweety Kumari  
**Registration Number:** 25BAI10432

**GitHub:** https://github.com/sweety25bai10432-collab/Job-Application-Tracker

---

## 📌 Overview

Applying for multiple jobs and internships can become difficult to manage. It is easy to forget application dates, deadlines, follow-ups, or the current status of an application.

**Job Application Tracker** is a Java-based console application that helps users store and manage all these details from a single place.

The project is completely **command-line based**, so it can be compiled and executed directly from a terminal without requiring any external libraries.

---

## ✨ Features

| Feature              | Description                                    |
| -------------------- | ---------------------------------------------- |
| ➕ Add Application    | Store details of a new job or internship       |
| 📋 View Applications | Display all saved applications                 |
| 🔎 Search            | Search using company or position               |
| 🔍 Filter            | Filter applications by status or type          |
| 🔄 Update            | Change the status of an application            |
| 🗑️ Delete           | Remove an application                          |
| 📊 Statistics        | View application statistics                    |
| 📅 Follow-ups        | Check upcoming and overdue follow-ups          |
| ↕️ Sort              | Sort applications by company, date or priority |
| 📄 Export            | Generate an application report                 |
| 💾 File Storage      | Automatically save application data            |

---

## 🛠️ Technologies Used

* **Java**
* **OOP (Object-Oriented Programming)**
* **ArrayList**
* **File Handling**
* **Polymorphism**
* **Exception Handling**
* **Java Date & Time API**
* **Comparator**
* **Scanner**

No external libraries or frameworks are required.

---

## 📂 Project Structure

```text
Job Application Tracker/
│
├── src/
│   ├── Main.java
│   ├── JobApplication.java
│   ├── JobTracker.java
│   ├── FileManager.java
│   ├── Statistics.java
│   └── DateUtils.java
│
├── data/
│   └── applications.txt
│
├── README.md
└── .gitignore
```

### What each class does

**`Main.java`**
Starts the application.

**`JobApplication.java`**
Represents an individual job or internship application.

**`JobTracker.java`**
Handles the main menu and application operations.

**`FileManager.java`**
Saves and loads application data from the text file.

**`Statistics.java`**
Calculates and displays application statistics.

**`DateUtils.java`**
Handles date-related operations such as upcoming and overdue follow-ups.

---

## 🔄 How the Application Works

```text
        START
          │
          ▼
    Main Menu
          │
    ┌─────┴─────┐
    ▼           ▼
 Add Data    View/Search
    │           │
    └─────┬─────┘
          ▼
   Manage Applications
          │
    ┌─────┼─────────┐
    ▼     ▼         ▼
 Update  Filter    Sort
          │
          ▼
       Save Data
          │
          ▼
         EXIT
```

---

## 💻 Requirements

Before running the project, make sure **Java JDK** is installed.

Check the installation using:

```text
java -version
javac -version
```

The project does not require any external dependencies.

---

## ▶️ How to Run

### Step 1 — Open the project folder

Open Command Prompt or PowerShell in the main project folder.

### Step 2 — Compile

```text
javac src\*.java -d out
```

The compiled `.class` files will be placed in the `out` folder.

### Step 3 — Run

```text
java -cp out Main
```

The application menu will appear in the terminal.

---

## 🎮 Main Menu

```text
╔══════════════════════════════════════════╗
║       JOB APPLICATION TRACKER            ║
║            Career Manager                ║
╚══════════════════════════════════════════╝

1. Add New Application
2. View All Applications
3. Search Applications
4. Filter Applications
5. Update Application
6. Delete Application
7. Application Statistics
8. Upcoming Follow-ups
9. Sort Applications
10. Export Applications
0. Exit
```
<img width="460" height="662" alt="Screenshot 2026-09-17 220013" src="https://github.com/user-attachments/assets/288a61f6-a753-40ac-94e5-997c35a5a5e5" />

---

## 📝 Application Details

For each application, the following information can be stored:

* Company name
* Job position
* Location
* Application date
* Application type
* Current status
* Salary/Stipend
* Application source
* Deadline
* Follow-up date
* Priority
* Notes

### Available Statuses

```text
Applied
Shortlisted
Online Test
Interview
Selected
Rejected
```

### Priority Levels

```text
High
Medium
Low
```

---

## 💾 Data Storage

Application data is stored locally in:

```text
data/applications.txt
```

The program automatically saves the information when changes are made.

The user does not need to manually enter data into the file.

---

## 📊 Statistics

The statistics section provides information such as:

* Total applications
* Applications by status
* Internship applications
* Full-time applications
* Interview rate
* Selection rate

Example:

```text
========== APPLICATION STATISTICS ==========

Total Applications : 5

By Status
--------------------------------
Applied            : 2
Shortlisted        : 1
Interview          : 1
Selected           : 1

By Type
--------------------------------
Internship         : 4
Full Time          : 1
```

---

## 📅 Follow-up Tracking

The application can also track follow-up dates.

The program identifies:

* **Upcoming** follow-ups
* **Overdue** follow-ups

This helps the user remember applications that require further action.

---

## 📄 Export

The **Export Applications** option creates a simple report containing important application details.

The report is saved as:

```text
data/applications_report.txt
```

---

---

## 🎯 Purpose of the Project

The main purpose of this project is to create a simple application that can be useful for students and job seekers while demonstrating fundamental Java programming concepts.

It combines basic Java concepts into one practical console-based application.

---


Java Programming Project

---

