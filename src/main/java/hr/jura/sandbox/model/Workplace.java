package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Table("Workplace")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workplace {

    Long workplaceId;
    String workplaceName;
    Long unitId;

}