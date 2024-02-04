package test.java.dev.thallesrafael.jdbc.model;

import main.java.dev.thallesrafael.jdbc.model.Client;
import main.java.dev.thallesrafael.jdbc.model.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void testConTructorsAndGetterAndSetter(){
        Product product = new Product();
        product.setCode(1);
        product.setName("TV");
        product.setPrice(2599.99);

        Assert.assertEquals(1, product.getCode());
        Assert.assertEquals("TV", product.getName());
        Assert.assertEquals(2599.99, product.getPrice(),0.001);
    }
}
