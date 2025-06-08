#  Automated UI Testing – SauceDemo

This project is a Selenium-based automated test framework for testing the [SauceDemo](https://www.saucedemo.com) login and product functionalities using Java, Cucumber, and Maven.

---


###  Prerequisites

- Java JDK 21 installed
- Maven 3.9.10
- Internet connection (for downloading drivers with WebDriverManager)

#### How to Run the Tests########################

#Run All Tests

Download/copy the folder TestAssignment and execute below command in the command prompt
mvn test
example : C:\Users\josec\IdeaProjects\TestAssignment> mnv test

#Run by tagname
mvn test -Dcucumber.filter.tags="<@tagName>"
example : mvn test -Dcucumber.filter.tags="@Test_001"

Report will be published in target folder in TestAssignment
###############################################################################
Tools Used

| Tool / Library     | Version                           |
| ------------------ | --------------------------------- |
| Java               | 21                                |
| Maven              | 3.9.10                            |
| Selenium WebDriver | 4.18.1                            |
| Cucumber-Java      | 7.14.0                            |
| WebDriverManager   | 5.7.0                             |
| JUnit              | 5.10.0                            |
| ChromeDriver       | Auto-managed via WebDriverManager |

##################################################################################

#############Folder Structure ######################

src
├── test
│   ├── java
│   │   ├── stepdefinitions/LoginSteps.java
│   │   ├── runners/TestRunner.java
│   │   ├── pages/LoginPage.java
│   │   └── Utilites/BaseTest.java
│   └── resources
│       └── features/
│           └── Login.feature
|	    └── ProductCheckout.feature

