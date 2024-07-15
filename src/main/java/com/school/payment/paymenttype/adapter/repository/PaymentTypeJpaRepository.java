package com.school.payment.paymenttype.adapter.repository;

import com.school.payment.paymenttype.entity.PaymentType;
import com.school.payment.paymenttype.persistence.JpaPaymentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentTypeJpaRepository implements PaymentTypeRepository {
	private final JpaPaymentTypeRepository jpaPaymentTypeRepository;


	@Override
	public List<PaymentType> findAll() {
		return jpaPaymentTypeRepository.findAll();
	}

	@Override
	public Optional<PaymentType> findById(Long id) {
		return jpaPaymentTypeRepository.findById(id);
	}

	@Override
	public PaymentType save(PaymentType paymentType) {
		return jpaPaymentTypeRepository.save(paymentType);
	}

	@Override
	public PaymentType update(PaymentType paymentType) {
		return jpaPaymentTypeRepository.save(paymentType);
	}

	@Override
	public void deleteById(Long id) {
		jpaPaymentTypeRepository.deleteById(id);
	}
}
