package main.java.dev.thallesrafael.jdbc.dao.implementations;

import main.java.dev.thallesrafael.jdbc.connection.ConnectionManager;
import main.java.dev.thallesrafael.jdbc.connection.DbException;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IClientDao;
import main.java.dev.thallesrafael.jdbc.model.Client;

import java.sql.*;
import java.util.List;

public class ClientDao implements IClientDao {

    private Connection conn;

    public ClientDao(Connection conn){
        this.conn = conn;
    }
    @Override
    public Integer insert(Client client) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement(
                    "INSERT INTO tb_client (id,code,name)"
                        +"VALUES (nextval('sq_client'),?,?)");
            st.setInt(1,client.code);
            st.setString(2,client.name);

            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                return rowsAffected;
            }
            else{
                return 0;
            }
        }catch (SQLException e){
            throw  new DbException(e.getMessage());
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
                    "DELETE FROM tb_client WHERE code = ?"
            );

            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                return rowsAffected;
            } else {
                return null;
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            ConnectionManager.closeStatement(st);
        }

    }

    @Override
    public Integer update(Client client) {
        return null;
    }

    @Override
    public Client findById(Client client) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }
}
