# CampusCourseRecordsManager
# Campus Course & Records Manager (CCRM)

## Project Overview
A console-based Java application for managing students, courses, enrollments, and grades in an educational institution. Built with Java SE 21 following OOP principles and modern Java features.

## 🚀 How to Run
**Requirements:** JDK 21+, Eclipse IDE

**Steps:**
1. **Download the project:** Visit [Releases page](https://github.com/rajnandinimitra/CampusCourseRecordsManager/releases) and download `CampusCourseRecordsManager.zip`
2. **Extract the ZIP file** to your preferred location
3. **Open Eclipse** → File → Import → Existing Projects into Workspace
4. **Select the extracted folder** as root directory
5. **Run `Main.java`** from `edu.ccrm.cli` package

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
![JDK Verification](screenshots/jdk-version.png)

1. Download JDK 21 from Oracle website
2. Run the installer package
3. Verify installation: `java -version` in Terminal
4. Set JAVA_HOME environment variable

### Eclipse IDE Setup
![Eclipse Project](screenshots/eclipse-project.png)

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

## 🏗️ Project Structure
