package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Subasta;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubastaMapper {

    @Select("SELECT * FROM subasta WHERE terminada = false")
    List<Subasta> getSubastas();

    @Select("SELECT * FROM subasta WHERE id = #{id}")
    Subasta getSubasta(@Param("id") int id);

    @Select("SELECT nextval('id_subasta')")
    int nextId();

    @Insert("INSERT INTO subasta (id,oferta,creador,idpaseo,nummascotas,permitirmasmascotas) VALUES (#{subasta.id},#{subasta.oferta},#{subasta.creador},#{subasta.idpaseo.id}, #{subasta.numMascotas}, #{subasta.permitirMasMascotas})")
    void save(@Param("subasta") Subasta subasta);

    @Update("UPDATE subasta SET terminada = true WHERE id = #{id}")
    void cerrarSubasta(@Param("id") int id);
}
