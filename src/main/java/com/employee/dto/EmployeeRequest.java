package com.employee.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
	
	

	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public EmployeeRequest(
			@Pattern(regexp = "^E\\d{3}$", message = "Employee ID must start with 'E' followed by 3 digits.") String employeeId,
			@NotNull(message = "First name is mandatory.") String firstName,
			@NotBlank(message = "Last name is mandatory.") String lastName,
			@Email(message = "Email should be valid.") @NotBlank(message = "Email is mandatory.") String email,
			@NotEmpty(message = "Phone numbers list cannot be empty.") List<@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits.") String> phoneNumbers,
			@PastOrPresent(message = "DOJ should be a valid past or present date.") @NotNull(message = "Date of Joining is mandatory.") LocalDate doj,
			@Positive(message = "Salary must be a positive number.") @NotNull(message = "Salary is mandatory.") Double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.doj = doj;
		this.salary = salary;
	}


	@Id
    @Pattern(regexp = "^E\\d{3}$", message = "Employee ID must start with 'E' followed by 3 digits.")
    @Column(unique = true)
	private String employeeId;  // Use UUID instead of String

	@NotNull(message = "First name is mandatory.")
    private String firstName;

    @NotBlank(message = "Last name is mandatory.")
    private String lastName;

    @Email(message = "Email should be valid.")
    @NotBlank(message = "Email is mandatory.")
    private String email;

    @ElementCollection
    @NotEmpty(message = "Phone numbers list cannot be empty.")
    private List<@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits.") String> phoneNumbers;

    @PastOrPresent(message = "DOJ should be a valid past or present date.")
    @NotNull(message = "Date of Joining is mandatory.")
    private LocalDate doj;

    @Positive(message = "Salary must be a positive number.")
    @NotNull(message = "Salary is mandatory.")
    private Double salary;
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
    
    
}
