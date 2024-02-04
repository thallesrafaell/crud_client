package main.java.dev.thallesrafael.jdbc.dao;

import main.java.dev.thallesrafael.jdbc.connection.ConnectionManager;
import main.java.dev.thallesrafael.jdbc.dao.implementations.ClientDao;



public class DaoFactory {
    public static ClientDao createClientDao(){
        return new ClientDao(ConnectionManager.getConnection());
    }

}
