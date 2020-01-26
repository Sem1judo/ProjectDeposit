package com.dao;

import com.jdbc.ConnectorDB;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class AbstractCrudDAO<E> implements CrudDAO<E> {

    protected final ConnectorDB connector;

    private final String findById;
    private final String addDeposit;
    private final String deleteById;
    private final String update;


    protected AbstractCrudDAO(ConnectorDB connector, String findById, String addDeposit, String deleteById, String update) {
        this.connector = connector;
        this.findById = findById;
        this.addDeposit = addDeposit;
        this.deleteById = deleteById;
        this.update = update;

    }

    @Override
    public void save(E entity) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(addDeposit)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                setPS(preparedStatement, entity);
            }
        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("", e);
        }
    }

    @Override
    public Optional<E> findById(Integer id) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(findById)) {
            preparedStatement.setInt(1, id);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

            }

        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("", e);
        }

        return Optional.empty();
    }

    @Override
    public void update(E entity) {
        try (final CallableStatement callableStatement =
                     connector.getConnection().prepareCall(update)) {
            try (final ResultSet resultSet = callableStatement.executeQuery()) {
                setUpdateCS(callableStatement, entity);
            }
        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("", e);
        }
    }


    @Override
    public void deleteById(Integer id) {

        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(deleteById)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                preparedStatement.setInt(1, id);
            }

        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("", e);
        }

    }

    protected abstract void setUpdateCS(CallableStatement callableStatement, E entity);

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract void setPS(PreparedStatement ps, E entity);
}
