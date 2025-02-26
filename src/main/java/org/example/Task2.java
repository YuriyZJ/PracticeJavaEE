package org.example;

import java.sql.*;

public class Task2 {
    private static final String URL = "jdbc:postgresql://localhost:5432/my_database"; // тут указать базу данных, которая есть в postgresql
    private static final String USER = "postgres";
    private static final String PASSWORD = "Sql";

    public static void main(String[] args) {
        String query = "SELECT * FROM users1";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); //Подключаемся к базе через DriverManager.getConnection(...).
             Statement statement = connection.createStatement(); //Создаём Statement для выполнения SQL-запроса.
             ResultSet resultSet = statement.executeQuery(query)){ //Читаем строки ResultSet и выводим в консоль.

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String city = resultSet.getString("city");
                int salary = resultSet.getInt("salary");
                System.out.println(id + " " + name + " " + age + " " + city + " " + salary);
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
