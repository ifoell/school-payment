package com.school.payment.paymenttype.persistence;

import com.school.payment.paymenttype.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPaymentTypeRepository extends JpaRepository<PaymentType, Long>, JpaSpecificationExecutor<PaymentType> {
}