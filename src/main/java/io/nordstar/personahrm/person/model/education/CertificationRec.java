package io.nordstar.personahrm.person.model.education;

//   Standard Libraries Imports
import java.time.LocalDate;
import java.time.LocalDateTime;

//   Third Party Libraries Imports
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//   FENIX Framework Imports


//   Application Domain Imports


/**
 * CertificationRec.java<br/><br/>
 * Creation Date 2021-03-11 16:51<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p>Keeps track of achieved certifications.</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2021-03-11 16:51<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2021-03-11 16:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationRec {
    int             certificationCode;
    int             personCode;
    String          certificationName;
    String          certificationIssuer;
    LocalDate       issueDate;
    String          description;
    LocalDateTime   creationTimestamp;
    boolean         active;
}
