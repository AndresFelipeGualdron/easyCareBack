package edu.eci.arsw.data.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaseoEnCursoMapper {


    @Select("SELECT nextval('id_paseoEnCurso')")
    int nextId();


}
