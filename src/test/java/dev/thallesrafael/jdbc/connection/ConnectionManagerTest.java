package test.java.dev.thallesrafael.jdbc.connection;

import main.java.dev.thallesrafael.jdbc.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

import main.java.dev.thallesrafael.jdbc.connection.DbException;
import org.junit.*;

public class ConnectionManagerTest {
    @Test
    public void testGetConnection(){
        Connection connection= ConnectionManager.getConnection();
        Assert.assertNotNull("A conexão nao deve ser nula.", connection);
    }

    @Test
    public void testCloseConnection(){
        Connection connectionBefore = ConnectionManager.getConnection();
        ConnectionManager.closeConnection();

        try {
            Assert.assertTrue("A conexão deve estar fechada.", connectionBefore.isClosed());
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    }



