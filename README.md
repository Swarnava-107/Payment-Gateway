# 💳 Payment Gateway System and Email Notification

A full-stack course payment application built using **Java and Spring Boot**, integrated with a **Razorpay payment gateway** for handling dummy/test payments.

The application allows users to browse courses, initiate payments, process successful or failed transactions, store payment and course-purchase information in a database, and receive an email confirmation after a successful purchase.

## 🚀 Features

* 📚 Course management
* 💳 Razorpay payment gateway integration
* ✅ Successful payment handling
* ❌ Failed payment handling
* 📧 Email confirmation after successful purchase
* 🗄️ Database integration
* 🔄 CRUD REST APIs
* 🌐 HTML, CSS and JavaScript frontend
* 🔐 Backend API integration
* 🧩 Layered Spring Boot architecture
* 💾 Persistent storage of payment/order information

## 🛠️ Technologies Used

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* REST APIs
* Maven

### Database

* MySQL

### Payment

* Razorpay Payment Gateway

### Frontend

* HTML5
* CSS3
* JavaScript

### Email

* Java/Spring email service
* SMTP

## 🏗️ Project Architecture

The project follows a layered backend architecture:

```text
Frontend
   │
   ▼
REST Controller
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
MySQL Database
```

Payment processing works through the following flow:

```text
User
  │
  ▼
Select Course
  │
  ▼
Create Payment/Order
  │
  ▼
Razorpay Test Payment
  │
  ├───────────────┐
  ▼               ▼
Success          Failure
  │               │
  ▼               ▼
Save Details     Payment Failed
  │
  ▼
Send Confirmation Email
```

## 🔄 Application Flow

1. User opens the course application.
2. Available course information is displayed.
3. User selects a course and proceeds to payment.
4. The backend creates the required payment/order information.
5. Razorpay test payment interface is opened.
6. User completes the dummy/test transaction.
7. The application handles the payment response.
8. For a successful transaction:

   * Payment information is stored in the database.
   * Course purchase information is stored.
   * Confirmation email is sent to the user.
9. For a failed transaction:

   * The application displays the appropriate failure response.

## 📌 REST API Operations

The backend provides REST APIs for managing application data.

Typical operations include:

| Method      | Purpose                             |
| ----------- | ----------------------------------- |
| `GET`       | Retrieve course/payment information |
| `GET /{id}` | Retrieve a specific record          |
| `POST`      | Create a new record                 |
| `PUT`       | Update an existing record           |
| `DELETE`    | Delete a record                     |

> API endpoints may vary depending on the controller implementation in the project.

## 💳 Razorpay Integration

The project uses the **Razorpay test environment** to demonstrate payment processing without performing real monetary transactions.

The payment workflow includes:

```text
Create Order
     ↓
Open Razorpay Checkout
     ↓
Complete Test Payment
     ↓
Receive Payment Response
     ↓
Verify/Process Payment
     ↓
Store Payment Details
```

The integration is intended for **development and learning purposes**.

## 📧 Email Confirmation

After a successful course purchase, the application sends a confirmation email containing relevant transaction/purchase details.

Example flow:

```text
Successful Payment
        ↓
Save Purchase Details
        ↓
Generate Email Details
        ↓
Send Confirmation Email
```

## 🗄️ Database

The application uses **MySQL** for persistent data storage.

Database information can include:

* Course details
* Customer/user information
* Payment/order information
* Purchase/transaction details

Spring Data JPA and Hibernate are used to communicate with the database.

## ⚙️ How to Run the Project

### 1. Clone the Repository

```bash
git clone <your-github-repository-url>
```

### 2. Open the Project

Open the project in:

* IntelliJ IDEA
* Eclipse
* VS Code

### 3. Configure Database

Create a MySQL database and update the database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Configure Razorpay

Add your Razorpay test credentials to the application configuration.

```properties
razorpay.key.id=YOUR_TEST_KEY
razorpay.key.secret=YOUR_TEST_SECRET
```

**Never commit real API keys or secrets to GitHub.**

### 5. Configure Email

Configure the SMTP/email credentials required by the application.

For example:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email
spring.mail.password=your-app-password
```

Use environment variables or another secure configuration method for real credentials.

### 6. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from your IDE.

## 🔒 Security Note

This project is intended for learning and demonstration purposes.

Do not upload:

* Razorpay secret keys
* Email passwords
* Database passwords
* API keys
* Other sensitive credentials

Use environment variables or a secure configuration mechanism instead.

## 🎯 Learning Outcomes

Through this project, the following concepts were practiced:

* Spring Boot application development
* REST API development
* CRUD operations
* Spring Data JPA
* Hibernate
* MySQL database integration
* Payment gateway integration
* Payment success/failure handling
* Email notification
* Frontend-backend communication
* API integration
* Layered architecture
* Maven project management

## 🔮 Future Improvements

Possible improvements include:

* User authentication and authorization
* JWT-based security
* Course search and filtering
* Payment history
* Admin dashboard
* User dashboard
* Course enrollment management
* Docker deployment
* Cloud deployment
* Payment webhook handling
* Improved validation and exception handling

## 👨‍💻 Author

**Swarnava Samanta**

B.Tech — Computer Science Engineering

GitHub: `Swarnava-107`

---

⭐ If you find this project useful, feel free to explore the repository and provide feedback.
