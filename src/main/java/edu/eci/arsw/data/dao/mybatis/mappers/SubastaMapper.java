package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseo;
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

    @Insert("INSERT INTO subasta (id,oferta,creador,idpaseo,nummascotas,permitirmasmascotas) VALUES (#{subasta.id},#{subasta.oferta},#{subasta.creador.correo},#{subasta.paseo.id}, #{subasta.numMascotas}, #{subasta.permitirMasMascotas})")
    void save(@Param("subasta") Subasta subasta);

    @Update("UPDATE subasta SET terminada = true WHERE id = #{id}")
    void cerrarSubasta(@Param("id") int id);

    @Select("SELECT * FROM cliente WHERE correo = (select creador from subasta where id = #{subasta.id})")
    Cliente getCreador(@Param("subasta") Subasta subasta);

    @Select("SELECT * FROM paseo WHERE id = (select idpaseo from subasta where id = #{subasta.id})")
    Paseo getPaseo(@Param("subasta") Subasta subasta);

    @Update("UPDATE subasta SET oferta = #{subasta.oferta}, nummascotas = #{subasta.numMascotas}, permitirmasmascotas = #{subasta.permitirMasMascotas} WHERE id = #{subasta.id}")
    void updateSubasta(@Param("subasta") Subasta subasta);
}
