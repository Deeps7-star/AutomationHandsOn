# 🚀 Selenium WebDriver Automation Framework

A comprehensive **Selenium WebDriver automation framework** built with **Java, Selenium WebDriver, Maven, and TestNG**.

The project demonstrates practical implementation of core and advanced Selenium WebDriver concepts using a structured **Page Object Model (POM)** architecture, reusable utilities, external configuration, TestNG listeners, retry handling, screenshots, and **Extent Reports**.

The project is designed as a hands-on implementation of Selenium automation concepts while following maintainable test automation framework practices.

---

## 🛠️ Technology Stack

| Technology                  | Purpose                               |
| --------------------------- | ------------------------------------- |
| **Java**                    | Programming language                  |
| **Selenium WebDriver**      | Browser automation                    |
| **TestNG**                  | Test execution and assertions         |
| **Maven**                   | Dependency and build management       |
| **Page Object Model (POM)** | Framework design pattern              |
| **Extent Reports**          | HTML test reporting                   |
| **IntelliJ IDEA**           | Development environment               |
| **Git & GitHub**            | Version control and source management |

---

# 📚 Selenium WebDriver Concepts Covered

The project contains dedicated page objects and automated test scenarios covering a broad range of Selenium WebDriver concepts.

### 🔹 Basic Web Interactions

* Browser navigation
* WebElement interactions
* Text fields
* Buttons
* Checkboxes
* Radio buttons
* Dropdowns
* Element state verification

### 🔹 Selenium Locators

Different locator strategies are used throughout the framework, including:

* ID
* Name
* Class Name
* CSS Selector
* XPath

### 🔹 Synchronization & Dynamic Elements

* Explicit waits
* Selenium synchronization
* Dynamic content
* Dynamic elements
* Stale elements
* Dynamic lists
* Network delays
* Random/failing elements

### 🔹 Browser & DOM Interactions

* Alerts
* Modal dialogs
* iFrames
* Shadow DOM
* Hidden elements
* Complex DOM structures
* Scrolling
* Multiple browser windows/tabs

### 🔹 Advanced User Interactions

* Mouse hover
* Drag and drop
* Tooltips
* Keyboard actions
* Slider interactions
* Resizable elements
* Date picker interactions

### 🔹 File & Browser Operations

* File upload
* File download
* Authentication
* Screenshots
* Browser/window management

### 🔹 Additional Automation Concepts

* Web table automation
* JavaScript-based interactions
* Wait strategies
* Retry handling
* Test listeners
* External configuration
* HTML reporting

---

# 🏗️ Framework Architecture

The project follows a structured **Page Object Model (POM)** architecture.

Page interactions, test scenarios, reusable utilities, configuration, listeners, and reporting responsibilities are separated into dedicated components.

```text id="6k6bke"
AutomationHandsOn/
│
├── src/
│   │
│   ├── main/
│   │   │
│   │   ├── java/
│   │   │   └── org.automationConcepts/
│   │   │       │
│   │   │       ├── Pages/
│   │   │       │   ├── BasePage.java
│   │   │       │   ├── S1_BasicFormElementsPage.java
│   │   │       │   ├── S2_ButtonInteractionPage.java
│   │   │       │   ├── S3_CheckBoxesRadioButtonsPage.java
│   │   │       │   ├── S4_DropdownPage.java
│   │   │       │   ├── S6_DynamicContentPage.java
│   │   │       │   ├── S7_WaitsSyncPage.java
│   │   │       │   ├── S8_TableAutomationPage.java
│   │   │       │   ├── S9_AlertsPage.java
│   │   │       │   ├── S10_ModalPage.java
│   │   │       │   ├── S11_iFramePage.java
│   │   │       │   ├── S12_ShadowDomPage.java
│   │   │       │   ├── S13_DragAndDropPage.java
│   │   │       │   ├── S14_HoverElementsPage.java
│   │   │       │   ├── S15_ToolTipPage.java
│   │   │       │   ├── S16_FileUploadPage.java
│   │   │       │   ├── S17_DownloadPage.java
│   │   │       │   ├── S18_HiddenElementsPage.java
│   │   │       │   ├── S19_ScrollPage.java
│   │   │       │   ├── S20_MultipleWindowsPage.java
│   │   │       │   ├── S21_AuthenticationPage.java
│   │   │       │   ├── S22_StaleElementPage.java
│   │   │       │   ├── S23_DynamicListPage.java
│   │   │       │   ├── S24_NetworkDelayPage.java
│   │   │       │   ├── S25_RandomFailElementsPage.java
│   │   │       │   ├── S26_KeyboardActionsPage.java
│   │   │       │   ├── S27_SliderElementPage.java
│   │   │       │   ├── S28_DatePickerPage.java
│   │   │       │   ├── S29_ResizableElementPage.java
│   │   │       │   └── S30_ComplexDOMPage.java
│   │   │       │
│   │   │       └── Utilities/
│   │   │           ├── ConfigKeys.java
│   │   │           ├── ConfigReader.java
│   │   │           ├── DateUtil.java
│   │   │           ├── DownloadUtil.java
│   │   │           ├── DriverManager.java
│   │   │           ├── DropdownType.java
│   │   │           ├── ExtentManager.java
│   │   │           ├── LogUtil.java
│   │   │           ├── RetryUtil.java
│   │   │           ├── ScreenshotUtil.java
│   │   │           ├── WaitUtil.java
│   │   │           └── WindowUtil.java
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       └── java/
│           │
│           ├── Listeners/
│           │   └── TestListener.java
│           │
│           └── Tests/
│               ├── BaseTest.java
│               ├── S1_BasicFormElementsTest.java
│               ├── S2_ButtonInteractionTest.java
│               ├── S3_CheckBoxesRadioButtonsTest.java
│               ├── S4_DropdownTest.java
│               ├── S6_DynamicContentTest.java
│               ├── S7_WaitsSyncTest.java
│               ├── S8_TableAutomationTest.java
│               ├── S9_AlertsTest.java
│               ├── S10_ModalTest.java
│               ├── S11_iFrameTest.java
│               ├── S12_ShadowDomTest.java
│               ├── S13_DragAndDropTest.java
│               ├── S14_HoverElementsTest.java
│               ├── S15_ToolTipTest.java
│               ├── S16_FileUploadTest.java
│               ├── S17_DownloadTest.java
│               ├── S18_HiddenElementsTest.java
│               ├── S19_ScrollTest.java
│               ├── S20_MultipleWindowsTest.java
│               ├── S21_AuthenticationTest.java
│               ├── S22_StaleElementTest.java
│               ├── S23_DynamicListTest.java
│               ├── S24_NetworkDelayTest.java
│               ├── S25_RandomFailElementsTest.java
│               ├── S26_KeyboardActionsTest.java
│               ├── S27_SliderElementTest.java
│               ├── S28_DatePickerTest.java
│               ├── S29_ResizableElementTest.java
│               └── S30_ComplexDOMTest.java
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

---

# 📄 Page Object Model (POM)

The framework follows the **Page Object Model** design pattern.

Each Selenium scenario has a corresponding page class responsible for its page-specific elements and browser interactions.

For example:

```text id="3o8mn5"
S13_DragAndDropPage.java
            ↓
S13_DragAndDropTest.java
```

This separation keeps WebDriver interaction logic away from the test scenarios.

### Benefits

* Improved code readability
* Better maintainability
* Reusable page interactions
* Reduced code duplication
* Clear separation of responsibilities
* Easier modification of locators
* Cleaner test classes

---

# 🧱 Base Page

`BasePage` provides a common foundation for page objects.

Shared page-level behaviour can be maintained in the base class instead of being duplicated across individual page objects.

```text id="agcftx"
BasePage
   │
   ├── BasicFormElementsPage
   ├── ButtonInteractionPage
   ├── DropdownPage
   ├── AlertsPage
   ├── DynamicContentPage
   └── ...
```

---

# 🧪 Test Layer

Automated scenarios are maintained separately from page objects under the test layer.

Each test class focuses on:

* Test workflow
* Test execution
* Validation
* Assertions

while page-specific Selenium interactions remain within the corresponding page object.

`BaseTest` provides shared test-level functionality for the test classes.

---

# 🧰 Reusable Utilities

The framework includes dedicated utility classes for commonly required automation functionality.

## DriverManager

Handles WebDriver-related management and provides centralized driver access.

## WaitUtil

Provides reusable synchronization functionality for Selenium operations.

## ScreenshotUtil

Provides screenshot functionality that can be reused during test execution and failure handling.

## WindowUtil

Provides reusable functionality for browser window and tab operations.

## DownloadUtil

Provides reusable functionality related to file download scenarios.

## DateUtil

Provides reusable date-related functionality.

## ConfigReader

Reads framework configuration values from the external properties file.

## ConfigKeys

Centralizes configuration keys used by the framework.

## ExtentManager

Provides centralized management for Extent Report functionality.

## LogUtil

Provides reusable logging functionality.

## RetryUtil

Provides retry-related functionality for test execution.

## DropdownType

Provides a reusable type abstraction for dropdown-related operations.

---

# ⚙️ Configuration Management

Framework configuration is externalized through:

```text id="66n78p"
src/main/resources/config.properties
```

External configuration helps avoid hard-coding environment-specific values directly into test classes.

Configuration can contain values such as:

```properties id="azf15p"
browser=chrome
baseUrl=https://example.com
```

The actual values should be configured according to the environment where the tests are executed.

> **Security:** Credentials, API keys, tokens, passwords, or other secrets should never be committed to a public GitHub repository.

---

# 🧪 TestNG

**TestNG** is used as the test execution framework.

The framework uses TestNG to organize and execute automated Selenium scenarios.

TestNG provides capabilities such as:

* Test annotations
* Assertions
* Test lifecycle management
* Suite execution
* Test grouping
* Parameters
* Data-driven execution
* Parallel execution
* Listeners
* Retry handling

---

# 📋 TestNG Suite

Test suite execution is configured through:

```text id="o00hk3"
testng.xml
```

The suite file provides centralized control over test execution.

It can be used to configure:

* Test classes
* Test suites
* Groups
* Parameters
* Execution order
* Parallel execution
* Thread count
* Listeners

---

# 👂 TestNG Listeners

The framework contains a custom:

```text id="z0n8ej"
TestListener.java
```

TestNG listeners allow the framework to respond to test lifecycle events.

Typical events include:

* Test started
* Test passed
* Test failed
* Test skipped
* Suite started
* Suite completed

Listeners can also integrate test execution with reporting, logging, screenshots, and other framework-level behaviour.

---

# 🔁 Retry Handling

The framework contains:

```text id="6r8br7"
RetryUtil.java
```

Retry functionality can be used to support scenarios where failed test execution needs controlled re-execution.

This is particularly useful when studying unstable or intentionally failing browser scenarios.

---

# 📸 Screenshot Support

Screenshot functionality is centralized through:

```text id="2d3q93"
ScreenshotUtil.java
```

Screenshots can be captured during automation execution and can assist with debugging failed Selenium scenarios.

---

# 📊 Extent Reports

The framework integrates **Extent Reports** for HTML-based test reporting.

Reporting functionality is managed through:

```text id="y0vvd1"
ExtentManager.java
```

After test execution, an HTML report is generated under the test output directory.

Example:

```text id="v47on9"
test-output/
└── ExtentReport.html
```

The report provides a visual representation of automated test execution and results.

---

# 📦 Maven

**Maven** is used for dependency management, build configuration, and test execution.

Project dependencies and Maven configuration are maintained in:

```text id="f9vsnb"
pom.xml
```

Maven allows the project and its dependencies to be managed consistently without manually adding external libraries.

---

# ▶️ Running the Tests

## Option 1 — IntelliJ IDEA

1. Clone the repository.
2. Open the project in **IntelliJ IDEA**.
3. Allow Maven to download and synchronize the required dependencies.
4. Check the required configuration values in `config.properties`.
5. Open `testng.xml`.
6. Right-click inside the file.
7. Select **Run**.

---

## Option 2 — Run an Individual Test

Navigate to a test class, for example:

```text id="l7lfyp"
S13_DragAndDropTest.java
```

Right-click the test class or individual test method and select:

```text id="2gwbju"
Run
```

This is useful when working on or debugging an individual Selenium concept.

---

## Option 3 — Maven

From the project root, run:

```bash id="ts4hvs"
mvn clean test
```

Maven will build the project and execute the configured tests.

---

# 📊 Viewing the Extent Report

After test execution, locate:

```text id="q3u6dc"
test-output/
└── ExtentReport.html
```

Open `ExtentReport.html` in a web browser to view the generated test report.

---

# 🚀 Getting Started

### 1. Clone the Repository

```bash id="4eppc4"
git clone <repository-url>
```

### 2. Navigate to the Project

```bash id="x9yb8l"
cd AutomationHandsOn
```

### 3. Install Dependencies and Run Tests

```bash id="4sksgp"
mvn clean test
```

Alternatively, import the project into IntelliJ IDEA and execute the TestNG suite through `testng.xml`.

---

# 🔄 Framework Flow

At a high level, the framework follows this execution flow:

```text id="m9z3dh"
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

Supporting framework components operate alongside the test execution:

```text id="jbxcp9"
          Configuration
               │
               ▼
          ConfigReader
               │
               ▼
Tests ───► Pages ───► WebDriver
 │                      │
 │                      │
 ├── Wait Utilities ────┤
 ├── Window Utilities ──┤
 ├── Download Utility ──┤
 └── Screenshot Utility─┘
               │
               ▼
        Listener / Logging
               │
               ▼
          Extent Report
```

---

# 🎯 Project Purpose

The purpose of this project is to demonstrate hands-on knowledge of **Selenium WebDriver** and the development of a structured Java-based test automation framework.

Rather than keeping every Selenium example as an isolated test script, the project organizes automation functionality into a maintainable framework using:

```text id="4tbrpf"
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

The project covers Selenium concepts ranging from basic WebElement interaction to synchronization, advanced DOM handling, browser interactions, file operations, dynamic elements, user interactions, and framework-level test automation functionality.

---

# 🌿 Version Control Workflow

The project is maintained using **Git and GitHub**.

Development can follow a feature-branch workflow:

```text id="3g3zqp"
master
   │
   └── feature/*
          │
          ├── Development
          ├── Commit
          ├── Push
          └── Pull Request
                 │
                 ▼
               master
```

This keeps development work isolated from the main branch until changes are ready to be reviewed and merged.

---

# 📌 Key Framework Features

* ✅ Java-based Selenium WebDriver automation
* ✅ Page Object Model architecture
* ✅ Dedicated page and test layers
* ✅ Reusable WebDriver utilities
* ✅ Dynamic element handling
* ✅ Wait and synchronization utilities
* ✅ Multiple window handling
* ✅ File upload and download automation
* ✅ Advanced DOM interactions
* ✅ Shadow DOM handling
* ✅ iFrame handling
* ✅ Mouse and keyboard interactions
* ✅ Screenshot support
* ✅ External configuration management
* ✅ TestNG test execution
* ✅ TestNG listeners
* ✅ Retry functionality
* ✅ Maven dependency management
* ✅ Extent HTML reporting
* ✅ Git/GitHub version control

---

# 👤 Author

Created as a comprehensive hands-on **Selenium WebDriver automation framework project** demonstrating practical browser automation and test framework development using **Java, Selenium WebDriver, Maven, TestNG, Page Object Model, reusable utilities, listeners, and Extent Reports**.
