package main.java.dev.thallesrafael.jdbc.dao.implementations;

import main.java.dev.thallesrafael.jdbc.connection.ConnectionManager;
import main.java.dev.thallesrafael.jdbc.connection.DbException;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IProductDao;
import main.java.dev.thallesrafael.jdbc.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDao implements IProductDao {

    private Connection conn;

    public ProductDao(Connection conn){
        this.conn = conn;
    }
    @Override
    public Integer insert(Product product) {
        PreparedStatement st =null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO tb_product VALUES (nextval('sq_product'),?,?,?)"
            );
            st.setInt(1, product.getCode());
            st.setString(2, product.getName());
            st.setDouble(3, product.getPrice());

            int rowsAffected = st.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            ConnectionManager.closeStatement(st);
        }


    }

    @Override
    public Integer delete(int id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM tb_product WHERE code = ?"
            );
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();

            return rowsAffected;
        }

        catch (SQLException e){
            throw  new DbException(e.getMessage());
        }
        finally {
            ConnectionManager.closeStatement(st);
        }
    }

    @Override
    public Integer update(Product product) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE tb_product SET name = ?, price = ? WHERE code = ?"
            );
            st.setString(1, product.getName());
            st.setDouble(2, product.getPrice());
            st.setInt(3,product.getCode());

            int rowsAffected = st.executeUpdate();
            return rowsAffected;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            ConnectionManager.closeStatement(st);
        }
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
