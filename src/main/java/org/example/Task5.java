package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task5 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/my_database"; // тут указать базу данных, которая есть в postgresql
        String username = "postgres";
        String password = "Sql";

        try (Connection connection = DriverManager.getConnection(url, username, password)){ //Подключаемся к базе через DriverManager.getConnection(...).
            insertUser(connection, "Ford", 88, "Piter", 150000);
            updateUser(connection, "Maria", 8000);
            //deleteUser(connection, "Ford");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Метод вставки пользователя
    public static void insertUser(Connection connection, String name, int age, String city, double salary) throws SQLException {
        String sql = "INSERT INTO users1 (name, age, city, salary) VALUES (?, ?, ?, ?)"; // Текст запроса к базе
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) { //Создаём Statement для выполнения SQL-запроса.
            preparedStatement.setString(1, name); // передаем значение через  setString
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, city);
            preparedStatement.setDouble(4, salary);

            int inserted = preparedStatement.executeUpdate(); //Метод executeUpdate() выполняет SQL-запросы, которые изменяют данные в базе данных. Он используется для команд:
            System.out.println("Inserted " + inserted + " rows");
        }
    }

    public static void updateUser(Connection connection, String name, double salary) throws SQLException {
        String sql = "UPDATE users1 SET salary = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, salary);
            preparedStatement.setString(2, name);

            int updated = preparedStatement.executeUpdate();
            System.out.println("Updated " + updated + " rows");
        }
    }

    public static void deleteUser(Connection connection, String name) throws SQLException{
        String sql = "DELETE FROM users1 WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);

            int inserted = preparedStatement.executeUpdate();
            System.out.println("Deleted " + inserted + " rows");
        }
    }
}
