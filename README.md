Computer Shop Web Application

This project is a web application designed for the automatic consultation and sale of computer parts, focusing on simplifying the custom PC building process for users who may not have extensive technical knowledge. The application recommends compatible computer components based on the user’s preferences and budget, using a combination of Spring Framework, Angular, and Oracle Database.

Key Features

Automatic PC Build Recommendations: Users can input their budget and preferences, and the system will automatically suggest a compatible custom PC configuration.

Component Compatibility Algorithm: Ensures that the recommended components are not only within budget but also fully compatible with each other.

User Authentication: Secure login using JWT tokens, allowing users to manage their PC builds and purchase history.

Scalable and Secure Architecture: Built using modern web technologies for robustness and scalability.


Project Overview

The web application was developed to address the challenges faced by users who want to build custom PCs but lack the technical knowledge to select compatible components. The system simplifies the process by allowing users to enter their preferences and budget, and then automatically generates a compatible PC build.

The core of the application is an algorithm that ensures all recommended components work together seamlessly, while staying within the user's budget. This makes the custom PC building process more accessible to a broader audience.

Key technologies and frameworks used in this project include:

Oracle Database: Manages user data, product listings, and purchase histories.

Spring Framework: Handles backend operations, including product recommendations, user authentication, and business logic.

Angular: Provides a responsive and user-friendly interface for seamless interaction.

JWT Authentication: Secures user login and manages session information.


How to Run

1. Configure the Database: If you are using a database other than Oracle, you must change the dataSource configuration in the application.yaml file to reflect your database connection settings.


2. Run the Application:

Execute the main method in the computershop.application class, located in the com.armanaj.computershop package.



3. Populate the Database:

First, run the SaveBaseInfoTest class to populate the base information.

Then, run the SaveProductTest class to add product data to the database.




Technical Components

BuilderService: The core service responsible for generating PC configurations based on user inputs, such as budget and component preferences.

PurchaseService: Manages user purchases, tracks transaction history, and ensures secure order processing.

JWT Authentication: Secures the user accounts and controls access to various parts of the system.


These components work together to provide a smooth, scalable, and secure experience for users looking to build custom PCs.

Project Requirements

All project dependencies and configuration settings are managed in the pom.xml file, which serves as the project's configuration for the package manager (Maven).

Conclusion

This project simplifies the custom PC building process, making it more accessible to a wider audience. By automating the selection of compatible parts and ensuring secure and efficient operations, the application enhances the user experience and offers significant potential for commercial use.

Contact

For any issues or inquiries, please contact the developer:

Arman Aminjavaheri
GitHub: Arman-Aj
Telegram: Rman_Aj