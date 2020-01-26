package com.dao;

import com.domain.Deposit;
import com.jdbc.ConnectorDB;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Connection;

import static org.junit.Assert.*;


public class AbstractCrudDAOTest {

    @Test
    public void create() {
        Deposit deposit = new Deposit();
        deposit.setAmount(10000);
        deposit.setTerm(12);
        deposit.setCurrency("UAH");
        ConnectorDB connectorDB;
//        Connection con = connectorDB.getConnection();
//       AbstractCrudDAO<Deposit> depositAbstractCrudDAO = new DepositCrudDAO();
//        depositAbstractCrudDAO.save(deposit);


    }

    @Test
    public void read() {

        assertNotNull(null);
    }

    @Test
    public void delete() {

        assertNotNull(null);

    }

    @Test
    public void update() {

    }
}
