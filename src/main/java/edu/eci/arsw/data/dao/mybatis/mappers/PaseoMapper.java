package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Paseo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaseoMapper {
    @Select("SELECT * FROM paseo")
    List<Paseo> getPaseos();

    @Select("SELECT * FROM paseo WHERE id = #{id}")
    Paseo getPaseo(@Param("id") int id);

    @Select("SELECT nextval('id_paseo')")
    int nexId();

    @Insert("INSERT INTO Paseo (id,duracion,precio,especificaciones,idruta) VALUES (#{paseo.id},#{paseo.duracion},#{paseo.precio},#{paseo.especificaciones},#{paseo.ruta.id})")
    void save(@Param("paseo") Paseo paseo);

    @Update("UPDATE paseo SET duracion = #{paseo.duracion}, precio = #{paseo.precio}, especificaciones = #{paseo.especificaciones} WHERE id = #{paseo.id}")
    void update(@Param("paseo") Paseo paseo);
}
