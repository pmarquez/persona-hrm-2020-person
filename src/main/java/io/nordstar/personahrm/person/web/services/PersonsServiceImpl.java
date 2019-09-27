package io.nordstar.personahrm.person.web.services;

import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {

    @Override
    public void createPerson ( PersonRec personData ) {

    }

    /**
     *
     * @return
     */
    @Override
    public List<PersonBaseRec> retrievePersons ( ) {
        return new ArrayList<PersonBaseRec> ( );
    }

    /**
     *
     * @return
     */
    @Override
    public List<PersonBaseRec> searchPersons ( ) {
        return new ArrayList<PersonBaseRec> ( );
    }

    /**
     *
     * @param personCode
     * @return
     */
    @Override
    public PersonRec retrievePersonByCode ( int personCode ) {
        return null;
    }

    @Override
    public PersonRec updatePerson ( int personCode, PersonRec personData ) {
        return null;
    }

    /**
     *
     * @param personCode
     * @return
     */
    @Override
    public void deletePerson ( int personCode ) {

    }

}
