import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class ImageInsertRetrieve {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ImageInsertRetrieve <image_path>");
            return;
        }

        String imagePath = args[0];
        String url = "jdbc:mysql://localhost:3306/sample_db";
        String user = "root";
        String password = "A13sin2003dec!#@$";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Insert image into database
            insertImage(connection, imagePath);

            // Retrieve image from database
            retrieveImage(connection, "/home/aryan/sampe.jpg");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertImage(Connection connection, String imagePath) throws SQLException, IOException {
        String insertQuery = "INSERT INTO images (image_data) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            FileInputStream inputStream = new FileInputStream(imagePath);
            preparedStatement.setBinaryStream(1, inputStream);

            int rowCount = preparedStatement.executeUpdate();
            System.out.println(rowCount + " row(s) affected. Image inserted successfully.");
        }
    }

    private static void retrieveImage(Connection connection, String savePath) throws SQLException, IOException {
        String retrieveQuery = "SELECT image_data FROM images WHERE image_id = 1"; // Assuming image_id = 1

        try (PreparedStatement preparedStatement = connection.prepareStatement(retrieveQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Blob blob = resultSet.getBlob("image_data");
                byte[] bytes = blob.getBytes(1, (int) blob.length());

                try (FileOutputStream outputStream = new FileOutputStream(savePath)) {
                    outputStream.write(bytes);
                    System.out.println("Image retrieved and saved successfully.");
                }
            } else {
                System.out.println("Image not found in the database.");
            }
        }
    }
}
