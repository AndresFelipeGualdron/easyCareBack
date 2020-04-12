package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Ruta;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RutaMapper {

    @Select("SELECT nextval('id_ruta')")
    int nextId();

    @Insert("INSERT INTO Ruta (id,puntopartida,puntollegada) VALUES (#{ruta.id}, #{ruta.puntoPartida}, #{ruta.puntoLlegada})")
    void saveRuta(@Param("ruta") Ruta ruta);
}
