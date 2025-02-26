package org.example.Task6;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseConfig {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/my_database");
        config.setUsername("postgres");
        config.setPassword("Sql");
        config.setMaximumPoolSize(10); // Максимум 10 соединений
        config.setMinimumIdle(2); // Минимум 2 свободных соединения
        config.setIdleTimeout(30000); // Закрытие неиспользуемого соединения через 30 сек
        config.setMaxLifetime(600000); // Максимальное время жизни соединения - 10 минут
        config.setConnectionTimeout(3000); // Таймаут получения соединения - 3 сек

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
