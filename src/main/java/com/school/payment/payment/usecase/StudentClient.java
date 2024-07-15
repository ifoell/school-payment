package com.school.payment.payment.usecase;

import com.school.payment.student.adapter.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "school-mgmt", url = "${student.service.url}")
public interface StudentClient {

	@GetMapping("/student/{id}")
	Optional<StudentDTO> getStudentById(@RequestParam("id") Long id);

	@GetMapping("/student/sidNumber")
	Optional<StudentDTO> getStudentBySidNumber(@RequestParam("sidNumber") String sidNumber);

	default Optional<StudentDTO> getStudentByIdOrSidNumber(Long idOrSidNumber) {
		Optional<StudentDTO> studentOpt = getStudentById(idOrSidNumber);
		if (studentOpt.isEmpty()) {
			studentOpt = getStudentBySidNumber(String.valueOf(idOrSidNumber));
		}
		return studentOpt;
	}
}