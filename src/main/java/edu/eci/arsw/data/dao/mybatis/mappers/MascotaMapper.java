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

    @Select("SELECT * FROM mascota WHERE id = #{id}")
    Mascota getMascota(@Param("id") Long id);

    @Insert("")
    void save(@Param("mascota") Mascota mascota);
}
