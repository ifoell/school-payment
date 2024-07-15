package com.school.payment.payment.adapter.controller;

import com.school.payment.payment.adapter.dto.StudentPaymentDTO;
import com.school.payment.payment.adapter.dto.StudentPaymentRequest;
import com.school.payment.payment.entity.StudentPayment;
import com.school.payment.payment.usecase.PaymentService;
import com.school.payment.payment.usecase.StudentClient;
import com.school.payment.student.adapter.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
	private final PaymentService paymentService;
	private final StudentClient studentClient;

	@GetMapping
	public List<StudentPaymentDTO> getAllStudentPayments(){
		return paymentService.getStudentPayments();
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentPaymentDTO> getStudentPaymentById(@PathVariable Long id) {
		Optional<StudentPaymentDTO> studentPaymentOpt = paymentService.getStudentPaymentById(id);
		return studentPaymentOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<StudentPayment> createStudentPayment(@RequestBody StudentPaymentRequest request) {
		Optional<StudentDTO> studentDTO = studentClient.getStudentByIdOrSidNumber(request.getStudent());
		if (studentDTO.isPresent()) {
			StudentPayment createdStudentPayment = paymentService.createStudentPayment(request);
			return ResponseEntity.ok(createdStudentPayment);
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentPayment> updateStudentPayment(@PathVariable Long id, @RequestBody StudentPaymentRequest request) {
		Optional<StudentDTO> studentDTO = studentClient.getStudentByIdOrSidNumber(request.getStudent());
		if (studentDTO.isPresent()) {
			try {
				StudentPayment updatedStudentPayment = paymentService.updateStudentPayment(id, request);
				return ResponseEntity.ok(updatedStudentPayment);
			} catch (IllegalArgumentException e) {
				return ResponseEntity.notFound().build();
			}
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudentPayment(@PathVariable Long id) {
		try {
			paymentService.deleteStudentPayment(id);
			return ResponseEntity.ok("Student payment with id: " + id + " deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error occurred while deleting student payment with id " + id + ": " + e.getMessage());
		}
	}
}
