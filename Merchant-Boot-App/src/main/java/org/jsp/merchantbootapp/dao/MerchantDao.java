package org.jsp.merchantbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository merchantRepository;
	
	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
	
	public Merchant updateMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
	
	public Optional<Merchant> findById(int id) {
		return merchantRepository.findById(id);
	}
	
	public List<Merchant> findAll() {
		return merchantRepository.findAll();
	}
	
	public boolean deleteMerchant(int id) {
		Optional<Merchant> dbMerchant = findById(id);
		if(dbMerchant.isPresent()) {
			merchantRepository.delete(dbMerchant.get());
			return true;
		}
		return false;
	}
	
	public List<Merchant> findByName(String name) {
		return merchantRepository.findByName(name);
	}
	
	public Optional<Merchant> findByPhone(long phone) {
		return merchantRepository.findByPhone(phone);
	}
	
	public Optional<Merchant>  findByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}
	
	public Optional<Merchant> findByGstNumber(String gst) {
		return merchantRepository.findByGst_Number(gst);
	}
	
	public Optional<Merchant> verify(long phone,String password) {
		return merchantRepository.verify(phone, password);
	}
	
	public Optional<Merchant> verify(String email,String password) {
		return merchantRepository.verify(email, password);
	}
	
	public Optional<Merchant> verify(int id,String password) {
		return merchantRepository.verify(id, password);
	}
	
	public Optional<Merchant> verifyByGstNumber(String gst, String password) {
		return merchantRepository.verifyByGst_number(gst, password);
	}
}
