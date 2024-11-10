package org.example.listexpendeces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBclass {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/wallet"; //это пример

        public boolean connect() {
            try {
                Connection connection = DriverManager.getConnection(
                        jdbcUrl, "user_wallet","12345");
                return true;
            } catch (SQLException sqle) {
                // не удалось подключиться
                sqle.printStackTrace();
                return false;
            }

        }
}

