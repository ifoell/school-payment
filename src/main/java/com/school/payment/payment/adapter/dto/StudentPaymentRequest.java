package com.school.payment.payment.adapter.dto;

import com.school.payment.payment.entity.Payment;
import lombok.Data;

@Data
public class StudentPaymentRequest {
	private Long student;
	private PaymentRequest payment;
}
