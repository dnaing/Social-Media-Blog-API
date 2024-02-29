# Project: Social Media Blog API

## Overview
This project is a backend for a hypothetical social media app, where we must manage our users’ accounts as well as any messages that they submit to the application. The application will function as a micro-blogging or messaging app. In our hypothetical application, any user should be able to see all of the messages posted to the site, or they can see the messages posted by a particular user. In either case, we require a backend which is able to deliver the data needed to display this information as well as process actions like logins, registrations, message creations, message updates, and message deletions.

# Features Implemented
1: Registering new users into the database
2: Verifying user logins
3: Process creation of new messages by users
4: Retrieve all messages
5: Retrieve message by its ID
6: Delete message by its ID
7: Update message by its ID
8: Retrieve all messages written by a particular user

# Technologies Used
Java
Javalin
JDBC
SQL

# Set Up

# Project Usage

# Contributors and Licensing

# Further guidance
Some classes are already complete and SHOULD NOT BE CHANGED - Integration tests, Model classes for Account and Message, a ConnectionUtil class. Changing any of these classes will likely result in the test cases being impossible to pass.

The .sql script found in src/main/resources is already complete and SHOULD NOT BE CHANGED. Changing this file will likely result in the test cases being impossible to pass.

You SHOULD be changing the SocialMediaController class to add endpoints to the StartAPI method. A main method in Main.java is also provided to allow you to run the entire application and manually play or test with the app. Changing that class will not affect the test cases at all. You could use it to perform any manual unit testing on your other classes.

You SHOULD be creating and designing DAO and Service class to allow you to complete the project. In theory, you could design the project however you like, so long as the functionality works and you are somehow persisting data to the database - but a 3-layer architecture is a robust design pattern and following help you in the long run. You can refer to prior mini-projects and course material for help on designing your application in this way.
