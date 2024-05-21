package com.gps.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            if (!isTableExist("car_dealership") || isTableEmpty("car_dealership")) {
                try (Connection connection = dataSource.getConnection()) {
                    ScriptUtils.executeSqlScript(connection, new ClassPathResource("schema.sql"));
                    ScriptUtils.executeSqlScript(connection, new ClassPathResource("data.sql"));
                }
            }
        };
    }

    private boolean isTableExist(String tableName) {
        String query = "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = ?)";
        return jdbcTemplate.queryForObject(query, new Object[]{tableName}, Boolean.class);
    }

    private boolean isTableEmpty(String tableName) {
        String query = "SELECT COUNT(*) = 0 FROM " + tableName;
        return jdbcTemplate.queryForObject(query, Boolean.class);
    }
}
