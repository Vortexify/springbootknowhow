package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("EmploymentHistory")
@Getter
@Setter
@AllArgsConstructor
public class EmploymentHistory {

    @Id
    @Column("employment_id")
    private Long employmentId;

    @Column("employee_id")
    private Long employeeId;

    @Column("workplace_id")
    private Long workplaceId;

    @Column("start_date")
    private LocalDate startDate;

    @Column("end_date")
    private LocalDate endDate;

}