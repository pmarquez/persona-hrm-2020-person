
package io.nordstar.personahrm.person.dao;

import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;

import java.util.List;

/**
 * PersonsRepository.java<br><br>
 * Creation Date 2019-09-30 14:59 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p>Rest Controller for all things PERSON</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-30 14:59 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-30 14:59 PT
 */
public interface PersonsRepository {

    //   Persons CRUD
    public void createPerson ( PersonRec company );

    public PersonRec retrievePersonByCode ( int personCode );

    public List<PersonBaseRec> retrievePersons ( );

    public void updatePerson ( int personCode, PersonRec personData );

    public void deletePerson ( int personCode );

}

