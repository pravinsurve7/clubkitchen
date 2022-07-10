##Automation task
* Write automated tests for the following:
    * Automate the add to cart functionality for https://clubkitchen.at
    * Add user provided products to cart for Mamacita Brand
    * Use address “Semperstraße 44, 1180 Wien, Austria” 
    * You can choose any one browser for this automation


## To run the automated tests
This automation framework is using *Selenium Webdriver* tool with *TextNG*. To run the tests on your windows machine do the following.

#### STEPS
1. `mvn install`
2. `mvn test`

#### From Eclipse
Install all the dependencies, and once it is done. Run 'testng.xml' as TestNG, tests will start


## Framework architecture and design
Page Object Model(POM) with TestNG. According to the Page Object Model, you should keep the tests and element locators separately. This will keep the code clean and easy to understand and maintain.The Page Object approach makes automation framework in a testing programmer friendly, more durable and comprehensive. Another important advantage is our Page Object Repository is Independent of Automation Tests. If you keep a separate repository for page objects, it helps us to use this repository for different purposes with different frameworks like you will be able to integrate this repository with other tools like JUnit/TestNG/Cucumber/etc.

## Project Structure
### src/main/java/utils
Utility classes that can be used acrossed the project. *BrowserFactory.java* all browser can be configured here. *WebdriverWrapper.java* has common selenium common methods like explicit waits, etc

### src/test/java/pages
Pages represents Application page, UI elements and methods are defined in these classes.

### src/test/java/tests
This includes TestNG test classes

### testng.xml
Run the test as per class or methods or package. Also has parameters that can be used by tests while execution e.g. browser, website url, etc
