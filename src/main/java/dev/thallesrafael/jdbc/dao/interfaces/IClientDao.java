package main.java.dev.thallesrafael.jdbc.dao.interfaces;

import main.java.dev.thallesrafael.jdbc.model.Client;

import java.util.List;

public interface IClientDao {

    Integer insert(Client client);

    Integer delete(int id);

    Integer update(Client client);

    Client findById(Client client);

    List<Client> findAll();

}
