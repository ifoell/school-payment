package com.school.payment.paymenttype.entity;

import com.school.payment.helper.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment_type", schema = "school_management")
public class PaymentType extends AbstractEntity {

	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "description", length = 100)
	private String description;

	@Column(name = "nominal")
	private Integer nominal;

}