package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.PaseoEnCursoDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.PaseoEnCursoMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisPaseoEnCursoDAO implements PaseoEnCursoDAO {

    @Autowired
    PaseoEnCursoMapper paseoEnCursoMapper;


    @Override
    public int nextId() throws PersistenceException {
        return this.paseoEnCursoMapper.nextId();
    }


    public void setPaseoEnCursoMapper(PaseoEnCursoMapper paseoEnCursoMapper){
        this.paseoEnCursoMapper = paseoEnCursoMapper;
    }
}
