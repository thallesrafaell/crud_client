package test.java.dev.thallesrafael.jdbc.model;

import main.java.dev.thallesrafael.jdbc.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    @Test
    public void testConTructorsAndGetter(){
        Client client = new Client(1,"Thalles");

        Assert.assertEquals(1l, client.getCode());
        Assert.assertEquals("Thalles", client.getName());
    }
    @Test
    public void testSetter(){
        Client client = new Client();
        client.setCode(1);
        Assert.assertEquals(1, client.getCode());
        client.setName("Thalles");
        Assert.assertEquals("Thalles", client.getName());

    }
}
