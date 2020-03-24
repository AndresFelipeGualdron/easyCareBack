package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Paseo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaseoMapper {
    @Select("SELECT * FROM paseo")
    List<Paseo> getPaseos();

    @Select("SELECT * FROM paseo WHERE id = #{id}")
    Paseo getPaseo(@Param("id") int id);

    @Insert("")
    void save(@Param("paseo") Paseo paseo);
}
