package com.school.payment.payment.adapter.repository;

import com.school.payment.payment.adapter.dto.StudentPaymentDTO;
import com.school.payment.payment.adapter.dto.StudentPaymentRequest;
import com.school.payment.payment.entity.Payment;
import com.school.payment.payment.entity.StudentPayment;
import com.school.payment.payment.persistence.JpaPaymentRepository;
import com.school.payment.payment.persistence.StudentPaymentRepository;
import com.school.payment.payment.usecase.StudentClient;
import com.school.payment.paymenttype.adapter.repository.PaymentTypeRepository;
import com.school.payment.paymenttype.entity.PaymentType;
import com.school.payment.student.adapter.dto.StudentDTO;
import com.school.payment.student.adapter.repository.StudentRepository;
import com.school.payment.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentJpaRepository implements PaymentRepository {
	private final JpaPaymentRepository jpaPaymentRepository;
	private final StudentPaymentRepository studentPaymentRepository;
	private final PaymentTypeRepository paymentTypeRepository;
	private final StudentClient studentClient;
	private final StudentRepository studentRepository;
	private final ZoneOffset zoneOffset = ZoneOffset.UTC;


	@Override
	public List<Payment> getAllPayments() {
		return jpaPaymentRepository.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		return jpaPaymentRepository.save(payment);
	}

	@Override
	public List<StudentPaymentDTO> getStudentPayments() {
//		return studentPaymentRepository.findAll();
		List<Payment> payments = getAllPayments();
		List<StudentPaymentDTO> studentPayments = new ArrayList<>();

		for (Payment payment : payments) {
			List<StudentPayment> studentPaymentList = studentPaymentRepository.findByPaymentId(payment.getId());

			for (StudentPayment studentPayment : studentPaymentList) {
				Optional<StudentDTO> studentDTO = studentClient.getStudentById(studentPayment.getStudent().getId());

				if (studentDTO.isPresent()) {
					StudentPaymentDTO studentPaymentDTO = new StudentPaymentDTO();
					studentPaymentDTO.setStudentId(studentDTO.get().getId());
					studentPaymentDTO.setStudentName(studentDTO.get().getName());
					studentPaymentDTO.setStudentSchoolId(studentDTO.get().getNatSIdNumber());
					studentPaymentDTO.setPaymentId(payment.getId());
					studentPaymentDTO.setPaymentAmount(payment.getNominal());
					studentPaymentDTO.setPaymentStatus(payment.getStatus());
					studentPaymentDTO.setPaymentDate(LocalDateTime.from(payment.getPaymentDate()));

					studentPayments.add(studentPaymentDTO);
				}
			}
		}

		return studentPayments;
	}

	@Override
	public Optional<StudentPaymentDTO> getStudentPaymentById(Long id) {
		Optional<StudentPayment> studentPaymentOpt = studentPaymentRepository.findById(id);
		if (studentPaymentOpt.isPresent()) {
			StudentPayment studentPayment = studentPaymentOpt.get();
			Optional<StudentDTO> studentDTO = studentClient.getStudentById(studentPayment.getStudent().getId());

			if (studentDTO.isPresent()) {
				StudentPaymentDTO studentPaymentDTO = new StudentPaymentDTO();
				studentPaymentDTO.setStudentId(studentDTO.get().getId());
				studentPaymentDTO.setStudentName(studentDTO.get().getName());
				studentPaymentDTO.setStudentSchoolId(studentDTO.get().getNatSIdNumber());
				studentPaymentDTO.setPaymentId(studentPayment.getPayment().getId());
				studentPaymentDTO.setPaymentAmount(studentPayment.getPayment().getNominal());
				studentPaymentDTO.setPaymentStatus(studentPayment.getPayment().getStatus());
				studentPaymentDTO.setPaymentDate(LocalDateTime.from(studentPayment.getPayment().getPaymentDate()));

				return Optional.of(studentPaymentDTO);
			}
		}

		return Optional.empty();
	}

	@Override
	public StudentPayment createStudentPayment(StudentPaymentRequest request, StudentDTO studentDTO) {
		PaymentType paymentType = paymentTypeRepository.findById(request.getPayment().getPaymentType())
				.orElseThrow(() -> new IllegalArgumentException("Invalid payment type ID"));

		Payment payment = new Payment();
		payment.setPaymentType(paymentType);
		payment.setNominal(request.getPayment().getNominal());
		payment.setStatus(request.getPayment().getStatus());
		if (request.getPayment().getPaymentDate() != null) {
			payment.setPaymentDate(LocalDateTime.parse(request.getPayment().getPaymentDate()).atOffset(zoneOffset));
		} else {
			payment.setPaymentDate(OffsetDateTime.from(LocalDateTime.now().atOffset(zoneOffset)));
		}

		payment = jpaPaymentRepository.save(payment);

		Student student = studentRepository.findById(studentDTO.getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

		StudentPayment studentPayment = new StudentPayment();
		studentPayment.setPayment(payment);
		studentPayment.setStudent(student);

		return studentPaymentRepository.save(studentPayment);
	}

	@Override
	public StudentPayment updateStudentPayment(Long id, StudentPaymentRequest request, StudentDTO studentDTO) {
		StudentPayment existingStudentPayment = studentPaymentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("StudentPayment with id " + id + " not found"));

		Payment payment = existingStudentPayment.getPayment();
		PaymentType paymentType = paymentTypeRepository.findById(request.getPayment().getPaymentType())
				.orElseThrow(() -> new IllegalArgumentException("Invalid payment type ID"));

		payment.setPaymentType(paymentType);
		payment.setNominal(request.getPayment().getNominal());
		payment.setStatus(request.getPayment().getStatus());
		payment.setStatus(request.getPayment().getStatus());
		if (request.getPayment().getPaymentDate() != null) {
			payment.setPaymentDate(LocalDateTime.parse(request.getPayment().getPaymentDate()).atOffset(zoneOffset));
		} else {
			payment.setPaymentDate(OffsetDateTime.from(LocalDateTime.now().atOffset(zoneOffset)));
		}

		jpaPaymentRepository.save(payment);

		Student student = studentRepository.findById(studentDTO.getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

		existingStudentPayment.setStudent(student);
		return studentPaymentRepository.save(existingStudentPayment);
	}

	@Override
	public void deleteStudentPayment(Long id) {
		studentPaymentRepository.deleteById(id);
	}


}
