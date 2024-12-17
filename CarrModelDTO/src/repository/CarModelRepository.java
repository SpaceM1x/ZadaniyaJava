package repository;

import Entity.CarModelEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarModelRepository {
    private Connection connection;

    public CarModelRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(CarModelEntity model) throws SQLException {
        String sql = "INSERT INTO CarModel (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, model.getName());
            stmt.executeUpdate();
        }
    }

    public CarModelEntity getById(int id) throws SQLException {
        String sql = "SELECT * FROM CarModel WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CarModelEntity(rs.getInt("id"), rs.getString("name"));
            }
        }
        return null;
    }

    public void update(CarModelEntity model) throws SQLException {
        String sql = "UPDATE CarModel SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, model.getName());
            stmt.setInt(2, model.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM CarModel WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<CarModelEntity> getAll() throws SQLException {
        List<CarModelEntity> models = new ArrayList<>();
        String sql = "SELECT * FROM CarModel";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                models.add(new CarModelEntity(rs.getInt("id"), rs.getString("name")));
            }
        }
        return models;
    }
}
