# CampusCourseRecordsManager
# Campus Course & Records Manager (CCRM)
## 📸 Screenshots Available in Release

All application screenshots are included in the project release:

### Screenshots Included:
-  - JDK 21 verification
-  - Eclipse setup
- - Program main menu

📦 **Download the full project ZIP from [Releases](https://github.com/your-username/CampusCourseRecordsManager/releases) to view all screenshots.**
## Project Overview
A console-based Java application for managing students, courses, enrollments, and grades in an educational institution. Built with Java SE 21 following OOP principles and modern Java features.

## 🚀 How to Run
**Requirements:** JDK 21+, Eclipse IDE

**Steps:**
1. **Download the project:** Visit [Releases page](https://github.com/rajnandinimitra/CampusCourseRecordsManager/releases) and download `CampusCourseRecordsManager.zip`
2. **Extract the ZIP file** to your preferred location
3. **Open Eclipse** → File → Import → Existing Projects into Workspace
4. **Select the extracted folder** as root directory
5. **Run `MainApp.java`** from `edu.ccrm.cli` package

## 📜 Java Evolution Timeline
- **1996:** Java 1.0 (Oak) - Initial release
- **2004:** Java 5 (Tiger) - Generics, Autoboxing, Enhanced for loop
- **2014:** Java 8 (Lambdas) - Lambda expressions, Streams API, Date/Time API
- **2018:** Java 11 (LTS) - Long-term support release
- **2023:** Java 21 (LTS) - Current long-term support with virtual threads

## 📊 Java Platforms Comparison
| Platform | Purpose | Use Case |
|----------|---------|----------|
| **Java ME** | Mobile & Embedded | IoT devices, mobile applications, embedded systems |
| **Java SE** | Standard Edition | Desktop applications, core Java development |
| **Java EE** | Enterprise Edition | Large-scale distributed systems, web applications |

## 🏗️ JDK vs JRE vs JVM
- **JDK (Java Development Kit):** Complete development environment including compiler, debugger, and development tools. Needed for writing Java programs.
- **JRE (Java Runtime Environment):** Contains libraries and JVM required to run Java applications. End-users only need JRE.
- **JVM (Java Virtual Machine):** Executes Java bytecode, provides platform independence through "write once, run anywhere" capability.

## 🔧 Installation & Setup

### JDK Installation on macOS
![JDK Verification]

1. Download JDK 21 from Oracle website
2. Run the installer package
3. Verify installation: `java -version` in Terminal
4. Set JAVA_HOME environment variable

### Eclipse IDE Setup
![Eclipse Project]
1. Download Eclipse IDE for Java Developers
2. Extract and launch Eclipse
3. Create new Java project or import existing one
4. Configure JDK 21 as execution environment

## ✅ Features Implemented

### Core Functionality
- ✅ Student Management (Add, View, Update, Deactivate)
- ✅ Course Management (Add, Search, Filter using Streams API)
- ✅ Enrollment System with Grading
- ✅ GPA Calculation & Transcript Generation
- ✅ Menu-driven Console Interface

### OOP Principles Demonstrated
- ✅ **Encapsulation:** Private fields with public getters/setters
- ✅ **Inheritance:** Person → Student, Person → Instructor
- ✅ **Abstraction:** Abstract Person class with abstract methods
- ✅ **Polymorphism:** Method overriding, interface implementations

### Java Advanced Features
- ✅ **Streams API:** Filtering, searching operations
- ✅ **Enums:** Semester, Grade with constructors and fields
- ✅ **Date/Time API:** Creation timestamps
- ✅ **Collections Framework:** ArrayList, List operations

CampusCourseRecordsManager/
├── 📁 src/                          # Source code
│   ├── 📁 edu.ccrm.cli/            # Command-line interface
│   │   └── Main.java               # Application entry point
│   ├── 📁 edu.ccrm.domain/         # Domain models
│   │   ├── Person.java             # Abstract base class
│   │   ├── Student.java            # Student entity
│   │   ├── Course.java             # Course entity  
│   │   ├── Enrollment.java         # Enrollment entity
│   │   ├── Instructor.java         # Instructor entity
│   │   ├── Semester.java           # Enum: SPRING, SUMMER, FALL
│   │   └── Grade.java              # Enum: A, B, C, D, F with points
│   ├── 📁 edu.ccrm.service/        # Business logic
│   │   ├── StudentService.java     # Student operations
│   │   ├── CourseService.java      # Course operations
│   │   └── EnrollmentService.java  # Enrollment & grading
│   ├── 📁 edu.ccrm.io/             # File I/O operations
│   ├── 📁 edu.ccrm.util/           # Utilities
│   ├── 📁 edu.ccrm.config/         # Configuration
│   └── module-info.java            # Module declaration
│
├── 📁 test-data/                   # Sample data for testing
│   ├── 📄 students.csv             # Sample student data (Indian names)
│   └── 📄 courses.csv              # Sample course data
│
├── 📁 screenshots/                 # Documentation screenshots
│   ├── 📄 jdk-version.png          # JDK installation verification
│   ├── 📄 eclipse-setup.png        # Eclipse project structure
│   ├── 📄 main-menu.png            # Program main menu
│   ├── 📄 courses.png              # Course management view
│   └── 📄 students.png             # Student management view
│
├── 📄 README.md                    # Project documentation
├── 📄 .gitignore                   # Git ignore rules
└── 📄 .classpath                   # Eclipse configuration

## ✅ CSV Import/Export Functionality

The application demonstrates file I/O operations with CSV files:

### Features Implemented:
- **CSV Export:** Export current student and course data to CSV format
- **CSV Import:** Import data from properly formatted CSV files
- **Indian Data Support:** Tested with sample data containing Indian names
- **NIO.2 File Operations:** Uses modern Java file handling APIs

### Sample CSV Format:
ID,Name,Email,Registration Number,Status,GPA
S001,Arjun Sharma,arjun.sharma@edu.in,2024CS1001,ACTIVE,3.8
S002,Priya Patel,priya.patel@edu.in,2024CS1002,ACTIVE,3.6

text

### Usage:
1. Place CSV files in the project directory
2. Use the CSV menu options to import/export data
3. Files are processed using Java NIO.2 for robust file handling
