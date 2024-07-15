package com.school.payment.payment.persistence;

import com.school.payment.payment.entity.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPaymentRepository extends JpaRepository<StudentPayment, Long> {
	List<StudentPayment> findByPaymentId(Long paymentId);
}
