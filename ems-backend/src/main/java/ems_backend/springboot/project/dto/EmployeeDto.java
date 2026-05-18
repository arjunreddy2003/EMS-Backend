package ems_backend.springboot.project.dto;

//import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name="employee")
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
//    public EmployeeDto(Long id, String firstName, String lastName, String email) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
  //  }
}
