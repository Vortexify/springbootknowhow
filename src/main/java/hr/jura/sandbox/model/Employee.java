package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Table("Employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    Long employeeId;
    String employeeName;

}