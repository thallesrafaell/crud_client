package test.java.dev.thallesrafael.jdbc;

import main.java.dev.thallesrafael.jdbc.connection.ConnectionManager;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.java.dev.thallesrafael.jdbc.connection.ConnectionManagerTest;
import test.java.dev.thallesrafael.jdbc.dao.ClientDaoTest;
import test.java.dev.thallesrafael.jdbc.dao.ProductDaoTest;
import test.java.dev.thallesrafael.jdbc.model.ClientTest;
import test.java.dev.thallesrafael.jdbc.model.ProductTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClientDaoTest.class, ProductDaoTest.class, ProductTest.class, ClientTest.class,ConnectionManagerTest.class})
public class AllTest {
}
