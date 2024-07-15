package com.school.payment.payment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.payment.helper.entity.AbstractEntity;
import com.school.payment.paymenttype.entity.PaymentType;
import com.school.payment.student.entity.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "payment", schema = "school_management")
public class Payment extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.SET_NULL)
	@JoinColumn(name = "payment_type_id")
	private PaymentType paymentType;

	@Column(name = "nominal")
	private Integer nominal;

	@Column(name = "status")
	private Short status;

	@Column(name = "payment_date")
	private OffsetDateTime paymentDate;

	@ManyToMany(mappedBy = "payments", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Student> students;

}