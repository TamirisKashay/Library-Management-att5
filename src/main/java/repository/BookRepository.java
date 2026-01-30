package repository;

import model.BookBase;
import model.PrintedBook;
import model.EBook;
import utils.DatabaseConnection;
import exception.DatabaseOperationException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import interfaces.CrudRepository;
import model.BookBase;

public class BookRepository implements CrudRepository<BookBase, Long> {


    @Override
    public BookBase create(BookBase book) {
        String sql = "INSERT INTO books (title, book_type, price) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getBookType());
            pstmt.setDouble(3, 10.0);

            pstmt.executeUpdate();

            return book; // ← ВАЖНО
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error saving book: " + e.getMessage());
        }
    }


    @Override
    public Optional<BookBase> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<BookBase> findAll() {
        return List.of();
    }

    @Override
    public BookBase update(BookBase entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    public void delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No book found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error deleting book: " + e.getMessage());
        }
    }
}