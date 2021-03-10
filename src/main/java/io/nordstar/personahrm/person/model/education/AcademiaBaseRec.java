
package io.nordstar.personahrm.person.model.education;

//   Standard Libraries Imports

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//   Third Party Libraries Imports

//   FENIX Framework Imports

//   Application Domain Imports

/**
 * AcademiaBaseRec.java<br/><br/>
 * Creation Date 2019-09-15 19:59 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p>Keeps track of academic achievements.</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-15 19:59 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-15 19:59 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademiaBaseRec {
    int           academiaCode;
    int           personCode;
    LocalDateTime startDate;
    LocalDateTime endDate;
    boolean       ongoing;
    String        degreeName;
    String        institution;      //   Educational Institution
    String        institutionCity;
    String        institutionState;
    String        institutionCountry;
    String        achievements;
    LocalDateTime creationTimestamp;
    boolean       active;

}
