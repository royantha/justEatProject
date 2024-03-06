# Just Eat Project

## Overview
This project fetches restaurant data from the Just Eat API based on a given postcode and displays it in a user interface. The interface includes restaurant names, cuisines, ratings, and addresses.

## Build Instructions
1. Have Gradle installed on your system
2. Clone the project repository from GitHub.
3. Open a terminal on your preferred IDE.
4. Run the command `gradle build` to build the project.

## Compilation Instructions
1. If any errors occurs from `gradle build`, due to not having gradle support, run `gradle init`
2. Overall, compilation is done automatically by Gradle during `gradle build`.


## Run Instructions
1. Execute the command `gradle bootRun` to start the application.
2. Once the application is running, open a web browser and type `http://localhost:8080/restaurant/{postcode}` , enter a postcode and click search to the fetch data

## Improvements
- Add unit tests to  ensures that your code functions correctly
- Implement error handling for cases where the API endpoint returns errors.
- Implement sorting and filtering options for the displayed restaurant data.
- Currently have an error of a mismatch between the expected data type and the actual data type, an improvement I would make would be to debug and add logging statements.
