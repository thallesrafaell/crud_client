package main.java.dev.thallesrafael.jdbc.dao.implementations;

import main.java.dev.thallesrafael.jdbc.connection.ConnectionManager;
import main.java.dev.thallesrafael.jdbc.connection.DbException;
import main.java.dev.thallesrafael.jdbc.dao.interfaces.IClientDao;
import main.java.dev.thallesrafael.jdbc.model.Client;

import java.sql.*;
import java.util.ArrayList;
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
            st.setInt(1,client.getCode());
            st.setString(2,client.getName());

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
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
            "UPDATE tb_client SET name = ? WHERE code = ?"
            );

            st.setString(1, client.getName());
            st.setInt(2, client.getCode());

            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                return rowsAffected;
            }
            else {
                return 0;
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
    public Client findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM tb_client WHERE code = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()) {
                Client client = new Client();
                client.setCode(rs.getInt("code"));
                client.setName(rs.getString("name"));
                return client;
            }
            else {return null;}
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            ConnectionManager.closeStatement(st);
            ConnectionManager.closeResultSet(rs);
        }
    }

    @Override
    public List<Client> findAll() {
            PreparedStatement st = null;
            ResultSet rs = null;
            try {
                st = conn.prepareStatement(
                        "SELECT * FROM tb_client"
                );
                rs = st.executeQuery();

                List<Client> clients = new ArrayList<>();

                while (rs.next()){
                   Client client = new Client();
                   client.setCode(rs.getInt("code"));
                   client.setName(rs.getString("name"));

                   clients.add(client);
                }

                return clients;
            }
            catch (SQLException e ){
                throw new DbException(e.getMessage());
            }
    }
}
