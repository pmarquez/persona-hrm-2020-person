
package io.nordstar.personahrm.person.web.controller;


//   Standard Libraries Imports

import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import io.nordstar.personahrm.person.services.AcademiaService;
import io.nordstar.personahrm.person.services.PersonsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AcademiaRestController.java<br><br>
 * Creation Date 2021-03-10 17:15 CET<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p>Rest Controller for all things Academia</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2021-03-10 17:15 CET<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2021-03-10 17:15 CET
 */
@RequestMapping("/PERSONA/personAPI/1.0/academia")
@RestController
public class AcademiaRestController {

    private static final Logger logger = LogManager.getLogger ( AcademiaRestController.class );

    //   Controller Constants
    private static final int EMPTY_ACADEMIC_RECORDS_LIST = 0;
    private static final int EMPTY_ACADEMIC_RECORD_REC   = 0;

//   Response Status
    private static final String OPERATION_SUCCESSFUL                            = "ACADEMIA_001";   //   The requested operation was successfully completed.
    private static final String NO_PERSON_FOUND                                 = "PERSONS_002";   //   Could not find requested person.
    private static final String NO_PERSONS_FOUND                                = "PERSONS_003";   //   The requested list of persons is empty.
    private static final String INVALID_USER_PRIVILEGES                         = "ACADEMIA_004";   //   User does not have the required privileges for this call.
    private static final String INVALID_AUTHORIZATION_TOKEN                     = "ACADEMIA_005";   //   Authorization token received is not valid.
    private static final String INTERNAL_ERROR_ENCOUNTERED                      = "ACADEMIA_006";   //   An internal error was encountered.
    private static final String REQUESTED_PERSON_EXISTS                         = "ACADEMIA_007";   //   The requested person exists.
    private static final String REQUESTED_PERSON_DOES_NOT_EXIST                 = "ACADEMIA_008";   //   The requested person does not exist.

    private final AcademiaService academiaService;

    /**
     * Constructor
     *
     * @param academiaService
     */
    public AcademiaRestController ( AcademiaService academiaService ) {
        this.academiaService = academiaService;
    }

    /**
     * Retrieves academic records for person from storage
     * @param personCode
     * @return ResponseEntity<List<AcademiaBaseRec>>
     */
    @GetMapping ( value = "/academicRecords/{personCode}" )
    public ResponseEntity<List<AcademiaBaseRec>> retrievePersonByCode (@PathVariable ( "personCode" ) int personCode ) {

        List<AcademiaBaseRec> l = this.academiaService.retrieveAcademicRecords ( personCode );

        ResponseEntity response = null;

        if ( l.size() > AcademiaRestController.EMPTY_ACADEMIC_RECORDS_LIST ) {
            response = new ResponseEntity ( l, HttpStatus.OK );

        } else {
            response = new ResponseEntity ( null, HttpStatus.NOT_FOUND );
            
        }

        return response;

    }

}
