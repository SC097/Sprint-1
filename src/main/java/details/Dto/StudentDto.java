package details.Dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@NotNull(message = "Name should not be empty")
	@NotBlank(message = "Emptiness is not allowed")
	@Size(min = 4, max = 20, message = "Name must be in the range 4-20 characters")
	private String name;

	@NotNull(message = "Name should not be empty")
	@NotBlank(message = "Emptiness is not allowed")
	@Size(min = 4, max = 20, message = "Name must be in the range 4-20 characters")
	private String college;

	@Email(message = "Invalid Email format")
	private String email;

}
