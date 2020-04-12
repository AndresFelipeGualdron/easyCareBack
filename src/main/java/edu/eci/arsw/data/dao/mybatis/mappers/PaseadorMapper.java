package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.model.Subasta;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaseadorMapper {

    @Select("SELECT * FROM paseador")
    List<Paseador> getPaseadores();

    @Select("SELECT * FROM paseador ORDER BY calificacion DESC")
    List<Paseador> getPaseadoresOrderDesc();

    @Select("SELECT * FROM paseador ORDER BY calificacion ASC")
    List<Paseador> getPaseadoresOrderAsc();

    @Select("SELECT * FROM paseador WHERE documento = #{documento} AND tipoDocumento = #{tDoc}")
    Paseador getPaseador(@Param("documento") String documento, @Param("tDoc") String tDoc);

    @Select("SELECT * FROM paseador WHERE correo = #{correo}")
    Paseador getPaseadorCorreo(@Param("correo") String correo);

    @Insert("INSERT INTO paseador (documento , tipodocumento ,nombre ,correo ,telefono ,password, calificacion ) VALUES (#{paseador.documento}, #{paseador.tipoDocumento}, #{paseador.nombre}, #{paseador.correo}, #{paseador.telefono}, #{paseador.password}, #{paseador.calificacion})")
    void save(@Param("paseador") Paseador paseador);

    @Select("SELECT paseador.documento,paseador.tipodocumento,paseador.nombre,paseador.correo,paseador.telefono,paseador.calificacion FROM paseador,paseador_subasta, subasta WHERE paseador.documento = paseador_subasta.docpaseador AND paseador.tipodocumento = paseador_subasta.tipodocpaseador AND subasta.id = paseador_subasta.idsubasta AND paseador_subasta.idsubasta = #{subasta.id}")
    List<Paseador> getPaseadoresEnSubasta(@Param("subasta") Subasta subasta);

    @Insert("INSERT INTO paseador_subasta (docpaseador,tipodocpaseador,idsubasta) VALUES (#{paseador.documento},#{paseador.tipoDocumento},#{subasta.id})")
    void entrarASubasta(@Param("subasta") Subasta subasta, @Param("paseador") Paseador paseador);
}
