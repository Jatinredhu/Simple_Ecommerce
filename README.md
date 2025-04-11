Simple Ecommerce is a Java-based GUI application that simulates a basic online shopping experience.(Use IntelliJ)

## ✨ Features

- Product browsing  
- Add to cart functionality  
- Checkout process  
- Order confirmation page (Thank You page)  
- Basic user management 

## 🛠️ Technologies Used

- **Java** (Swing GUI)  
- **MySQL** (Relational Database)  
- **JDBC** (Java Database Connectivity)  
- **Git + GitHub** (Version Control)


MySQL Database Setup
This project includes a MySQL database dump file to help you set up the backend quickly.
File Location:
/database/shoppingcartdb_clean.sql
Steps to Import the Database:
->Start MySQL Server (via XAMPP, WAMP, etc.)
->Open a terminal / command prompt
->Run the following command:
mysql -u root -p
enter your mysql password when prompted.
Create a database.
Now,import the database by executing this command:
->mysql -u root -p yourdatabasename < path/to/shoppingcartdb_clean.sql
Replace path/to with the actual location of the SQL file.


## Dependencies
This project requires the MySQL JDBC driver to connect Java with the MySQL database.
The required `.jar` file is included in the `/lib` folder:

### How to Add JDBC Driver in IntelliJ:
1. Open the project in IntelliJ.
2. Go to `File` → `Project Structure` → `Modules`.
3. Select the `Dependencies` tab.
4. Click `+` → `JARs or directories` → select the `mysql-connector-j-9.0.0.jar` from `/lib`.
5. Click `OK`.
You're good to go!


For cloning the repository:
git clone https://github.com/Jatinredhu/Simple_Ecommerce.git

