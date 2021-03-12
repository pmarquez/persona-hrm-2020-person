package io.nordstar.personahrm.person.services;

import io.nordstar.personahrm.person.dao.EducationDAO;
import io.nordstar.personahrm.person.dao.PersonDAO;
import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import io.nordstar.personahrm.person.model.education.CertificationRec;
import io.nordstar.personahrm.person.model.education.SkillRec;
import io.nordstar.personahrm.person.model.person.PersonBaseRec;
import io.nordstar.personahrm.person.model.person.PersonRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {

    @Autowired
    private PersonDAO    personsDAO;

    @Autowired
    private EducationDAO educationDAO;

    @Override
    public void createPerson ( PersonRec personData ) {

    }

    /**
     * Retrieves all persons as List<PersonBaseRec>
     * @return
     */
    @Override
    public List<PersonBaseRec> retrievePersons ( ) {

        List<PersonBaseRec> persons = personsDAO.retrievePersons ( );

        System.out.println ( "Persons.size ( ): " + persons.size ( ) );

        return persons;

    }

    /**
     * Retrieves a single person as PersonRec
     * @param personCode
     * @return
     */
    @Override
    public PersonRec retrievePersonByCode ( int personCode ) {

        PersonRec              person          = personsDAO.retrievePersonByCode      ( personCode               );

        List<AcademiaBaseRec>  academia        = educationDAO.retrieveAcademicRecords ( person.getPersonCode ( ) );
        List<CertificationRec> certifications  = educationDAO.retrieveCertifications  ( person.getPersonCode ( ) );
        List<SkillRec>         skills          = educationDAO.retrieveSkills          ( person.getPersonCode ( ) );

        person.setAcademia       ( academia       );
        person.setCertifications ( certifications );
        person.setSkills         ( skills         );

        return person;
    }

    /**
     *
     * @return
     */
    @Override
    public List<PersonBaseRec> searchPersons ( ) {
        return new ArrayList<PersonBaseRec> ( );
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
