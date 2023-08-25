# Appium_BDD
# Serenity Cucumber Appium Test Project with Java

This project shows Appium and Serenity Cucumber framework integration to run sample test case on native Android app.

## Dependencies

#### Install the items

* Android Studio (last version).
* Java Development Kit 17 + (This project used JDK 16).
* Appium 2.1.0 (latest).
* Configure the environments variable JAVA_HOME, ANDROID_HOME and PATH
* Create Android and iOS simulators or devices
---
#### Install SDK (software development kit)

1. Open Android Studio.
2. Click in 'More Actions -> SDK Manager'.
3. On tab 'SDK Platforms' choose the latest "OS Android" and click in "Apply".
4. On tab 'SDK Tools' choose the "Android SDK Build-Tools", "Android Emulator", "Android SDK Platform-Tools","Android SDK Tools", "Intel x86 Emulator Accelerator (HAXM installer)" and click in "Apply".

---
#### Create Emulator (Android) on Android Studio

1. Open Android Studio.
2. Click in 'More Actions -> Virtual Device Manager'.
3. Click in 'Create Virtual Device'.
4. Choose the "Phone" and click in "Next".
5. Choose the "AVD Name" and click in "Finish" -> Run emulator
6. Or open terminal.
7. Go to Android sdk location and execute command(example: ~/AppData/Local/Android/Sdk/emulator)
8. The device name is returned (example: Pixel_7).
```bash
./emulator -list-avds
```

---
## Run Tests:

#### To download, clone this project to your computer and execute the commands bellow:

```bash
./gradlew clean test
```
3. Access on project '/target/site/serenity/index.html' and open Chrome browser to see results dashboards.


---

## IMPORTANT

* Before run the tests you need to start devices android/iOS and start appium server.

