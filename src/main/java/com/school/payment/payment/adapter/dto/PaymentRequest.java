package com.school.payment.payment.adapter.dto;

import lombok.Data;

@Data
public class PaymentRequest {
	private Long paymentType;
	private Integer nominal;
	private Short status;
	private String paymentDate;
}
