package com.proj90.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj90.model.Reimbursement;
import com.proj90.utils.ConnectionFactory;

public class ReimbursementDaoImpl implements ReimbursementDao {
	@Override
	public List<Reimbursement> getAllReimbursementsByUsername(String username) {
		List<Reimbursement> Reimbursements = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM chrismadebywilliam.TODOS WHERE username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
				Reimbursements.add(new Reimbursement(rs.getInt("TODO_ID"), rs.getString("title"), rs.getString("description")));
			return Reimbursements;
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get all Reimbursements");
	
		}
	}

	@Override
	public Reimbursement createReimb(Reimbursement Reimbursement, String username) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			CallableStatement stmt = conn.prepareCall("CALL chrismadebywilliam.CREATE_Todo(?, ?, ?)");
			stmt.setString(1, Reimbursement.getTitle());
			stmt.setString(2, Reimbursement.getDescription());
			stmt.setString(3, username);
			if (stmt.executeUpdate() == 1) 
				return Reimbursement;
			else 
				return null;
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get all Reimbursements");
		}
	}
}
