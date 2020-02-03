# Avito-Android-Appium-Automation


## What is Appium?
Appium is an open source test automation framework for use with native, hybrid and mobile web apps. It drives iOS, Android, and Windows apps using the WebDriver protocol. Appium is built on the idea that testing native apps shouldn't require including an SDK or recompiling your app. And that you should be able to use your preferred test practices, frameworks, and tools. Appium also has made design and tool decisions to encourage a vibrant contributing community.


## Why Appium?
As a test developer it is quite hard to create a good automated test suite that works on the iOS and Android platforms. Both Android and iOS have a couple of different test frameworks that work well but have nothing to do with each other. So you then have to create and maintain two separate test suites, one for Android and one for iOS. They are also written in different languages and with different development tools (IDEs) so even if the applications work the same it is hard to share any code between the tests for the different platforms. But this is where Appium comes in.


## How to execute Avito-Android-Appium-Automation tests locally on a real device:
Before executing these tests we need to setup some prerequisite on our system:


### Install Android Studio:
- Download and install [Android studio](https://developer.android.com/studio/)


### Install Xcode command line tools:
- Install Xcode from the Mac Appstore.
- After installation, install the Commandline Tools: ```$ xcode-select --install```


### Install JAVA:
- check java version: ```$ java -version```
    * If the version is less than 1.8 or the command is not recognized you need to install [java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * If the version is 1.8 or greater then no need to install it.


### Install node:
- Run ```$ brew install node```.


### Install Appium:
- Run ```$ npm install appium@1.7.2```


### Install Appium-doctor:
- Run ```$ npm install -g appium-doctor```


### Install Allure Report Framework:
- Run ```$ brew tap qatools/formulas```
- Run ```$ brew install allure-commandline```


### Add Environment Variables:
- go to ~/.bash_profile and add the following variables:
```
export ANDROID_HOME=/Users/~~user~~/Library/Android/sdk
export APPIUM_HOME=/Users/~~user~~/node_modules/appium/build/lib/
export APPIUM_DOCTOR_HOME=/Users/~~user~~/.npm-global/lib/node_modules/appium-doctor/appium-doctor.js

export PATH=${PATH}:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
export PATH=$PATH:$APPIUM_HOME/main.js
export PATH=$PATH:$APPIUM_DOCTOR_HOME

PATH=$PATH:/usr/local/bin/npm
PATH=$PATH:/usr/local/bin/node
```

### Test Environment Variables:
- Run these commands:
```
$ java -version
$ adb devices
$ npm —version
$ node -v
$ appium -v
$ appium-doctor
$ allure
```

### Prepare the device for test:
- connect a real device
- install Avito app manually
- enable device location


### Running the functional tests:
- Go to the project directory and run: ```./gradlew clean testSuite -i```


## Support
If you are having any question, please let me know.
- email : c.saadi81@gmail.com
