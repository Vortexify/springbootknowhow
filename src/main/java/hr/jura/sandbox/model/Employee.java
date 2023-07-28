package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Employee")
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    @Id
    @Column("employee_id")
    private Long employeeId;

    @Column("employee_name")
    private String employeeName;

}