package io.nordstar.personahrm.person.web.services;

import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {

    @Override
    public List<PersonBaseRec> retrievePersons ( ) {
        return null;
    }

    @Override
    public PersonRec retrievePerson ( int personCode ) {
        return null;
    }

}
