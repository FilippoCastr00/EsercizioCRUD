package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.models.Message;

public class MessageDAO {
    private String url = "jdbc:postgresql://192.168.64.5:5432/EsercizioCrud";
    private String user = "postgres";
    private String password = "mypassword";

    // Create
    public void createMessage(Message message) {
        String query = "INSERT INTO Messaggio(sender_message, text_message, message_date) VALUES (?,?,?)";
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        try (Connection conn = DriverManager.getConnection(url, this.user, this.password);
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, message.getSenderMessage());
            pstmt.setString(2, message.getTextMessage());
            pstmt.setTimestamp(3, timestamp);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // read
    public Message readMessage(int messageId) {
        String query = "SELECT * FROM Messaggio WHERE id_message = ?";
        try (Connection conn = DriverManager.getConnection(url, this.user, this.password);
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, messageId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Message(rs.getString("sender_message"),
                        rs.getString("text_message"),
                        rs.getTimestamp("message_date"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    // update
    public void updateMessage(Message message, int id) {
        String query = "UPDATE messaggio SET sender_message = ?, text_message = ?, message_date = ? WHERE id_message = ?";
        try (Connection conn = DriverManager.getConnection(url, this.user, this.password)) {

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, message.getSenderMessage());
            pstmt.setString(2, message.getTextMessage());
            pstmt.setTimestamp(3, message.getMessageDate());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void deleteMessage(int messageId) {
        String query = "DELETE FROM messaggio WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, this.user, this.password)) {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        MessageDAO messageDAO = new MessageDAO();
        Message message = new Message("Giacomo", "franco", timestamp);
        // messageDAO.createMessage(message);

        // System.out.println(messageDAO.readMessage(7));
        messageDAO.updateMessage(message, 3);
    }

}
