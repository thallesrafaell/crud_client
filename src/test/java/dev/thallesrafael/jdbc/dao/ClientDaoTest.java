package test.java.dev.thallesrafael.jdbc.dao;

import main.java.dev.thallesrafael.jdbc.dao.DaoFactory;

import main.java.dev.thallesrafael.jdbc.dao.interfaces.IClientDao;
import main.java.dev.thallesrafael.jdbc.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class ClientDaoTest {
    private IClientDao clientDao = DaoFactory.createClientDao();


    @Test
    public void testInsertClient(){
        Client client = new Client();
        client.setCode(1);
        client.setName("Thalles");

        Integer response = clientDao.insert(client);
        Assert.assertTrue(response == 1);
    }

    @Test
    public void testDeleteClient(){
        Client client = new Client();
        client.setCode(1);
        client.setName("DELETADO");
        int response = clientDao.delete(1);
        Assert.assertTrue(response == 1);
    }

    @Test
    public void testUpdadeCliente(){
        Client client = new Client();
        client.setCode(2);
        client.setName("Laura");
        int clinetInsert = clientDao.insert(client);
        Assert.assertTrue(clinetInsert == 1);

        client.setName("Laura Beatriz");
        int clientUpdate =clientDao.update(client);
        Assert.assertTrue(clientUpdate == 1);
    }


}
