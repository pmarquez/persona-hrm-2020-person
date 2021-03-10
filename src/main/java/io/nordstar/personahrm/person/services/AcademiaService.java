package io.nordstar.personahrm.person.services;

import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;

import java.util.List;

/**
 * AcademiaService.java<br><br>
 * Creation Date 2021-03-10 16:37 CET<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2021-03-10 16:37 CET<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2021-03-10 16:37 CET
 */
public interface AcademiaService {

//    ACADEMIA CRUD

    /**
     * [C]
     * @param data
     */
    public void createAcademicRecord ( AcademiaBaseRec data );

    /**
     * [R]
     * @param codPerson
     * @return
     */
    public List<AcademiaBaseRec> retrieveAcademicRecords ( int codPerson );

    /**
     * [U]
     * @param academiaCode
     * @param data
     * @return
     */
    public int updateAcademicRecord (int academiaCode, AcademiaBaseRec data );

    /**
     * [D]
     * @param academiaCode
     * @return
     */
    public int deleteAcademicRecord ( int academiaCode );

}
