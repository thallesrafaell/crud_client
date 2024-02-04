package main.java.dev.thallesrafael.jdbc.dao;

import main.java.dev.thallesrafael.jdbc.connection.ConnectionManager;
import main.java.dev.thallesrafael.jdbc.dao.implementations.ClientDao;
import main.java.dev.thallesrafael.jdbc.dao.implementations.ProductDao;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IClientDao;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IProductDao;


public class DaoFactory {
    public static IClientDao createClientDao(){
        return new ClientDao(ConnectionManager.getConnection());
    }
    public static IProductDao createProductDao(){
        return new ProductDao(ConnectionManager.getConnection());
    }

}
