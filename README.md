# as2_uiautomator

### Identify the application’s UI components
```
<android-sdk>/tools/uiautomatorviewer
```

### Create the build file
```
<android-sdk>/tools/android create uitest-project -n <name> -t 1 -p <path>
```
The \<name\> is the name of the project that contains your uiautomator test source files, and the \<path\> is the path to the corresponding project directory.

### Building and Deploying Your uiautomator Tests
In the project directory, with android device connected, run command below:
``` zsh
ant build && adb push bin/as2_uia.jar /data/local/tmp/ && adb shell uiautomator runtest as2_uia.jar
```

### Reference
- http://developer.android.com/tools/testing/testing_ui.html
- http://developer.android.com/tools/help/uiautomator/index.html
