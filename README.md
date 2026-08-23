# Selenium WebDriver Automation Framework

A comprehensive **Selenium WebDriver automation framework** built with **Java, Maven, and TestNG**.

This project covers core and advanced Selenium WebDriver concepts while demonstrating a structured automation framework using the **Page Object Model (POM)**, reusable utilities, configuration management, TestNG listeners, and Extent Reports.

## 🛠 Technologies & Tools

* **Java**
* **Selenium WebDriver**
* **Maven**
* **TestNG**
* **Page Object Model (POM)**
* **Extent Reports**
* **IntelliJ IDEA**
* **Git & GitHub**

## 📚 Selenium WebDriver Concepts Covered

The project includes practical implementations of Selenium WebDriver concepts such as:

* Browser navigation
* WebElement interactions
* Locators

    * ID
    * Name
    * Class Name
    * CSS Selector
    * XPath
* Handling input fields and buttons
* Checkboxes and radio buttons
* Dropdowns
* Alerts
* Frames and iFrames
* Multiple windows and tabs
* Web tables
* Mouse actions
* Keyboard actions
* Drag and drop
* JavaScript Executor
* Scrolling
* Explicit waits
* Implicit waits
* Synchronization
* Screenshots
* File upload
* Dynamic elements
* Element state verification
* Browser management
* Test assertions
* Data-driven testing
* Cross-browser testing

## 🏗 Framework Architecture

The framework separates test logic, page interactions, configuration, and reusable functionality.

```text
Project
│
├── pages/
│   └── Page Object classes
│
├── tests/
│   └── Test classes and test scenarios
│
├── utilities/
│   └── Reusable helper methods
│
├── listeners/
│   └── TestNG listeners
│
├── config/
│   └── Configuration properties
│
├── reports/
│   └── Extent Report output
│
├── pom.xml
│
└── testng.xml
```

## 📄 Page Object Model

The framework uses the **Page Object Model (POM)** design pattern.

Page-specific elements and interactions are maintained inside page classes rather than directly inside test classes.

This helps provide:

* Better code organization
* Reusable page methods
* Reduced code duplication
* Easier maintenance
* Clear separation between page logic and test logic

## 🧪 Tests

The `tests` package contains automated test scenarios.

Tests use methods provided by the page classes and utilities, keeping test cases focused on the actual test flow and validation.

## 🔧 Utilities

The `utilities` package contains reusable functionality used across the automation framework.

Examples may include:

* WebDriver management
* Wait utilities
* Screenshot utilities
* Configuration readers
* Browser utilities
* Common Selenium helper methods

## ⚙️ Configuration Properties

Framework configuration is maintained through properties files.

Configuration can include values such as:

```properties
browser=chrome
baseUrl=https://example.com
```

This allows environment and browser settings to be changed without modifying the test code.

## 🧪 TestNG

**TestNG** is used as the test framework.

It provides functionality including:

* Test annotations
* Assertions
* Test grouping
* Test prioritization
* Parameterization
* Test suites
* Parallel execution
* Data providers
* Test lifecycle management

## 👂 TestNG Listeners

The framework includes **TestNG listeners** for monitoring test execution.

Listeners can respond to events such as:

* Test started
* Test passed
* Test failed
* Test skipped
* Suite started
* Suite completed

They can also be integrated with reporting and screenshot functionality.

## 📊 Extent Reports

**Extent Reports** is integrated to provide detailed HTML test execution reports.

Reports can contain information such as:

* Test name
* Execution status
* Pass/fail results
* Execution details
* Failure information
* Screenshots

## 📦 Maven

**Maven** is used for project and dependency management.

Dependencies and plugins are configured in:

```text
pom.xml
```

Maven handles the required libraries for Selenium WebDriver, TestNG, Extent Reports, and other framework components.

Tests can also be executed through Maven:

```bash
mvn test
```

## 📋 TestNG Suite

Test execution can be controlled through:

```text
testng.xml
```

The suite file can be used to configure:

* Test classes
* Test groups
* Parameters
* Execution order
* Parallel execution

## ▶️ Running the Project

### IntelliJ IDEA

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the required dependencies.
4. Configure the required values in the configuration properties file.
5. Open `testng.xml`.
6. Right-click inside the file.
7. Select **Run**.

### Maven

From the project directory:

```bash
mvn clean test
```

## 📊 Test Reports

After test execution, the generated Extent Report can be opened in a browser to review the test results.

The report provides a visual summary of the automation execution and individual test results.

## 🎯 Project Purpose

The purpose of this project is to demonstrate practical knowledge of **Selenium WebDriver automation** and the design of a maintainable Java-based test automation framework.

It combines Selenium concepts with commonly used automation framework components, including:

**Java → Selenium WebDriver → Maven → TestNG → Page Object Model → Utilities → Configuration → Listeners → Extent Reports**

## 👤 Author

Created as a comprehensive Selenium WebDriver automation project.
