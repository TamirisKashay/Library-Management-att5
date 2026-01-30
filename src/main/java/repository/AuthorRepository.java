package repository;

import exception.DatabaseOperationException;
import interfaces.CrudRepository;
import model.Author;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepository implements CrudRepository<Author, Long> {

    @Override
    public Author create(Author author) {
        String sql = "INSERT INTO authors (name, nationality) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, author.getName());
            pstmt.setString(2, author.getNationality());

            pstmt.executeUpdate();
            System.out.println("Author saved to database: " + author.getName());

            return author;
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error saving author: " + e.getMessage());
        }
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Author> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Author update(Author author) {
        return author;
    }

    @Override
    public void delete(Long id) {
        // not implemented yet
    }
}