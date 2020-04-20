package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Ruta;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RutaMapper {

    @Select("SELECT nextval('id_ruta')")
    int nextId();

    @Insert("INSERT INTO Ruta (id,puntopartida,puntollegada) VALUES (#{ruta.id}, #{ruta.puntoPartida}, #{ruta.puntoLlegada})")
    void saveRuta(@Param("ruta") Ruta ruta);

    @Update("UPDATE ruta SET puntopartida = #{ruta.puntoPartida}, puntollegada = #{ruta.puntoLlegada} WHERE id = #{ruta.id}")
    void updateRuta(@Param("ruta") Ruta ruta);
}
