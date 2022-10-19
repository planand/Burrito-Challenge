# Background
This exercise is to complete a RESTful API in Spring Boot[1] that provides a custom-burrito ordering service.  This ZIP contains a starter project to build on top of, filling out the service as described below.

Set aside an hour for this exercise.  It's ok if you don't finish to your complete satisfaction - focus on pieces you can complete, and mark what you can't with a `// TODO` comment containing a description of the remaining portion you would implement with more time.

## Requirements
To complete this assignment, on your system you will need:
1. A Java 11 JDK
1. A Java IDE:  IntelliJ, Eclipse, or VS Code

## "Order" Data Model
An order consists of:
* Tortilla (one of):  {corn, flour}
* Protein (one of):  {bean, beef, chicken, pork, shrimp, steak}
* Vegetables  (zero or more of):  {cabbage, corn, jalapenos}
* Salsa  (one of):  {mild, medium, hot}
* Extras  (zero or more of):  {avocado}

# To-Do
1. Accept two requests:
    1. `POST /orders`
    1. `GET /orders/{orderId}`
1. Implement model class(es)
1. Implement controller
1. Implement repository
1. Unit and functional tests
    1. Mock the repository

# Restrictions
* Only spend 1 hour
* All work should be your own - no help other than documentation available on the internet

# Bonus
* Address security, availability, performance
* Postman test collection

# Footnotes
1. Prefer Java over Kotlin