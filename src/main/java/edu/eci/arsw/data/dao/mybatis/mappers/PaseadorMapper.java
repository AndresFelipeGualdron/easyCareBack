package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Paseador;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaseadorMapper {

    @Select("SELECT * FROM paseador")
    List<Paseador> getPaseadores();

    @Select("SELECT * FROM paseador")
    List<Paseador> getPaseadoresOrder(@Param("order") String order);

    @Select("SELECT * FROM paseador WHERE documento = #{documento} AND tipoDocumento = #{tDoc}")
    Paseador getPaseador(@Param("documento") String documento, @Param("tDoc") String tDoc);

    @Select("SELECT * FROM paseador WHERE correo = #{correo}")
    Paseador getPaseadorCorreo(@Param("correo") String correo);

    @Insert("INSERT INTO paseador (documento , tipodocumento ,nombre ,correo ,telefono ,password ) VALUES (#{paseador.documento}, #{paseador.tipoDocumento}, #{paseador.nombre}, #{paseador.correo}, #{paseador.telefono}, #{paseador.password})")
    void save(@Param("paseador") Paseador paseador);
}
