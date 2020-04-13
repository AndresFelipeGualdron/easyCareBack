package edu.eci.arsw.data.dao.mybatis.mappers;


import edu.eci.arsw.easycare.model.Mascota;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
