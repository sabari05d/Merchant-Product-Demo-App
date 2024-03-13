package org.jsp.merchantbootapp.controller;

import java.util.List;

import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.ResponceStructure;
import org.jsp.merchantbootapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchants")
public class MerchantController {
	@Autowired
	private MerchantService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponceStructure<Merchant> saveMerchant(@RequestBody Merchant merchant) {
		return service.saveMerchant(merchant);
	}

	@PutMapping
	public ResponseEntity<ResponceStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return service.updateMerchant(merchant);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponceStructure<Merchant>> findById(@PathVariable int id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponceStructure<String>> deleteMerchant(@PathVariable(name = "id") int id) {
		return service.deleteMerchant(id);
	}

	@GetMapping
	public ResponseEntity<ResponceStructure<List<Merchant>>> findAll() {
		return service.findAll();
	}

	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponceStructure<Merchant>> verify(@RequestParam long phone, @RequestParam String password) {
		return service.verify(phone, password);
	}

	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<ResponceStructure<List<Merchant>>> findbyName(@PathVariable String name) {
		return service.findByName(name);
	}

	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponceStructure<Merchant>> verify(@RequestParam String email,
			@RequestParam String password) {
		return service.verify(email, password);
	}

	@PostMapping("/find-by-phone")
	public ResponseEntity<ResponceStructure<Merchant>> findByPhone(@RequestParam long phone) {
		return service.findByPhone(phone);
	}

	@PostMapping("/find-by-email")
	public ResponseEntity<ResponceStructure<Merchant>> findByEmail(@RequestParam String email) {
		return service.findByEmail(email);
	}

	@PostMapping("/find-by-gstnumber")
	public ResponseEntity<ResponceStructure<Merchant>> findByGstNumber(@RequestParam String gst) {
		return service.findByGstNumber(gst);
	}

	@PostMapping("/verify-by-id")
	public ResponseEntity<ResponceStructure<Merchant>> verify(@RequestParam int id, @RequestParam String password) {
		return service.verify(id, password);
	}

	@PostMapping("/verify-by-gstnumber")
	public ResponseEntity<ResponceStructure<Merchant>> verifyByGst_number(@RequestParam String gst,
			@RequestParam String password) {
		return service.verifyByGstNumber(gst, password);
	}

}
