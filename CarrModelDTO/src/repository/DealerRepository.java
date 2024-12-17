package repository;

import Entity.DealerEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DealerRepository {
    private Connection connection;

    public DealerRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(DealerEntity dealer) throws SQLException {
        String sql = "INSERT INTO Dealer (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dealer.getName());
            stmt.executeUpdate();
        }
    }

    public DealerEntity getById(int id) throws SQLException {
        String sql = "SELECT * FROM Dealer WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DealerEntity(rs.getInt("id"), rs.getString("name"));
            }
        }
        return null;
    }

    public void update(DealerEntity dealer) throws SQLException {
        String sql = "UPDATE Dealer SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dealer.getName());
            stmt.setInt(2, dealer.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Dealer WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<DealerEntity> getAll() throws SQLException {
        List<DealerEntity> dealers = new ArrayList<>();
        String sql = "SELECT * FROM Dealer";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                dealers.add(new DealerEntity(rs.getInt("id"), rs.getString("name")));
            }
        }
        return dealers;
    }
}
