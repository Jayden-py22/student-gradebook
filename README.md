# Student Gradebook – Java Sprint Project

This is a Java-based command-line application that allows users to manage a simple student gradebook. It was developed during a two-week Sprint focused on learning core Java concepts and applying them in a structured, object-oriented program.

## Requirements Completed

This project demonstrates all **5 required features**:

1. **Conditionals**  
   - Used `if`, `else if`, `else`, and `switch` statements to validate user input, handle errors, and process menu options.

2. **Loops**  
   - Used `while` loop for the interactive main menu.
   - Used `for` loop to calculate student grade averages and iterate over grade lists.

3. **Functions**  
   - Organized logic into reusable methods such as `addStudent()`, `addGrade()`, `viewAverage()`, and `saveToFile()`.

4. **Classes**  
   - The program contains multiple custom classes:  
     - `Student`: stores student name and list of grades  
     - `Gradebook`: handles operations on student data  
     - `FileManager`: manages reading and writing to a file

5. **Java Collection Framework**  
   - Used `HashMap<String, Student>` to store and access student records.  
   - Used `ArrayList<Integer>` to store each student's list of grades.

## Stretch Challenge Completed

**Stretch Challenge: File I/O**  
- Implemented reading and writing student data to a text file (`gradebook.txt`).  
- Used `BufferedReader` and `BufferedWriter` to persist data between program runs.  
- Data is automatically loaded on startup and saved upon exiting the program.

## Project Structure
student-gradebook/
├── Main.java
├── model/
│   └── Student.java
├── service/
│   └── Gradebook.java
├── util/
│   └── FileManager.java
├── gradebook.txt
├── README.md
├── .gitignore
└── LICENSE
## How to Run

### Compile:
```bash
javac Main.java model/*.java service/*.java util/*.java