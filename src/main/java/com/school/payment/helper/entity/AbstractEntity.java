package com.school.payment.helper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@ComponentScan
public class AbstractEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_on")
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedOn;
}
