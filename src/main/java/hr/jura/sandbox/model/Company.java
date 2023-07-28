package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Company")
@Getter
@Setter
@AllArgsConstructor
public class Company {

    @Id
    @Column("company_id")
    private Long companyId;

    @Column("company_name")
    private String companyName;

}
