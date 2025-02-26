package JDBC;

import java.sql.*;

//Пример безопасного SELECT-запроса

public class Task3 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/my_database";
        String user = "postgres";
        String password = "Sql";

        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String sql = "SELECT * FROM users1 WHERE name = ?"; //? указывает место для параметра, который мы передаем через pstmt.setString(1, "Alex"). Это гарантирует безопасность и предотвращает SQL-инъекции.
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Alex"); // Подставляем значение в запрос

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
