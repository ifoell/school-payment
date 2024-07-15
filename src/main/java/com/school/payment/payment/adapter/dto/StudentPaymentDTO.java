package com.school.payment.payment.adapter.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentPaymentDTO {
	private Long studentId;
	private String studentName;
	private String studentSchoolId;
	private Long paymentId;
	private Integer paymentAmount;
	private Short paymentStatus;
	private LocalDateTime paymentDate;
}
