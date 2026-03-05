import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserLogin {

    public static void login(String username, String password) throws Exception {

        // ❌ Hardcoded secret
        String dbPassword = "admin123";

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                dbPassword);

        Statement stmt = conn.createStatement();

        // ❌ SQL Injection vulnerability
        String query = "SELECT * FROM users WHERE username = '" 
                        + username + "' AND password = '" 
                        + password + "'";

        stmt.executeQuery(query);

        // ❌ Bug
        int x = 10 / 0;

        // ❌ Code smell
        if(true == true){
            System.out.println("Logged in");
        }
    }
}
