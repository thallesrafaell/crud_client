package main.java.dev.thallesrafael.jdbc.dao.interfaces;

import main.java.dev.thallesrafael.jdbc.model.Product;

import java.util.List;

public interface IProductDao {
    Integer insert(Product product);

    Integer delete(int id);

    Integer update(Product product);

    Product findById(Integer id);

    List<Product> findAll();
}
