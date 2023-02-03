
Project Title: EBay Automation with Selenium & Cucumber
Introduction:
This project is aimed at automating the 2 scenarios of a sample e-commerce website, EBay, using Selenium and Cucumber.

Prerequisites:
Java Development Kit (JDK)
Maven
Eclipse
Cucumber plugin for Eclipse
selenium jars 
Chrome or Firefox driver for Selenium


Project Setup:
* Create a proejct in Eclipse as a Maven project.
* Install the required plugins and dependencies if  not installed.
Maven Dependencies are :
1)Cucumber-core
2)Cucumber-HTML
3)cobertura
4)Cucumber-java
5)cucumber-jvm-deps
6)Cucumber-JUnit
7)Cucumber-reporting
8)hamcrest-core
9)Selenium-java
10)Gherkin
11)com.sun for tools.jar


Project Structure:

The project is structured in the following way:

* src/test/java
This directory contains all the Java classes and files.
1)The StepDefinitions package contains the implementation of the step definitions for the scenarios mentioned in the feature file.
2)The TestRunner package contains the JUnit test runner class to execute the test cases.
3)PageObjects package fro holding mutiple page objects that is being used
* Features
This directory contains the Cucumber feature files, which consist of the scenarios to be tested.
* pom.xml
This file contains the Maven dependencies for the project.
* Reporting:
The project uses Cucumber's built-in reporting mechanism to generate HTML reports after each test run. The report can be found in the target directory.
* Drivers
Hold the Web driver used for automation

How to run the project:

* Update the TestRunner class with by providing the  path of feature file in Feature options and stepdefinitions in glue option .
* Run the TestRunner class as a JUnit test.


Reporting:
The project uses Cucumber's built-in reporting mechanism to generate HTML reports after each test run. The report can be found in the target directory.



Conclusion:
This Ebay Automation project is a solution for automating the web application testing. With the use of Cucumber, it becomes easier to understand and maintain the automated test cases, even for non-technical stakeholders.




