package hr.jura.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Table("OrganizationUnit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationUnit {
  
     Long unitId;
     String unitName;
     Long companyId;

}