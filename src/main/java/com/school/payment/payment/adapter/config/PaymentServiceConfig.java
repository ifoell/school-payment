package com.school.payment.payment.adapter.config;

import com.school.payment.payment.adapter.repository.PaymentJpaRepository;
import com.school.payment.payment.usecase.PaymentService;
import com.school.payment.payment.usecase.StudentClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceConfig {
	@Bean
	public PaymentService paymentService(PaymentJpaRepository paymentJpaRepository, StudentClient studentClient) {
        return new PaymentService(paymentJpaRepository, studentClient);
    }
}
