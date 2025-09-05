# Online Food Application

## Overview
The **Online Food Application** is a web-based platform that allows users to browse, order, and manage food from various restaurants. The application provides an easy-to-use interface for customers to explore menus, place orders, and track deliveries. Admins can manage restaurants, menu items, and orders efficiently.  

This project is built using **Java Spring Boot**, and **MySQL** for the backend, with a responsive front-end interface.  

---

## Features

### User Features:
- User registration and login.
- Browse restaurants and menu items.
- Add items to cart and place orders.
- View order history.
- Search for restaurants based on location and cuisine.

### Admin Features:
- Admin login and authentication.
- Add, update, and delete restaurants.
- Manage menu items for each restaurant.
- View and manage all customer orders.

---

## Technologies Used
- **Backend:** Java, Spring Boot, Spring Data JPA, Spring Security
- **Database:** MySQL
- **Build Tool:** Maven
- **Other Tools:** Postman (for API testing)

-------------------------
2. Configure Database
3. spring.application.name=OnlineFoodOrderingSystem

# ===============================
# = DataSource Configuration
# ===============================
spring.datasource.url=jdbc:mysql://localhost:3306/foodordering
spring.datasource.username=root
spring.datasource.password=Sunny123@

# ===============================
# = JPA / Hibernate Configuration
# ===============================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# ===============================
# = Server Configuration
# ===============================
server.port=8080

## Author

**Aditya Singh**  
- Role: Backend Developer  
- Email: singhaditya5343@gmail.com  
- GitHub: https://github.com/singhadity02394
- LinkedIn: https://www.linkedin.com/in/aditya-singh-b16a05229/


## Project Structure
