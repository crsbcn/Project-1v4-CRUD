package com.proj90.dao;

import java.util.List;

import com.proj90.model.Reimbursement;

public interface ReimbursementDao {

		List<Reimbursement> getAllReimbursementsByUsername(String username);
		Reimbursement createReimb(Reimbursement reimb, String username);
}
