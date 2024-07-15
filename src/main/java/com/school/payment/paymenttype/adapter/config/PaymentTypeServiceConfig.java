package com.school.payment.paymenttype.adapter.config;

import com.school.payment.paymenttype.adapter.repository.PaymentTypeJpaRepository;
import com.school.payment.paymenttype.usecase.PaymentTypeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentTypeServiceConfig {
	@Bean
	public PaymentTypeService paymentTypeService(PaymentTypeJpaRepository paymentTypeJpaRepository) {
        return new PaymentTypeService(paymentTypeJpaRepository);
    }
}
