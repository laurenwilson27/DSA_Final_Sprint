# DSA Final Sprint
Lauren Wilson - Summer 2024

A simple web app which allows the user to create binary trees and view previously created ones.
The trees are not self-balancing, however, the service which creates them sorts the inputs and then recursively adds each value, resulting in a more balanced tree than if they were inserted sequentially.

The trees are stored in a MySQL database (see the application.properties file), and Thymeleaf is used as the template engine to display views.
This project makes use of the [Bahunya](https://hakanalpay.com/bahunya/) classless style sheet.
