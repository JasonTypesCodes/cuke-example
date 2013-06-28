cuke-example
============
1. After cloning the repository, cd into the new folder and run './gradlew eclipse' -or- 'gradlew.bat eclipse'.  You do not need to have a Gradle installation on your machine.
1. Depending on your local machine, you may need to change:
  * The URL of the basic-web-app in the "I am on the application home page" step in src/test/java/com/ociweb/cuke/example2/BasicSeleniumTestSteps.java.  Current one assumes that you have a src folder in your home folder that you cloned the repo into '~/src/cuke-example'
  * If you don't have firefox on your path, you will need to change which WebDriver you load in the same step file.


