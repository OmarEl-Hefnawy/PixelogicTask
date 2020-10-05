# PixelogicTask
Pixelogic Task using Java, Maven, TestNG and Allure 

* How It Works?
1- As any form should has Test Cases for "Mandatory, Formating & Controls", so we start out testing by executing "Checking Mandatory Fields" TC
2- After executing "Mandatory Fields", we created a new account in "Sign Up" page with valid data to insure that the process works successfully
3- As we need to verify the "Sign In" process, we verify the "Logout" process and insure that the "Login" process works successfully with the credentials used in "Sign Up" process
4- After that we need to verify that if we entering password different from confirm password, error message will appear & also verify that the email is unique for each user, So we executed Sign Up Negative scenarios
5- Finally, we need to verify that the inputs of the fields have the restrictions showed in the document, so we executed "Sign Up Formating" TC 

* How the report works?
1- We need to download allure-2.9.0 and call the bin folder in allure from cmd "Path of folder\allure-2.9.0\bin"
2- After executing the TCs, an allure-results folder created in the project, we will call it in the cmd after calling the bin folder "Path of folder of allure in the project\allure-results"
3- The report will open in the browser shown the status of the executed TCs

* Components of Task: 1- Java
                    2- Maven
                    3- TestNG
                    4- Allure
                    5- Data-Driven (CSV Files)
                    6- Object Oriented
                    
* Features: 1- Automating Register Process (Positive Scenario)
          2- Automating Register Process (Negative Scenario)
          3- Automating Login Process
          4- Automating Logout Process
          5- Automating Register Process (Checking Mandatory Fields)
          6- Automating Register Process (Checking Formats of the Fields)
          
* All requirements are fulfilled
