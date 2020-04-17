package edu.eci.arsw.data.dao.mybatis.mappers;


import edu.eci.arsw.easycare.model.Mascota;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MascotaMapper {

    @Select("SELECT * FROM mascota")
    List<Mascota> getMascotas();

    @Select("SELECT * FROM mascota WHERE doccliente = #{documento} AND tipodoccliente = #{tipoDocumento}")
    List<Mascota> getMascotasCliente(@Param("documento") String documento, @Param("tipoDocumento") String tipoDocumento);

    @Select("SELECT * FROM mascota WHERE id = #{id}")
    Mascota getMascota(@Param("id") int id);

    @Select("SELECT nextval('id_mascota')")
    int nextId();

    @Insert("INSERT INTO mascota (id,nombre,raza,edad,genero,doccliente,tipodoccliente,docpaseador,tipodocpaseador,idpaseoencurso) VALUES (#{mascota.id},#{mascota.nombre},#{mascota.raza},#{mascota.edad},#{mascota.genero},#{mascota.cliente.documento},#{mascota.cliente.tipoDocumento},null,null,null)")
    void save(@Param("mascota") Mascota mascota);

    @Update("UPDATE mascota SET nombre = #{mascota.nombre}, raza = #{mascota.raza}, edad = #{mascota.edad}, genero = #{mascota.genero}, doccliente = #{mascota.cliente.documento}, tipodoccliente = #{mascota.cliente.tipoDocumento} WHERE id = #{mascota.id}")
    void update(@Param("mascota") Mascota mascota);

    @Delete("DELETE FROM mascota WHERE id = #{id}")
    void delete(@Param("id") int id);
}
