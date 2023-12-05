import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateSalaryUsingStoredProcedure {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Test";
        String user = "root";
        String password = "A13sin2003dec!#@$";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            int employeeIdToUpdate = 1; // Replace with the actual employee ID
            double newSalary = 75000.00; // Replace with the new salary

            // Call the stored procedure to update the salary
            callUpdateSalaryStoredProcedure(connection, employeeIdToUpdate, newSalary);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void callUpdateSalaryStoredProcedure(Connection connection, int employeeId, double newSalary)
            throws SQLException {
        String storedProcedureCall = "{call update_salary(?, ?)}";

        try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
            callableStatement.setInt(1, employeeId);
            callableStatement.setDouble(2, newSalary);

            // Execute the stored procedure
            callableStatement.executeUpdate();

            System.out.println("Salary updated successfully for employee ID: " + employeeId);
        }
    }
}

