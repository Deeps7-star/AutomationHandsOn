# 🚀 Selenium WebDriver Automation Framework

A Java-based **Selenium WebDriver test automation framework** built using **TestNG, Maven, Page Object Model (POM), reusable utilities, TestNG listeners, retry handling, screenshots, logging, and Extent Reports**.

This project demonstrates how individual Selenium automation scenarios can be organized into a maintainable and reusable test automation framework rather than being implemented as isolated scripts.

## 🎯 What I Built

The framework covers practical web automation scenarios including:

* Basic WebElement interactions
* Selenium locator strategies
* Explicit waits and synchronization
* Dynamic elements and stale elements
* Alerts, modals, iFrames, and Shadow DOM
* Multiple browser windows and tabs
* Mouse and keyboard interactions
* Drag and drop, sliders, tooltips, and date pickers
* File upload and download
* Web table automation
* Screenshot capture
* Test retry handling
* TestNG listeners
* External configuration
* Extent HTML reporting

## 🏗️ Framework Architecture

The project follows a layered **Page Object Model (POM)** architecture:

```text
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

        ┌─────────────────────────────────┐
        │       Reusable Utilities        │
        │                                 │
        │ Driver │ Wait │ Screenshot      │
        │ Window │ Download │ Config      │
        │ Logging │ Retry │ Reporting     │
        └─────────────────────────────────┘
```

## 🛠️ Technology Stack

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java               | Programming language            |
| Selenium WebDriver | Browser automation              |
| TestNG             | Test execution and assertions   |
| Maven              | Dependency and build management |
| Page Object Model  | Framework architecture          |
| Extent Reports     | HTML test reporting             |
| Git / GitHub       | Version control                 |
| IntelliJ IDEA      | Development environment         |

## ⭐ Key Framework Features

* ✅ Page Object Model architecture
* ✅ Separate page and test layers
* ✅ Reusable WebDriver utilities
* ✅ Explicit wait and synchronization utilities
* ✅ Dynamic element handling
* ✅ Screenshot capture
* ✅ TestNG listeners
* ✅ Retry handling
* ✅ External configuration
* ✅ Logging
* ✅ Extent HTML reports
* ✅ File upload/download automation
* ✅ iFrame and Shadow DOM handling
* ✅ Multiple window handling
* ✅ Maven-based execution

## 🔐 Project & Security Note

This repository is intended to demonstrate my hands-on experience with Selenium WebDriver and test automation framework development.

The repository must not contain passwords, API keys, access tokens, private credentials, or other sensitive information.

Please do not represent this work as your own.

## 👤 Author

**Deeps7-star**

Hands-on Selenium WebDriver automation framework project demonstrating practical experience with Java, Selenium, TestNG, Maven, Page Object Model, reusable utilities, test listeners, retry handling, screenshots, logging, and HTML reporting.
