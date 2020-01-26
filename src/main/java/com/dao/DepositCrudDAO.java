package com.dao;

import com.domain.Deposit;
import com.jdbc.ConnectorDB;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositCrudDAO extends AbstractCrudDAO<Deposit> {

    private static final String FIND_BY_ID_QUERY = "SELECT * FROM deposits WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM deposits";
    private static final String ADD_DEPOSIT = "INSERT INTO deposits values(?,?,?)";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM deposits WHERE id=?";
    private static final String UPDATE_QUERY = "{call updatedUser(?,?,?,?)}";


    public DepositCrudDAO(ConnectorDB connector, String findById, String addDeposit, String deleteById, String update) {
        super(connector, FIND_BY_ID_QUERY, ADD_DEPOSIT, DELETE_BY_ID_QUERY, UPDATE_QUERY);
    }


    @Override
    protected void setUpdateCS(CallableStatement cs, Deposit deposit) {
        try {
            cs.setInt(1, deposit.getAmount());
            cs.setInt(1, deposit.getTerm());
            cs.setString(2, deposit.getCurrency());
            cs.setInt(5, deposit.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setPS(PreparedStatement ps, Deposit deposit) {
        try {
            ps.setInt(1, deposit.getAmount());
            ps.setInt(2, deposit.getTerm());
            ps.setString(3, deposit.getCurrency());
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }



    protected Deposit mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Deposit.builder()
                .withId(resultSet.getInt("id"))
                .withAmount(resultSet.getInt("amount"))
                .withTerm(resultSet.getInt("term"))
                .withCurrency(resultSet.getString("currency"))
                .build();
    }

}
