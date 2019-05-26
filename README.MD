# EspressoBlackBoxTesting

This project fuels the automated mobile
testing, it uses Espresso as black box testing tool and the tests are
written in Kotlin.


## How to make it work
 
- Resign APK file that you want to test using your own signature file, then install the resigned APK to Android device
- Modify android:targetPackage in src/main/AndroidManifest.xml to the package that you want to test
- Modify ACTIVITY_TO_BE_TESTED in src/main/java/net/cmoaciopm/androidtest/TestWithoutSourceCode.java to the acitvity you want to test
- Build and install the APK file of this project
- Execute command adb shell am instrument -w -e class com.example.espresso_blackbox_testing.ContactCallTest com.example.espresso_blackbox_testing/androidx.test.runner.AndroidJUnitRunner

## Warning

Espresso as a black box testing tool is fine, but there are several features you are unable to use, such as:

- Idling resources (Consider replacing them for Condition Watcher)
- Activity, Intent and Permissions rules (You will launch activities manually)
- Access widgets by ID (Will require to scan elements and find a different locator strategy)

### Having fun

Automatic tests could take some time to program but never forget to have fun playing with them!
