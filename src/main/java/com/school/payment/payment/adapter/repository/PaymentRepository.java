package com.school.payment.payment.adapter.repository;

import com.school.payment.payment.adapter.dto.StudentPaymentDTO;
import com.school.payment.payment.adapter.dto.StudentPaymentRequest;
import com.school.payment.payment.entity.Payment;
import com.school.payment.payment.entity.StudentPayment;
import com.school.payment.student.adapter.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
	List<Payment> getAllPayments();
	Payment save(Payment payment);
	List<StudentPaymentDTO> getStudentPayments();
	Optional<StudentPaymentDTO> getStudentPaymentById(Long id);
	StudentPayment createStudentPayment(StudentPaymentRequest request, StudentDTO studentDTO);
	StudentPayment updateStudentPayment(Long id, StudentPaymentRequest request, StudentDTO studentDTO);
	void deleteStudentPayment(Long id);
}
