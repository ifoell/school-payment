package com.school.payment.paymenttype.adapter.controller;

import com.school.payment.paymenttype.entity.PaymentType;
import com.school.payment.paymenttype.usecase.PaymentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment-type")
public class PaymentTypeController {
	private final PaymentTypeService paymentTypeService;

	@GetMapping
	public List<PaymentType> getAllPaymentType(){
		return paymentTypeService.getAllPaymentType();
	}

	@GetMapping("{id}")
	public Optional<PaymentType> getPaymentTypeById(@PathVariable Long id){
		return paymentTypeService.getPaymentTypeById(id);
	}

	@PostMapping
	public PaymentType createPaymentType(@RequestBody PaymentType paymentType){
		return paymentTypeService.savePaymentType(paymentType);
	}

	@PutMapping("/{id}")
    public PaymentType updatePaymentType(@PathVariable Long id, @RequestBody PaymentType paymentType){
        paymentType.setId(id);
		return paymentTypeService.updatePaymentType(paymentType);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePaymentType(@PathVariable Long id){
		try {
			paymentTypeService.deletePaymentType(id);
			return ResponseEntity.ok("Payment type with id: "+ id +" deleted successfully");
		} catch (Exception e){
			System.out.println("Error occurred while deleting Payment type: " + e.getMessage());
			return ResponseEntity.badRequest().body("Error occurred while deleting payment type with id " + id);
		}

	}
}
