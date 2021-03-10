package io.nordstar.personahrm.person.services;

import io.nordstar.personahrm.person.dao.AcademiaDAO;
import io.nordstar.personahrm.person.model.education.AcademiaBaseRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademiaServiceImpl implements AcademiaService {

    @Autowired
    private AcademiaDAO academiaDAO;

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
     * @param codPerson
     * @return
     */
    @Override
    public List<AcademiaBaseRec> retrieveAcademicRecords ( int codPerson ) {

        List<AcademiaBaseRec> academia = academiaDAO.retrieveAcademicRecords ( codPerson );

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
}
