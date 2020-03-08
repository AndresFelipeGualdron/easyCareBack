package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Paseador;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaseadorMapper {

    @Select("SELECT * FROM paseador")
    List<Paseador> getPaseadores();

    @Select("SELECT * FROM paseador WHERE documento = #{documento} AND tipoDocumento = #{tDoc}")
    Paseador getPaseador(String documento, String tDoc);

    @Insert("")
    void save(Paseador paseador);
}
