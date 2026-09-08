# 🚀 Selenium WebDriver Automation Framework

A Java-based **Selenium WebDriver test automation framework** built with **Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), reusable utilities, TestNG listeners, retry handling, screenshots, logging, and Extent Reports**.

This project demonstrates practical experience in designing and implementing a structured web automation framework rather than maintaining isolated Selenium scripts.

---

## 🎯 Project Overview

The framework was developed as a hands-on automation project to practice and demonstrate:

* Selenium WebDriver automation
* Page Object Model architecture
* Reusable framework utilities
* TestNG-based test execution
* Dynamic element handling
* Synchronization and explicit waits
* Browser and DOM interactions
* Test listeners and retry handling
* Screenshot capture
* External configuration
* Logging
* HTML test reporting
* Maven-based project management
* Git/GitHub version control

The project contains multiple automation scenarios covering both fundamental and advanced Selenium WebDriver concepts.

---

## 🛠️ Technology Stack

| Technology             | Purpose                         |
| ---------------------- | ------------------------------- |
| **Java**               | Programming language            |
| **Selenium WebDriver** | Browser automation              |
| **TestNG**             | Test execution and assertions   |
| **Maven**              | Dependency and build management |
| **Page Object Model**  | Framework architecture          |
| **Extent Reports**     | HTML test reporting             |
| **Git & GitHub**       | Version control                 |
| **IntelliJ IDEA**      | Development environment         |

---

# 🏗️ Framework Architecture

The framework follows a structured **Page Object Model (POM)** architecture.

```text
                         testng.xml
                             │
                             ▼
                       TestNG Suite
                             │
                             ▼
                         BaseTest
                             │
                             ▼
                       Test Classes
                             │
                             ▼
                        Page Objects
                             │
                             ▼
                    Selenium WebDriver
                             │
                             ▼
                          Browser
```

Reusable framework components support the test execution:

```text
                    ┌─────────────────────┐
                    │ Configuration       │
                    │ ConfigReader        │
                    └──────────┬──────────┘
                               │
                               ▼
┌──────────────┐      ┌──────────────────┐
│ Test Classes │ ───► │  Page Objects    │
└──────────────┘      └────────┬─────────┘
                               │
                               ▼
                       Selenium WebDriver
                               │
              ┌────────────────┼────────────────┐
              ▼                ▼                ▼
          WaitUtil        WindowUtil      DownloadUtil
              │
              ▼
       ScreenshotUtil
              │
              ▼
       TestNG Listener
              │
              ▼
          Logging
              │
              ▼
       Extent Reports
```

---

# 📚 Selenium Concepts Covered

## 🔹 Basic Web Interactions

* Browser navigation
* Text fields
* Buttons
* Checkboxes
* Radio buttons
* Dropdowns
* WebElement interactions
* Element state verification

## 🔹 Selenium Locators

The framework demonstrates multiple locator strategies:

* ID
* Name
* Class Name
* CSS Selector
* XPath

## 🔹 Synchronization & Dynamic Elements

* Explicit waits
* Synchronization strategies
* Dynamic content
* Dynamic elements
* Stale elements
* Dynamic lists
* Network delays
* Random/failing elements

## 🔹 Browser & DOM Interactions

* Alerts
* Modal dialogs
* iFrames
* Shadow DOM
* Hidden elements
* Complex DOM structures
* Scrolling
* Multiple browser windows and tabs

## 🔹 Advanced User Interactions

* Mouse hover
* Drag and drop
* Tooltips
* Keyboard actions
* Slider interactions
* Resizable elements
* Date picker interactions

## 🔹 File & Browser Operations

* File upload
* File download
* Authentication scenarios
* Screenshots
* Browser/window management

## 🔹 Framework-Level Automation

* Page Object Model
* Reusable utilities
* TestNG listeners
* Retry handling
* External configuration
* Logging
* HTML reporting
* Maven execution

---

# 📄 Page Object Model

The framework separates page-specific Selenium interactions from test execution.

For example:

```text
S13_DragAndDropPage.java
              │
              ▼
S13_DragAndDropTest.java
```

The **Page Object** contains page-specific interaction logic, while the **Test class** contains the test workflow and validations.

### Benefits

* Improved maintainability
* Reduced code duplication
* Better code readability
* Reusable page interactions
* Separation of responsibilities
* Easier locator maintenance
* Cleaner test classes

---

# 🧱 Base Page

`BasePage` provides common functionality that can be shared across page objects.

```text
                    BasePage
                       │
       ┌───────────────┼────────────────┐
       ▼               ▼                ▼
 BasicFormPage    DropdownPage     DynamicContentPage
       │               │                │
       └───────────────┼────────────────┘
                       ▼
                 Other Page Objects
```

This approach helps keep common page-level functionality centralized and reusable.

---

# 🧪 Test Layer

Test classes are maintained separately from page objects.

The test layer focuses on:

* Test workflow
* Test execution
* Assertions
* Validation
* Scenario-specific logic

`BaseTest` provides common test-level functionality shared across test classes.

---

# 🧰 Reusable Utilities

The framework contains reusable utilities for common automation requirements.

| Utility          | Responsibility                |
| ---------------- | ----------------------------- |
| `DriverManager`  | WebDriver management          |
| `WaitUtil`       | Synchronization and waits     |
| `ScreenshotUtil` | Screenshot capture            |
| `WindowUtil`     | Browser window/tab operations |
| `DownloadUtil`   | File download operations      |
| `DateUtil`       | Date-related operations       |
| `ConfigReader`   | External configuration        |
| `ConfigKeys`     | Configuration key management  |
| `ExtentManager`  | Extent Report management      |
| `LogUtil`        | Logging functionality         |
| `RetryUtil`      | Test retry handling           |
| `DropdownType`   | Dropdown type abstraction     |

---

# ⚙️ Configuration Management

Framework configuration is externalized through:

```text
src/main/resources/config.properties
```

Example:

```properties
browser=chrome
baseUrl=https://example.com
```

External configuration helps avoid hard-coding environment-specific values inside test classes.

### 🔐 Security

**Never commit sensitive information to a public repository**, including:

* Passwords
* API keys
* Access tokens
* Authentication credentials
* Private URLs
* Cloud credentials
* SSH keys

Use environment variables, secure configuration, or CI/CD secret management for sensitive values.

---

# 🧪 TestNG

The framework uses **TestNG** for test execution.

TestNG features demonstrated in the project include:

* Test annotations
* Assertions
* Test lifecycle management
* Suite execution
* Parameters
* Test grouping
* Listeners
* Retry handling
* Data-driven execution
* Parallel execution concepts

---

# 📋 TestNG Suite

Test execution can be controlled through:

```text
testng.xml
```

The suite configuration can be used to manage:

* Test classes
* Test suites
* Groups
* Parameters
* Execution order
* Listeners
* Parallel execution
* Thread configuration

---

# 👂 TestNG Listeners

The framework includes a custom:

```text
TestListener.java
```

The listener can respond to TestNG lifecycle events such as:

* Test started
* Test passed
* Test failed
* Test skipped
* Suite started
* Suite completed

Listeners can be integrated with logging, screenshots, reporting, and other framework-level functionality.

---

# 🔁 Retry Handling

The framework includes:

```text
RetryUtil.java
```

Retry functionality provides controlled re-execution of failed tests when appropriate.

This is particularly useful when working with intentionally unstable or failure-prone browser scenarios.

> Retry logic should be used carefully. It should not be used to hide genuine application or automation defects.

---

# 📸 Screenshot Support

Screenshot functionality is centralized through:

```text
ScreenshotUtil.java
```

Screenshots can be captured during test execution and used for debugging and failure analysis.

---

# 📊 Extent Reports

The framework integrates **Extent Reports** for HTML-based test reporting.

Report management is handled through:

```text
ExtentManager.java
```

After execution, the generated report can be viewed from the configured test output directory.

Example:

```text
test-output/
└── ExtentReport.html
```

The report provides a visual summary of test execution and results.

---

# 📦 Maven

Maven is used for:

* Dependency management
* Build management
* Project configuration
* Test execution

Dependencies and build configuration are maintained in:

```text
pom.xml
```

---

# ▶️ Running the Tests

## Option 1 — IntelliJ IDEA

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the required dependencies.
4. Review `config.properties`.
5. Open `testng.xml`.
6. Right-click the suite.
7. Select **Run**.

---

## Option 2 — Individual Test

Navigate to a test class, for example:

```text
S13_DragAndDropTest.java
```

Run the test class or an individual test method from IntelliJ IDEA.

---

## Option 3 — Maven

From the project root:

```bash
mvn clean test
```

Maven will build the project and execute the configured tests.

---

# 📊 Viewing Test Reports

After execution, locate the generated report:

```text
test-output/
└── ExtentReport.html
```

Open the HTML report in a browser to review the execution results.

---

# 📁 Project Structure

A simplified view of the framework:

```text
AutomationHandsOn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org.automationConcepts/
│   │   │       ├── Pages/
│   │   │       └── Utilities/
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       └── java/
│           ├── Listeners/
│           └── Tests/
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

# 🔄 Framework Execution Flow

```text
TestNG Suite
     │
     ▼
  BaseTest
     │
     ▼
Test Class
     │
     ▼
Page Object
     │
     ▼
Selenium WebDriver
     │
     ▼
  Browser
     │
     ├── Wait Utilities
     ├── Window Utilities
     ├── Download Utilities
     ├── Screenshot Utilities
     └── Configuration
              │
              ▼
        TestNG Listener
              │
              ▼
           Logging
              │
              ▼
        Extent Reports
```

---

# 🌿 Version Control

The project is maintained using **Git and GitHub**.

A feature-branch workflow can be used to isolate development work:

```text
main
 │
 └── feature/*
        │
        ├── Development
        ├── Commit
        ├── Push
        └── Pull Request
               │
               ▼
              main
```

This workflow supports organized development and makes changes easier to review before merging.

---

# ⭐ Key Features

* ✅ Java-based Selenium WebDriver automation
* ✅ Page Object Model architecture
* ✅ Separate page and test layers
* ✅ Reusable framework utilities
* ✅ Explicit wait and synchronization handling
* ✅ Dynamic element handling
* ✅ iFrame handling
* ✅ Shadow DOM handling
* ✅ Multiple window/tab handling
* ✅ File upload/download automation
* ✅ Mouse and keyboard interactions
* ✅ Screenshot support
* ✅ External configuration
* ✅ TestNG listeners
* ✅ Retry handling
* ✅ Logging
* ✅ Extent HTML reporting
* ✅ Maven build and test execution
* ✅ Git/GitHub version control

---

# 🎯 Project Purpose

The goal of this project is to demonstrate practical experience in building a maintainable **Java + Selenium WebDriver automation framework**.

The project brings together individual Selenium concepts into a structured framework using:

```text
Java
  ↓
Selenium WebDriver
  ↓
Page Object Model
  ↓
Reusable Utilities
  ↓
TestNG
  ↓
Maven
  ↓
Configuration
  ↓
Listeners
  ↓
Logging / Screenshots
  ↓
Extent Reports
```

This project represents hands-on practice with both **Selenium WebDriver automation** and **test automation framework design**.

---

# 🔐 Repository & Authorship

This repository is maintained as a personal hands-on automation and portfolio project.

The code demonstrates the author's work and learning in Selenium WebDriver automation and framework development.

Please do not represent this project or its implementation as your own work.

**Security reminder:** No passwords, API keys, tokens, credentials, or other sensitive information should be committed to this public repository.

---

# 👤 Author

**Deeps7-star**

Java | Selenium WebDriver | TestNG | Maven | Test Automation

---

## ⭐ If you find this project useful

Feel free to explore the framework, review the architecture, and learn from the automation concepts demonstrated in the project.
