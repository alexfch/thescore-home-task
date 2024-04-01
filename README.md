//Bonus: Write a short description of the rationale you used to decide your test approach and provide a coverage assessment of the feature your tests targeted.

# Task comments
## About tech Stack
- **Java**. The task says 'You can choose the programming language of your choice'. But job description mentions Java, Kotlin, Cucumber, and the task mentiones 'The test host will have Java 11'. Kotlin is recommended, but I don't know it. Even though I'd be happy to learn it during the task, it would incerease risks of not completing the task in time. So I chose Java.
- **Appium 2**. It seemed to be obvious choice.
- **JUnit5**. One of the basid test frameworks for Java. I mostly worked with Spock (which is also quite popular), but Spock is already kind of a wrapper above JUnit. So I chose the base test framework.
- **Cucumber**. It is mentioned in the job description. So I understand you use it and decided to use it in the task as well.
- **Gradle**. Gradle works better with parallel execution than Maven. Plus it gives more flexibility in project setup than Maven. It brings some challenges (like there is a need for additional setup to run tests from command line and from IDE, but once it's done - it's not an issue anymore).

## About Design patterns
- **Page Object Model**. The application has a lot of functionality and may elements on the screen. Page Object Model helps to structurize the elements and increase code reuse.
- **Page Factory**. Even though the task is to test Android version of the application, there is an iOS one too. Page Factory allows convenient calling the same element on different versions of the application.
- **Public WebElements**. I make elements, declared in PageFactory classes, public. So they can be accessed from tests and step definitions directly. A more traditional approach for PageFactory is to make the elements private and provide access to them only through Page Object methods. I find it more flexible to access elements directly. Any typical action of state verification can be done directly. If an application action requires multi-line implementation, this can be covered by a Page Object method.
- **page.element.click() OR page.getElement('byName').click()**. In fact my submission mixes 2 approaches that are better to be separated. The choise depends on test appoach. If we use data-driven approach (not only for verifications, but for actions as well), our framework should have a high level of parmetrization and flexibility. In this case `page.getElement('byName')` should be used. If we use data-driven approach only to check the end result (or do not use it at all), and the scenario steps remain exactly the same, we should use `page.element` approach. I used both, because with one approach Page Object Model can be demonstrated better, and the other one is needed for parametrized tests (which was recommended by the task).
- **About data-driven tests**. For JUnit parameterized test I left the parameters in the test class. But it data-driven approach is chosen as a main one in the project, it will make sense to move it to a file of to a database. For Cucumber test the parameters are kept inside the feature and they should stay there as per Cucumber philosophy.

## About test stability
- **Device**. I used *nightwatch-android-11* device (a default one I saw in Android Studio) when debugging the tests. I did not do compatibility testing. Other devices/OS versions may bring some differences that may fail the tests.

# Environment setup
## System requirements
- Java 11
- Node.js, version >=18.0.0
- Gradle 5

## Appium setup
- install Appium Installer by command `npm install appium-installer -g`
- run appium-installer by command `appium installer`
- choose option `Need help setting up Android Environment to run your Appium test?` and wait for environment setup to be completed.
- chose option `Install Appium Server` and wait for installation to be completed.
- chose option `Install Appium Drivers` and then `UiAutomator2` and wait for installation to be completed.

### Programmatic run of Appium server
- update values for `NODE_PATH` and `APPIUM_PATH` environment variables in `gradle.properties` file.
- aternatively you can pass the parameters directly from the command line by using `-P` parameter.

# Test execution
## JUnit tests
- run all tests by command `./gradlew test`
- to run a particular test specift it's name. Example: `gradle test --tests '*SimpleTest'`
- for more details see [gradle documentation](https://docs.gradle.org/current/userguide/java_testing.html)
## Cucumber tests
- run all tests by command `./gradlew cucumber`