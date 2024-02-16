package com.innoventes.test.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.Column;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;

	@NotNull
	@NotBlank(message = "companyName is mandatory")
	@Size(min = 5)
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "email is mandatory")
	@Email
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
