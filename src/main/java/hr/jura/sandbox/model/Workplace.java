package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Workplace")
@Getter
@Setter
@AllArgsConstructor
public class Workplace {
    @Id
    @Column("workplace_id")
    private Long workplaceId;

    @Column("workplace_name")
    private String workplaceName;

    @Column("unit_id")
    private Long unitId;

}