package org.example;

//Вставка данных через PreparedStatement

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task4 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/my_database";
        String username = "postgres";
        String password = "Sql";

        try (Connection connection = DriverManager.getConnection(url, username, password)){ //Подключаемся к базе через DriverManager.getConnection(...).
            String sql = "INSERT INTO users1 (name, age, city, salary) VALUES (?, ?, ?, ?)"; // Текст запроса к базе
            PreparedStatement preparedStatement = connection.prepareStatement(sql); //Создаём Statement для выполнения SQL-запроса.

            preparedStatement.setString(1, "David"); // передаем значение через  setString
            preparedStatement.setInt(2, 22);
            preparedStatement.setString(3, "Minsk");
            preparedStatement.setInt(4, 20000);

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Добавление записи:" + rowsInserted);
    } catch (SQLException e) {
        e.printStackTrace();}
    }
}
