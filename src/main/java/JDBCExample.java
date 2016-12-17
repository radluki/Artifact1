//STEP 1. Import required packages
import java.sql.*;
// -cp  /home/lukir/IdeaProjects/FirstProject:/usr/local/mysql-connector-java-5.1.40/mysql-connector-java-5.1.40-bin.jar
public class JDBCExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.140.184/STUDENTS";

    //  Database credentials
    static final String USER = "piotr";
    static final String PASS = "pass";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            // Testing User
            User.statement = stmt;
            User u1 = new User(111, "name", "pass", 7.9, 3);

            System.out.println(u1.convertToString());
            u1.insert();


            // End testing User

            String sql = "INSERT INTO tab VALUES (\"aaa\")";//"CREATE DATABASE STUDENTS";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample