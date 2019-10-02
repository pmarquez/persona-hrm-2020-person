package io.nordstar.personahrm.person.dao;

import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

/**
 * PersonsRepository.java<br><br>
 * Creation Date 2019-09-30 15:02 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p>Rest Controller for all things PERSON</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-30 15:02 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-30 15:02 PT
 */
@Repository
public class PersonRepositoryImpl implements PersonsRepository {

    @Autowired
    private JdbcTemplate personJdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate personNpJdbcTemplate;


    //   Companies CRUD
    private static final String RETRIEVE_PERSON_BY_CODE_SQL_QUERY = "SELECT hrm_pers_personentity.personCode, "                                                                         +
                                                                           "hrm_pers_personentity.idTypeCode, "                                                                         +
                                                                           "IFNULL(hrm_pers_idtypeentity.idTypeName,'') AS ID_TYPE_NAME, "                                              +
                                                                           "IFNULL(hrm_pers_personentity.idNumber,'') AS ID_NUMBER, "                                                   +
                                                                           "IFNULL(hrm_pers_personentity.firstName,'') AS FIRST_NAME, "                                                 +
                                                                           "IFNULL(hrm_pers_personentity.middleName,'') AS MIDDLE_NAME, "                                               +
                                                                           "IFNULL(hrm_pers_personentity.lastName,'') AS LAST_NAME, "                                                   +
                                                                           "hrm_pers_personentity.genderCode, "                                                                         +
                                                                           "IFNULL(hrm_pers_genderentity.genderName,'') AS GENDER_NAME, "                                               +
                                                                           "IFNULL(hrm_pers_personentity.socialSecurityNumber,'') AS SOCIAL_SECURITY_NUMBER, "                          +
                                                                           "hrm_pers_personentity.birthDate, "                                                                          +
                                                                           "hrm_pers_personentity.active "                                                                              +

                                                                    "FROM hrm_pers_personentity "                                                                                       +

                                                                    "LEFT OUTER JOIN hrm_pers_idtypeentity ON hrm_pers_personentity.idTypeCode = hrm_pers_idtypeentity.idTypeCode "     +
                                                                    "LEFT OUTER JOIN hrm_pers_genderentity ON hrm_pers_personentity.genderCode = hrm_pers_genderentity.genderCode "     +

                                                                    "WHERE hrm_pers_personentity.personCode = :personCode";


    private static final String RETRIEVE_PERSONS_SQL_QUERY =    "SELECT hrm_pers_personentity.personCode, "                                                                         +
                                                                       "hrm_pers_personentity.idTypeCode, "                                                                         +
                                                                       "IFNULL(hrm_pers_idtypeentity.idTypeName,'') AS ID_TYPE_NAME, "                                              +
                                                                       "IFNULL(hrm_pers_personentity.idNumber,'') AS ID_NUMBER, "                                                   +
                                                                       "IFNULL(hrm_pers_personentity.firstName,'') AS FIRST_NAME, "                                                 +
                                                                       "IFNULL(hrm_pers_personentity.middleName,'') AS MIDDLE_NAME, "                                               +
                                                                       "IFNULL(hrm_pers_personentity.lastName,'') AS LAST_NAME, "                                                   +
                                                                       "hrm_pers_personentity.genderCode, "                                                                         +
                                                                       "IFNULL(hrm_pers_genderentity.genderName,'') AS GENDER_NAME, "                                               +
                                                                       "IFNULL(hrm_pers_personentity.socialSecurityNumber,'') AS SOCIAL_SECURITY_NUMBER, "                          +
                                                                       "hrm_pers_personentity.birthDate, "                                                                          +
                                                                       "hrm_pers_personentity.active "                                                                              +

                                                                "FROM hrm_pers_personentity "                                                                                       +

                                                                "LEFT OUTER JOIN hrm_pers_idtypeentity ON hrm_pers_personentity.idTypeCode = hrm_pers_idtypeentity.idTypeCode "     +
                                                                "LEFT OUTER JOIN hrm_pers_genderentity ON hrm_pers_personentity.genderCode = hrm_pers_genderentity.genderCode "     +

                                                                "ORDER BY hrm_pers_personentity.lastName, "                                                                         +
                                                                         "hrm_pers_personentity.firstName, "                                                                        +
                                                                         "hrm_pers_personentity.middleName";


    @Override
    public void createPerson ( PersonRec company ) {

    }

    @Override
    public PersonRec retrievePersonByCode ( int personCode ) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource ( );
        mapSqlParameterSource.addValue ( "personCode", personCode );

        try {

            return personNpJdbcTemplate.queryForObject ( RETRIEVE_PERSON_BY_CODE_SQL_QUERY,
                    mapSqlParameterSource,
                    ( rs, rowNum ) -> new PersonRec (     rs.getInt        ( "personCode"             ),
                                                          rs.getInt        ( "idTypeCode"             ),
                                                          rs.getString     ( "ID_TYPE_NAME"           ),
                                                          rs.getString     ( "ID_NUMBER"              ),
                                                          rs.getString     ( "FIRST_NAME"             ),
                                                          rs.getString     ( "MIDDLE_NAME"            ),
                                                          rs.getString     ( "LAST_NAME"              ),
                                                          rs.getInt        ( "genderCode"             ),
                                                          rs.getString     ( "GENDER_NAME"            ),
                                                          rs.getString     ( "SOCIAL_SECURITY_NUMBER" ),
                                                          rs.getString     ( "birthDate"              ),
                                                          "",
                                                          rs.getBoolean    ( "active"                 ),
                                                          null
                                                    )
                                                 );

        } catch ( InvalidResultSetAccessException irsae ) {
            System.out.println ( "InvalidResultSetAccessException: " + irsae.getStackTrace ( ) );

        } catch ( DataAccessException dae ) {
            System.out.println ( "DataAccessException: " + dae.getStackTrace ( ) );

        } catch ( Exception e ) {
            System.out.println ( "Exception: " + e.getStackTrace ( ).toString () );

        }

        return new PersonRec ( );

    }

    @Override
    public List<PersonBaseRec> retrievePersons ( ) {

        try {
            return personJdbcTemplate.query ( RETRIEVE_PERSONS_SQL_QUERY,
                    ( rs, rowNum ) -> new PersonBaseRec (   rs.getInt     ( "personCode" ),
                                                            rs.getInt     ( "idTypeCode" ),
                                                            rs.getString  ( "ID_TYPE_NAME" ),
                                                            rs.getString  ( "ID_NUMBER" ),
                                                            rs.getString  ( "FIRST_NAME" ),
                                                            rs.getString  ( "MIDDLE_NAME" ),
                                                            rs.getString  ( "LAST_NAME" ),
                                                            rs.getInt     ( "genderCode" ),
                                                            rs.getString  ( "GENDER_NAME" ),
                                                            rs.getString  ( "SOCIAL_SECURITY_NUMBER" ),
                                                            rs.getString  ( "birthDate" ),
                                                            "",
                                                            rs.getBoolean ( "active" )
                    )
            );

        } catch ( InvalidResultSetAccessException irsae ) {
            System.out.println ( "InvalidResultSetAccessException: " + irsae.getStackTrace ( ) );

        } catch ( DataAccessException dae ) {
            System.out.println ( "DataAccessException: " + dae.getStackTrace ( ) );

        } catch ( Exception e ) {
            System.out.println ( "Exception: " + e.getStackTrace ( ).toString ( ) );

        }

        return new ArrayList<> ( );

    }

    @Override
    public void updatePerson ( int personCode, PersonRec personData ) {

    }

    @Override
    public void deletePerson ( int personCode ) {

    }
}
