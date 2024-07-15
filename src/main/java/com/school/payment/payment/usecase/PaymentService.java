package com.school.payment.payment.usecase;

import com.school.payment.payment.adapter.dto.StudentPaymentRequest;
import com.school.payment.payment.entity.Payment;
import com.school.payment.payment.entity.StudentPayment;
import com.school.payment.payment.adapter.dto.StudentPaymentDTO;
import com.school.payment.payment.adapter.repository.PaymentRepository;
import com.school.payment.student.adapter.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
	private final PaymentRepository paymentRepository;
	private final StudentClient studentClient;
	private final ZoneOffset zoneOffset = ZoneOffset.UTC;

	public List<Payment> getAllPayments() {
		return paymentRepository.getAllPayments();
	}

	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	public List<StudentPaymentDTO> getStudentPayments() {
		return paymentRepository.getStudentPayments();
	}

	public Optional<StudentPaymentDTO> getStudentPaymentById(Long id) {
		return paymentRepository.getStudentPaymentById(id);
	}

	public StudentPayment createStudentPayment(StudentPaymentRequest request) {
		Optional<StudentDTO> studentDTO = studentClient.getStudentById(request.getStudent());
		return paymentRepository.createStudentPayment(request, studentDTO.orElse(null));
	}

	public StudentPayment updateStudentPayment(Long id, StudentPaymentRequest request) {
		Optional<StudentDTO> studentDTO = studentClient.getStudentById(request.getStudent());
		return paymentRepository.updateStudentPayment(id, request, studentDTO.orElse(null));
	}

	public void deleteStudentPayment(Long id) {
		paymentRepository.deleteStudentPayment(id);
	}

}
