import java.util.*;
import java.sql.*;
class Test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
       
        // Getting user input
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        System.out.println("Enter name: ");
        String name = sc.next();
        try {
            // Registering the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            // Creating a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pranay", "root", "root");

            // Preparing the SQL query
            String query = "INSERT INTO users(user_id, name) VALUES(?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Setting the query parameters
            pstmt.setInt(1, id);
            pstmt.setString(2, name);

            // Executing the update
            int status = pstmt.executeUpdate();
            if (status > 0) {
                System.out.println("Record inserted successfully");
            }

            // Closing the connection
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
       
        sc.close();
    }
}
