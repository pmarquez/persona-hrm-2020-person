package io.nordstar.personahrm.person.web.services;

import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;

import java.util.List;

public interface PersonsService {

    public List<PersonBaseRec> retrievePersons ( );

    public PersonRec retrievePerson ( int personCode );

}
