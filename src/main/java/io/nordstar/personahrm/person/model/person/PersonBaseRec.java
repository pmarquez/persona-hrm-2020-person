package io.nordstar.personahrm.person.model.person;

//   Standard Libraries Imports

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//   Third Party Libraries Imports

//   FENIX Framework Imports

//   Application Domain Imports


/**
 * PersonBaseRec.java<br><br>
 * Creation Date 2019-09-15 19:53 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-15 19:53 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-15 19:53 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  PersonBaseRec {
    protected int           personCode;
    protected int           idTypeCode;
    protected String        idType;
    protected String        idNumber;
    protected String        firstName;
    protected String        middleName;
    protected String        lastName;
    protected int           genderCode;
    protected String        gender;
    protected String        socialSecurityNumber;
    protected LocalDate     birthDate;
    protected LocalDateTime creationDate;
    protected Boolean       active;
}
