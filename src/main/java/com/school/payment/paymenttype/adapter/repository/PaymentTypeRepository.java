package com.school.payment.paymenttype.adapter.repository;

import com.school.payment.paymenttype.entity.PaymentType;

import java.util.List;
import java.util.Optional;

public interface PaymentTypeRepository {
	List<PaymentType> findAll();
	Optional<PaymentType> findById(Long id);
	PaymentType save(PaymentType paymentType);
	PaymentType update(PaymentType paymentType);
	void deleteById(Long id);
}
