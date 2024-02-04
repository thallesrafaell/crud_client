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
    public void deleteClient(){
        Client client = new Client();
        client.setCode(1);
        client.setName("DELETADO");
        int response = clientDao.delete(1);
        Assert.assertTrue(response == 1);
    }


}
