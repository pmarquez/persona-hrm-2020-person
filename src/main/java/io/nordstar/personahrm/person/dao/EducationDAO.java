package io.nordstar.personahrm.person.dao;

import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import io.nordstar.personahrm.person.model.education.CertificationRec;
import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * AcademiaDAO.java<br><br>
 * Creation Date 2021-03-10 16:46 CET<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2021-03-10 16:46 CET<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2021-03-10 16:46 CET
 */
@Repository
public class EducationDAO {

    @Autowired
    private JdbcTemplate academiaJdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate academiaNpJdbcTemplate;


    private static final String RETRIEVE_ACADEMIC_RECORDS_SQL_QUERY = "SELECT hrm_pers_academiaentity.academiaCode, " +
            "hrm_pers_academiaentity.personCode, " +
            "hrm_pers_academiaentity.startDate, " +
            "hrm_pers_academiaentity.endDate, " +
            "hrm_pers_academiaentity.ongoing, " +
            "hrm_pers_academiaentity.degreeAchieved, " +
            "hrm_pers_academiaentity.instituteName, " +
            "hrm_pers_academiaentity.instituteCity, " +
            "hrm_pers_academiaentity.instituteState, " +
            "hrm_pers_academiaentity.instituteCountry, " +
            "hrm_pers_academiaentity.achievements, " +
            "hrm_pers_academiaentity.creationTimestamp, " +
            "hrm_pers_academiaentity.active " +

            "FROM hrm_pers_academiaentity " +

            "WHERE hrm_pers_academiaentity.personCode = :personCode " +
            "AND hrm_pers_academiaentity.active = true " +

            "ORDER BY startDate DESC";

    public List<AcademiaBaseRec> retrieveAcademicRecords(int personCode) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("personCode", personCode);

        try {

//            return academiaNpJdbcTemplate.queryForObject ( "CALL SP_RETRIEVE_PERSON( :personCode )",
            return academiaNpJdbcTemplate.query(RETRIEVE_ACADEMIC_RECORDS_SQL_QUERY,
                    mapSqlParameterSource,
                    (rs, rowNum) -> new AcademiaBaseRec(rs.getInt("academiaCode"),
                            rs.getInt("personCode"),
                            (rs.getTimestamp("startDate").toLocalDateTime()),
                            (rs.getTimestamp("endDate").toLocalDateTime()),
                            rs.getBoolean("ongoing"),
                            rs.getString("degreeAchieved"),
                            rs.getString("instituteName"),
                            rs.getString("instituteCity"),
                            rs.getString("instituteState"),
                            rs.getString("instituteCountry"),
                            rs.getString("achievements"),
                            (rs.getTimestamp("creationTimestamp").toLocalDateTime()),
                            rs.getBoolean("active")
                    )
            );

        } catch (InvalidResultSetAccessException irsae) {
            System.out.println("InvalidResultSetAccessException: " + irsae.getStackTrace());

        } catch (DataAccessException dae) {
            System.out.println("DataAccessException: " + dae.getStackTrace());

        } catch (Exception e) {
            System.out.println("Exception: " + e.getStackTrace().toString());

        }

        return new ArrayList<AcademiaBaseRec>();

    }

    private static final String RETRIEVE_CERTIFICATIONS_SQL_QUERY = "SELECT hrm_pers_certificateentity.certificationCode, "         +
                                                                           "hrm_pers_certificateentity.personCode, "                +
                                                                           "hrm_pers_certificateentity.certificationName, "         +
                                                                           "hrm_pers_certificateentity.certificationIssuer, "       +
                                                                           "hrm_pers_certificateentity.issueDate, "                 +
                                                                           "hrm_pers_certificateentity.description, "               +
                                                                           "hrm_pers_certificateentity.creationTimestamp, "         +
                                                                           "hrm_pers_certificateentity.active "                     +

                                                                    "FROM hrm_pers_certificateentity "                              +

                                                                    "WHERE hrm_pers_certificateentity.personCode = :personCode "    +
                                                                      "AND hrm_pers_certificateentity.active = TRUE "               +

                                                                    "ORDER BY hrm_pers_certificateentity.issueDate DESC";

    public List<CertificationRec> retrieveCertifications ( int personCode ) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue ( "personCode", personCode );

        try {

            return academiaNpJdbcTemplate.query( RETRIEVE_CERTIFICATIONS_SQL_QUERY,
                    mapSqlParameterSource,
                    (rs, rowNum) -> new CertificationRec ( rs.getInt       ( "certificationCode"   ),
                                                           rs.getInt       ( "personCode"          ),
                                                           rs.getString    ( "certificationName"   ),
                                                           rs.getString    ( "certificationIssuer" ),
                                                         ( rs.getTimestamp ( "issueDate" ).toLocalDateTime ( ) ).toLocalDate ( ),
                                                           rs.getString    ( "description" ),
                                                         ( rs.getTimestamp ( "creationTimestamp" ).toLocalDateTime ( ) ),
                                                           rs.getBoolean   ( "active" )
                    )
            );

        } catch (InvalidResultSetAccessException irsae) {
            System.out.println("InvalidResultSetAccessException: " + irsae.getStackTrace());

        } catch ( DataAccessException dae ) {
            System.out.println ( "DataAccessException: " + dae.getLocalizedMessage ( ) );
            System.out.println ( "DataAccessException: " + dae.getStackTrace ( ) );

        } catch (Exception e) {
            System.out.println("Exception: " + e.getStackTrace().toString());

        }

        return new ArrayList<CertificationRec> ( );

    }

}