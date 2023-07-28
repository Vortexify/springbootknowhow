package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("EmploymentHistory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentHistory {

     Long employmentId;
     Long employeeId;
     Long workplaceId;
     LocalDate startDate;
     LocalDate endDate;

}