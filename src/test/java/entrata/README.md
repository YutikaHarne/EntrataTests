Overview:-
This is an automated testing project built using Selenium WebDriver with TestNG as the testing framework. It is designed to test various functionalities of the Entrata website, such as form submissions, navigation between pages, button clicks, and verifying elements. We have run 7 Tests in this project.

Features tested in this project include:
1. Watching a demo.
2. Scheduling a demo and filling out a form.
3. Navigating to different sections of the website.
4. Registering for an event.
5. Checking the "See How It Works" feature.
6. Testing the product functionality.

Prerequisites-
Tools and Libraries:
1. Java (JDK 8 or higher)
2. Maven (Optional, if using a Maven project)
3. Selenium WebDriver (For interacting with the browser)
4. TestNG (For organizing and running the test cases)
5. ChromeDriver (For running tests on Chrome)

Setup:
1. Download and install Java from here.
2. Download and install Maven from here (if you are using Maven for dependency management).
3. Download ChromeDriver that matches your Chrome version from here.
4. Set the path of the ChromeDriver executable in the system environment variable or add it to your project configuration.

Project Structure:-

entrata-testng/
src/ ->
test/ ->
java/ ->
entrata/ ->
EntrataTest.java
-> pom.xml (if using Maven)
-> testng.xml
README.md

Maven Dependencies (pom.xml):-

Add the following dependencies to your pom.xml if using Maven for dependency management:

 <dependencies>
   <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.14.0</version>
        </dependency>

      <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
       <groupId>org.testng</groupId>
       <artifactId>testng</artifactId>
       <version>7.10.2</version>
       <scope>test</scope>
    </dependency>


        <!-- WebDriverManager for managing browser drivers -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.5.1</version>
        </dependency>
    </dependencies>

TestNG XML Configuration:-

Create a testng.xml file to configure and run the tests.

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
  <test thread-count="5" name="Test">
    <classes>
      <class name="entrata.EntrataTest"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

How to Run the Tests:-
Command Line (Maven):
1. Navigate to the project folder.
2. Run the command:
   mvn clean test

From an IDE:-
Import the project into your favorite IDE (Eclipse, IntelliJ IDEA, etc.).
Make sure TestNG is added to your build path (if not using Maven).
Right-click the EntrataTest class or testng.xml file and select Run As > TestNG Test.

Test Cases:-
The following tests are implemented in this project:

1. watchDemo
Checks if the "Watch Demo" button is clickable and navigates to the correct page.
2. scheduleYourDemo
Opens the schedule demo form in a new tab and fills out the form with sample data.
3. registerNow
Navigates to the registration form and enters sample user information, then clicks the cancel button.
4. clickOnLogoToGoOnHomePage
Clicks on "Explore More" and returns to the home page by clicking the Entrata logo.
5. basecampJourney
Navigates through various sections such as "Overview", "Why Attend", "Keynotes", "Agenda", "Pricing", and "FAQ" on the Basecamp page.
6. seeHowItWorks
Verifies navigation and interaction on the "How It Works" page, including the "Watch Now" button.
7. product
Tests the product functionality by navigating to the "Message Center" and scheduling a demo.

Additional Notes:-
1. Implicit Wait is used to wait for elements to load.
2. Assert is used to validating assumptions during code execution.
3. JavascriptExecutor is used to scroll into view and click on elements.
4. Actions are used for simulating hover and navigating through product links.

Browser Support
This test is configured to run on the Chrome browser. Ensure that the appropriate version of ChromeDriver is installed.

After Test Execution
After each test, the browser is closed automatically using the @AfterMethod hook.

Troubleshooting
1. If the browser fails to start, make sure the correct path to ChromeDriver is set.
2. If elements are not found, check the XPaths or other locators, and ensure that dynamic waits are applied appropriately.







