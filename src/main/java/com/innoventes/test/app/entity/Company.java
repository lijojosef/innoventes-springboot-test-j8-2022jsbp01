package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@NotNull
	@NotBlank(message = "companyName is mandatory")
	@Size(min = 5)
	@Column(name = "company_name")
	private String companyName;

	@Email
	@NotBlank(message = "email is mandatory")
	@Column(name = "email")
	private String email;

	@PositiveOrZero
	@Column(name = "strength")
	private Integer strength;

	@Column(name = "webSiteURL")
	private String webSiteURL;

	@Column(name = "company_Code")
	@NotBlank(message = "company code is mandatory")
	@Size(min = 5)
	@Pattern(regexp="^[a-zA-Z]{2}\\d{2}[EN]$",message="Invalid company code format")
	private String companyCode;
}
