package com.school.payment.student.entity;

import com.school.payment.helper.entity.AbstractEntity;
import com.school.payment.payment.entity.Payment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student", schema = "school_management")
public class Student extends AbstractEntity {

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "s_id_number", length = 20)
	private String sIdNumber;

	@Column(name = "nat_s_id_number", length = 30)
	private String natSIdNumber;

	@Lob
	@Column(name = "gender")
	private String gender;

	@Column(name = "address", length = 100)
	private String address;

	@Column(name = "class_id")
	private Integer classId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "entry_year", nullable = false)
	private Integer entryYear;

	@Column(name = "parents_id")
	private Integer parentsId;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_payment",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "payment_id")
	)
	private Set<Payment> payments;

}