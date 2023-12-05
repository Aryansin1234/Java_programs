import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSumOfDigits {
    public static void main(String[] args) {
        // JDBC database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/Test";
        String user = "root";
        String password = "A13sin2003dec!#@$";

        try {
            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to retrieve all column values
            ResultSet resultSet = statement.executeQuery("SELECT Marks FROM Java");

            // Sum of numeric values
            int sumOfValues = 0;

            // Iterate through the result set
            while (resultSet.next()) {
                // Get the value of the phone_number column
                String Mark = resultSet.getString("Marks");

                // Check if the value is numeric
                if (Mark.matches("\\d+")) {
                    // Sum the entire numeric value
                    sumOfValues += Integer.parseInt(Mark);
                }
            }

            // Print the sum of numeric values
            System.out.println("Sum of numeric values in Marks column: " + sumOfValues);

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

