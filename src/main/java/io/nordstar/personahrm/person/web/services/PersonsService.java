package io.nordstar.personahrm.person.web.services;

import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;

import java.util.List;

public interface PersonsService {

//    PERSON CRUD
    public void createPerson ( PersonRec personData );

    public List<PersonBaseRec> retrievePersons ( );

    public List<PersonBaseRec> searchPersons ( );

    public PersonRec retrievePersonByCode ( int personCode );

    public PersonRec updatePerson ( int personCode, PersonRec personData );

    public void deletePerson ( int personCode );

}
