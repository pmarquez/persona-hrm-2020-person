package io.nordstar.personahrm.person.services;

import io.nordstar.personahrm.person.dao.EducationDAO;
import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import io.nordstar.personahrm.person.model.education.CertificationRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationDAO educationDAO;

    /**
     * [C]
     *
     * @param data
     */
    @Override
    public void createAcademicRecord(AcademiaBaseRec data) {

    }

    /**
     * [R]
     *
     * @param personCode
     * @return
     */
    @Override
    public List<AcademiaBaseRec> retrieveAcademicRecords ( int personCode ) {

        List<AcademiaBaseRec> academia = educationDAO.retrieveAcademicRecords ( personCode );

        System.out.println ( "Academia.size ( ): " + academia.size ( ) );

        return academia;
    }

    /**
     * [U]
     *
     * @param academiaCode
     * @param data
     * @return
     */
    @Override
    public int updateAcademicRecord(int academiaCode, AcademiaBaseRec data) {
        return 0;
    }

    /**
     * [D]
     *
     * @param academiaCode
     * @return
     */
    @Override
    public int deleteAcademicRecord(int academiaCode) {
        return 0;
    }

    /**
     * [R]
     *
     * @param personCode
     * @return
     */
    @Override
    public List<CertificationRec> retrieveCertifications ( int personCode ) {

        List<CertificationRec> certifications = educationDAO.retrieveCertifications ( personCode );

       return certifications;
    }
}
