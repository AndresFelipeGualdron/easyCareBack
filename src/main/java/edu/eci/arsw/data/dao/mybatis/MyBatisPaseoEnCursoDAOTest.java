package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.PaseoEnCursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyBatisPaseoEnCursoDAOTest extends MyBatisPaseoEnCursoDAO{

    @Autowired
    @Qualifier("paseoEnCursoMapperTest")
    PaseoEnCursoMapper paseoEnCursoMapper;

    @Override
    public int nextId() throws PersistenceException {
        super.setPaseoEnCursoMapper(this.paseoEnCursoMapper);
        return super.nextId();
    }
}
