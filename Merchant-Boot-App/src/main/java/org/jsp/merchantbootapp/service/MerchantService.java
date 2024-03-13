package org.jsp.merchantbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dao.MerchantDao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponceStructure;
import org.jsp.merchantbootapp.exception.IdNotFountException;
import org.jsp.merchantbootapp.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao dao;

	public ResponceStructure<Merchant> saveMerchant(Merchant merchant) {
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		structure.setMessage("Merchant Saved Sucessfully!!");
		structure.setData(dao.saveMerchant(merchant));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseEntity<ResponceStructure<Merchant>> updateMerchant(Merchant merchant) {
		Optional<Merchant> recMerchant = dao.findById(merchant.getId());
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			Merchant dbMerchant = recMerchant.get();
			dbMerchant.setName(merchant.getName());
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setGst_number(merchant.getGst_number());
			dbMerchant.setPhone(merchant.getPhone());
			dbMerchant.setPassword(merchant.getPassword());
			structure.setMessage("Merchant Updated Sucessfully!!");
			structure.setData(dao.updateMerchant(dbMerchant));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFountException();
	}

	public ResponseEntity<ResponceStructure<Merchant>> findById(int id) {
		Optional<Merchant> recMerchant = dao.findById(id);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Merchant Found!!");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new  IdNotFountException();
	}

	public ResponseEntity<ResponceStructure<String>> deleteMerchant( int id) {
		Optional<Merchant> recMerchant = dao.findById(id);
		ResponceStructure<String> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			dao.deleteMerchant(id);
			structure.setMessage("Merchant Deleted!!");
			structure.setData("Deleted Successsfully!!");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFountException();
	}

	public ResponseEntity<ResponceStructure<List<Merchant>>> findAll() {
		ResponceStructure<List<Merchant>> structure = new ResponceStructure<>();
		List<Merchant> recMerchants = dao.findAll();
		if (recMerchants.size() > 0) {
			structure.setMessage("Merchants Found");
			structure.setData(recMerchants);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<List<Merchant>>>(structure, HttpStatus.OK);
		}
		structure.setMessage("No Merchants Found!!");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<List<Merchant>>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponceStructure<Merchant>> verify(long phone, String password) {
		Optional<Merchant> recMerchant = dao.verify(phone, password);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Successful!!");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException("Invalid Phone or Password!!!");
	}

	public ResponseEntity<ResponceStructure<List<Merchant>>> findByName(String name) {
		ResponceStructure<List<Merchant>> structure = new ResponceStructure<>();
		List<Merchant> recMerchants = dao.findByName(name);
		if (recMerchants.size() > 0) {
			structure.setMessage("Merchants Found");
			structure.setData(recMerchants);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<List<Merchant>>>(structure, HttpStatus.OK);
		}
		structure.setMessage("No Merchants Found!!");
		structure.setData(null);
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<List<Merchant>>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponceStructure<Merchant>> verify(String email, String password) {
		Optional<Merchant> recMerchant = dao.verify(email, password);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Successful!!");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException("Invalid Email or Password!!!");
	}

	public ResponseEntity<ResponceStructure<Merchant>> findByPhone(long phone) {
		Optional<Merchant> recMerchant = dao.findByPhone(phone);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant Found!!");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("Merchant Not Found!!. Invalid Phone!!");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponceStructure<Merchant>> findByEmail(String email) {
		Optional<Merchant> recMerchant = dao.findByEmail(email);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant Found!!");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("Merchant Not Found!!. Invalid Email!!");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponceStructure<Merchant>> findByGstNumber(String gst) {
		Optional<Merchant> recMerchant = dao.findByGstNumber(gst);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant Found!!");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("Merchant Not Found!!. Invalid GST Number!!");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponceStructure<Merchant>> verify(int id, String password) {
		Optional<Merchant> recMerchant = dao.verify(id, password);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Successful!!");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException("Invalid ID or Password!!!");
	}

	public ResponseEntity<ResponceStructure<Merchant>> verifyByGstNumber(String gst, String password) {
		Optional<Merchant> recMerchant = dao.verifyByGstNumber(gst, password);
		ResponceStructure<Merchant> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Successful!!");
			structure.setData(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException("Invalid Gst Number or Password!!!");
	}
}
