# BingTestTask
BingTestTask

#### Technology Stack ####

* Java 8
* JUnit 5
* Maven
* Selenide
* WebDriver manager
* Hamcrest
* Java Owner

#### Setup ####

For running tests on local machine execute following steps:

```

$ git clone https://github.com/yuriidyahiliev/BingTestTask.git

$ mvn clean test surefire:report
```
* clean - command that cleans the old compiled code and artifacts
* test - command that compiles and runs the tests
* site - generates HTML reports from Maven Surefire Report plugin

#### Browser ####

By default, the latest version of chrome brower is used when running tests.
