
package io.nordstar.personahrm.person.model.person;

//   Standard Libraries Imports
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//   Third Party Libraries Imports
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

//   ns Framework Imports

//   Application Domain Imports
import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import io.nordstar.personahrm.person.model.education.CertificationRec;
import io.nordstar.personahrm.person.model.education.SkillRec;

/**
 * PersonRec.java<br><br>
 * Creation Date 2019-09-15 19:58 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-15 19:58 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-15 19:58 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRec extends PersonBaseRec {

    private List<AcademiaBaseRec>   academia;
    private List<CertificationRec>  certifications;
    private List<SkillRec>          skills;

    public PersonRec ( int           personCode,
                       int           idTypeCode,
                       String        idType,
                       String        idNumber,
                       String        firstName,
                       String        middleName,
                       String        lastName,
                       int           genderCode,
                       String        gender,
                       String        socialSecurityNumber,
                       LocalDate     birthDate,
                       LocalDateTime creationDate,
                       Boolean       active,
                       List<AcademiaBaseRec>  academia,
                       List<CertificationRec> certifications,
                       List<SkillRec>         skills ) {

        super ( personCode,
                idTypeCode,
                idType,
                idNumber,
                firstName,
                middleName,
                lastName,
                genderCode,
                gender,
                socialSecurityNumber,
                birthDate,
                creationDate,
                active );

        this.academia       = academia;
        this.certifications = certifications;
        this.skills         = skills;

    }


}
