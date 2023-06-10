# NYTimes_Articles

simple app to hit the NY Times Most Popular Articles API and show a list of articles, that
shows details when items on the list are tapped .


# Installation

To install and run this project on your local machine, please follow the instructions below:



Clone the Repository

Clone this repository to your local machine using the following command:

```bash

git clone https://github.com/yaseerfarah/NYTimes_Articles.git

```

 # Import the Project in Android Studio
 
1- Open Android Studio.

2- Click on "Open an Existing Project" or select "File" > "Open" from the menu.

3- Navigate to the location where you cloned the repository and select the project's root directory.

4- Click "OK" to import the project.


 # Build and Run the Project
 
Once the project is open in Android Studio,

you need to sign up for an API key at:
https://developer.nytimes.com/get-started, then replace the ‘PUT_API_KEY_HERE’ in gradle.properties  file below with the API key
assigned to your account.


<img src="images/api_key.png" width="700" height="300">


* Then click build and wait for the Gradle sync to finish.
* Connect an Android device to your machine or set up an Android Virtual Device (AVD) using the Android Virtual Device (AVD) Manager.
* Click on the "Run" button in the toolbar or select "Run" > "Run app" from the menu.
* Choose the device you want to run the app on and click "OK".
* Android Studio will build the project, install the app on the selected device, and launch it.

 # Features

 Implemented by:
 * Kotlin
 * Clean Architecture
 * MVVM Architecture Pattern
 * Hilt
 * Coroutine
 * ViewBinding
 * Retrofit
 * Navigation Componenet
 * Unit Test  

 
 
 # Screens:
 
 * Splash Screen

  <img src="images/splash_screen.jpeg" width="250" height="580">
  
   * Home Screen
  
  <img src="images/home_screen.jpeg" width="250" height="580">
  
   * Details Screen
  
  <img src="images/details_screen.jpeg" width="250" height="580">
  
  
  
  
  
