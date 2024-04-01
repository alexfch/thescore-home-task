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

# Test execution
## JUnit tests
- run all tests by command `./gradlew test`
- to run a particular test specift it's name. Example: `gradle test --tests '*SimpleTest'`
- for more details see [gradle documentation](https://docs.gradle.org/current/userguide/java_testing.html)
## Cucumber tests
- run all tests by command `./gradlew cucumber`