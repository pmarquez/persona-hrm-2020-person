package io.nordstar.personahrm.person.services;

import io.nordstar.personahrm.person.dao.PersonDAO;
import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {

    @Autowired
    private PersonDAO personsDAO;

    @Override
    public void createPerson ( PersonRec personData ) {

    }

    /**
     *
     * @return
     */
    @Override
    public List<PersonBaseRec> retrievePersons ( ) {

        List<PersonBaseRec> persons = personsDAO.retrievePersons ( );

        System.out.println ( "Persons.size ( ): " + persons.size ( ) );

        return persons;

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

        PersonRec person = personsDAO.retrievePersonByCode ( personCode );

        return person;
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
