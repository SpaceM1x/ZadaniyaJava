package repository;

import Entity.CarEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarEntityRepository {
    private Connection connection;

    public CarEntityRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(CarEntity car) throws SQLException {
        String sql = "INSERT INTO Car (model_id, dealer_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, car.getModelId());
            stmt.setInt(2, car.getDealerId());
            stmt.executeUpdate();
        }
    }

    public CarEntity getById(int id) throws SQLException {
        String sql = "SELECT * FROM Car WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CarEntity(rs.getInt("id"), rs.getInt("model_id"), rs.getInt("dealer_id"));
            }
        }
        return null;
    }

    public void update(CarEntity car) throws SQLException {
        String sql = "UPDATE Car SET model_id = ?, dealer_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, car.getModelId());
            stmt.setInt(2, car.getDealerId());
            stmt.setInt(3, car.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Car WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<CarEntity> getAll() throws SQLException {
        List<CarEntity> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cars.add(new CarEntity(rs.getInt("id"), rs.getInt("model_id"), rs.getInt("dealer_id")));
            }
        }
        return cars;
    }
}
