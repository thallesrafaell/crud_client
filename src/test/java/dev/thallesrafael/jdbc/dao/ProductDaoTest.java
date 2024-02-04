package test.java.dev.thallesrafael.jdbc.dao;

import main.java.dev.thallesrafael.jdbc.dao.DaoFactory;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IClientDao;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IProductDao;
import main.java.dev.thallesrafael.jdbc.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void testUpdateProduct(){
        Product product = new Product();
        product.setCode(1);
        product.setName("Tv");
        product.setPrice(1000);
        int productInsert = productDao.insert(product);
        Assert.assertTrue(productInsert ==1);

        product.setPrice(2599.99);
        int productUpdate = productDao.update(product);
        Assert.assertTrue(productInsert == 1);

        int productDelete = productDao.delete(1);
        Assert.assertTrue(productDelete == 1);
    }


    @Test
    public void testFindById(){
        Product product = new Product(1,"Smart Phone",2599.99);
        int clientInsert = productDao.insert(product);
        Assert.assertTrue(clientInsert == 1);


        Product findProduct = productDao.findById(1);
        Assert.assertNotNull(findProduct);

        int deleteProduct = productDao.delete(1);
        Assert.assertTrue(deleteProduct == 1);
    }

    @Test
    public void testFindAll(){
        Product product = new Product(1,"TV",999.99);
        Product product2 = new Product(2,"Tablet",1999.99);
        Product product3 = new Product(3,"Smart Phone",2999.99);

        int productInsert = productDao.insert(product);
        Assert.assertTrue(productInsert == 1);
        int productInsert2 = productDao.insert(product2);
        Assert.assertTrue(productInsert2 == 1);
        int productInsert3 = productDao.insert(product3);
        Assert.assertTrue(productInsert3 == 1);

        List<Product> products = productDao.findAll();
        Assert.assertNotNull(products);
        Assert.assertTrue(products.size() == 3);

        products.stream().forEach(productDelete -> productDao.delete(productDelete.getCode()));

        products = productDao.findAll();
        Assert.assertTrue(products.size() == 0);


    }



}
