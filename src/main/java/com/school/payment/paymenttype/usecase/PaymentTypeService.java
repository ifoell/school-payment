package com.school.payment.paymenttype.usecase;

import com.school.payment.paymenttype.adapter.repository.PaymentTypeRepository;
import com.school.payment.paymenttype.entity.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentTypeService {
	private final PaymentTypeRepository paymentTypeRepository;

	public List<PaymentType> getAllPaymentType() {
		return paymentTypeRepository.findAll();
	}

	public Optional<PaymentType> getPaymentTypeById(Long id) {
        return paymentTypeRepository.findById(id);
    }

	public PaymentType savePaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

	public PaymentType updatePaymentType(PaymentType paymentType) {
        return paymentTypeRepository.update(paymentType);
    }

	public void deletePaymentType(Long id) {
        paymentTypeRepository.deleteById(id);
    }
}
