package test.java.dev.thallesrafael.jdbc.dao;

import main.java.dev.thallesrafael.jdbc.dao.DaoFactory;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IClientDao;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IProductDao;
import main.java.dev.thallesrafael.jdbc.model.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductDaoTest {
    private IProductDao productDao = DaoFactory.createProductDao();

    @Test
    public void testInsertProduct(){
        Product product = new Product(1,"TV",2599.99);
        int clientInsert =productDao.insert(product);
        Assert.assertTrue(clientInsert == 1);

        int clientDelete = productDao.delete(product.getCode());
        Assert.assertTrue(clientDelete == 1);
    }
    @Test
    public void testDeletetProduct(){
        Product product = new Product(1,"TV",2599.99);
        int clientInsert =productDao.insert(product);
        Assert.assertTrue(clientInsert == 1);

        int clientDelete = productDao.delete(product.getCode());
        Assert.assertTrue(clientDelete == 1);
    }



}
