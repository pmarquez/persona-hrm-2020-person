package io.nordstar.personahrm.person.services;

import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import io.nordstar.personahrm.person.model.education.CertificationRec;
import io.nordstar.personahrm.person.model.education.SkillRec;
import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;

import java.util.List;

/**
 * EducationService.java<br><br>
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
public interface EducationService {

//    ACADEMIA CRUD

    /**
     * [C]
     * @param data
     */
    void createAcademicRecord ( AcademiaBaseRec data );

    /**
     * [R]
     * @param personCode
     * @return
     */
    List<AcademiaBaseRec> retrieveAcademicRecords ( int personCode );

    /**
     * [U]
     * @param academiaCode
     * @param data
     * @return
     */
    int updateAcademicRecord (int academiaCode, AcademiaBaseRec data );

    /**
     * [D]
     * @param academiaCode
     * @return
     */
    int deleteAcademicRecord ( int academiaCode );

//    CERTIFICATIONS CRUD

    /**
     * [R]
     * @param personCode
     * @return
     */
    List<CertificationRec> retrieveCertifications ( int personCode );

//    SKILLS CRUD

    /**
     * [R]
     * @param personCode
     * @return
     */
    List<SkillRec> retrieveSkills ( int personCode );

}
