package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("OrganizationUnit")
@Getter
@Setter
@AllArgsConstructor
public class OrganizationUnit {
    @Id
    @Column("unit_id")
    private Long unitId;

    @Column("unit_name")
    private String unitName;

    @Column("company_id")
    private Long companyId;

}