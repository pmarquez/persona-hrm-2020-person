
package io.nordstar.personahrm.person.web.controller;


//   Standard Libraries Imports
import java.util.ArrayList;
import java.util.List;

//   Third Party Libraries Imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//   FENIX Framework Imports

//   Application Domain Imports
import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import io.nordstar.personahrm.person.web.services.PersonsService;

/**
 * PersonsRestController.java<br><br>
 * Creation Date 2019-09-16 09:40 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p>Rest Controller for all things PERSON</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-16 09:40 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-16 09:40 PT
 */
@RestController
public class PersonsRestController {

    private static final Logger logger = LogManager.getLogger ( PersonsRestController.class );

    //   Controller Constants
    private static final int EMPTY_PERSON_LIST = 0;
    private static final int EMPTY_PERSON_REC  = 0;
    
//   Response Status
    private static final String OPERATION_SUCCESSFUL                            = "PERSONS_001";   //   The requested operation was successfully completed.
    private static final String NO_PERSON_FOUND                                 = "PERSONS_002";   //   Could not find requested person.
    private static final String NO_PERSONS_FOUND                                = "PERSONS_003";   //   The requested list of persons is empty.
    private static final String INVALID_USER_PRIVILEGES                         = "PERSONS_004";   //   User does not have the required privileges for this call.
    private static final String INVALID_AUTHORIZATION_TOKEN                     = "PERSONS_005";   //   Authorization token received is not valid.
    private static final String INTERNAL_ERROR_ENCOUNTERED                      = "PERSONS_006";   //   An internal error was encountered.
    private static final String REQUESTED_PERSON_EXISTS                         = "PERSONS_007";   //   The requested person exists.
    private static final String REQUESTED_PERSON_DOES_NOT_EXIST                 = "PERSONS_008";   //   The requested person does not exist.

    private final PersonsService personsService;

    /**
     * Constructor
     *
     * @param personsService
     */
    public PersonsRestController ( PersonsService personsService ) {
        this.personsService = personsService;
    }

    /**
     * Retrieves a list of persons from storage.
     * @return ResponseRec<List<PersonBaseRec>>
     */
    @GetMapping ( value = "/personsAPI/1.0/persons/persons" )
    public ResponseEntity<List<PersonBaseRec>> personList ( ) {

        List<PersonBaseRec> l = this.personsService.retrievePersons ( );

        ResponseEntity response = null;

        if ( l.size ( ) > PersonsRestController.EMPTY_PERSON_LIST ) {
            response = new ResponseEntity ( l, HttpStatus.OK );
            logger.info ( "personList.response - Status OK" );
        } else {
            response = new ResponseEntity ( l, HttpStatus.NOT_FOUND );
        }

        return response;
    }

    /**
     * Retrieves a single person from storage
     * @param personCode
     * @return ResponseRec<PersonRec>
     */
    @GetMapping ( value = "/personsAPI/1.0/persons/persons/{personCode}" )
    public ResponseEntity<PersonRec> retrievePerson ( @PathVariable int personCode ) {

        PersonRec r = this.personsService.retrievePerson ( personCode );

        ResponseEntity response = null;

        if ( r.getPersonCode ( ) > PersonsRestController.EMPTY_PERSON_REC ) {
            response = new ResponseEntity ( r, HttpStatus.OK );

        } else {
            response = new ResponseEntity ( r, HttpStatus.NOT_FOUND );
            
        }

        return response;

    }

    /**
     * Checks whether a person exists in storage.
     * @param personCode
     * @return ResponseRec<Boolean>
     * @since 1.0
     */
    @GetMapping ( value = "/personsAPI/1.0/persons/exists/{personCode}" )
    public ResponseEntity personExists ( @PathVariable int personCode ) {

        PersonRec r = this.personsService.retrievePerson ( personCode );

        ResponseEntity response = null;

        if ( r.getPersonCode ( ) > PersonsRestController.EMPTY_PERSON_REC ) {
            response = new ResponseEntity ( HttpStatus.FOUND );

        } else {
            response = new ResponseEntity ( HttpStatus.NOT_FOUND );
            
        }
        
        return response;
    }

}
