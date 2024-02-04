package test.java.dev.thallesrafael.jdbc.dao;

import main.java.dev.thallesrafael.jdbc.dao.DaoFactory;

import main.java.dev.thallesrafael.jdbc.dao.interfaces.IClientDao;
import main.java.dev.thallesrafael.jdbc.model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ClientDaoTest {
    private IClientDao clientDao = DaoFactory.createClientDao();


    @Test
    public void testInsertClient(){
        Client client = new Client();
        client.setCode(1);
        client.setName("Thalles");

        Integer response = clientDao.insert(client);
        Assert.assertTrue(response == 1);

        int clientDelete =clientDao.delete(1);
        Assert.assertTrue(clientDelete == 1);


    }

    @Test
    public void testDeleteClient(){
        Client client = new Client();
        client.setCode(3);
        client.setName("DELETADO");
        int clientInsert = clientDao.insert(client);
        Assert.assertTrue(clientInsert == 1);

        int response = clientDao.delete(3);
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
        int clientDelete = clientDao.delete(2);
        Assert.assertTrue(clientDelete == 1);
    }

    @Test
    public void testFindByID(){
    Client client = new Client(1, "Gabriel");
    int clientInsert = clientDao.insert(client);
    Assert.assertTrue(clientInsert == 1);

    Client foundClient = clientDao.findById(client.getCode());
    Assert.assertNotNull(foundClient);

    int cliendtDelete = clientDao.delete(1);
    Assert.assertTrue(cliendtDelete == 1);
    }

    @Test
    public void findAll(){
        Client client = new Client(1, "Gabriel");
        Client client2 = new Client(2, "Thalles");
        Client client3 = new Client(3, "Laura");


        int clientInsert = clientDao.insert(client);
        Assert.assertTrue(clientInsert == 1);
        clientInsert = clientDao.insert(client2);
        Assert.assertTrue(clientInsert == 1);
        clientInsert = clientDao.insert(client3);
        Assert.assertTrue(clientInsert == 1);

        List<Client> list = clientDao.findAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() == 3);

        list.stream().forEach(clientDelete -> clientDao.delete(clientDelete.getCode()));

        list = clientDao.findAll();
        Assert.assertTrue(list.size() == 0);

    }


}
