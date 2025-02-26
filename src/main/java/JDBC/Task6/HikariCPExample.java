package JDBC.Task6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HikariCPExample {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConfig.getDataSource().getConnection()) { //Получает соединение с базой данных через пул соединений HikariCP.
            String sql = "SELECT * FROM users1"; //Выполняет SELECT-запрос (SELECT * FROM users) – получает всех пользователей.
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println(rs.getString("name") + " | " + rs.getInt("age")); //Перебирает результаты и выводит имя и возраст каждого пользователя.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
