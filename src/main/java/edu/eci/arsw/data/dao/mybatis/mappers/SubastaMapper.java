package edu.eci.arsw.data.dao.mybatis.mappers;

import edu.eci.arsw.easycare.model.Subasta;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubastaMapper {

    @Select("SELECT * FROM subasta")
    List<Subasta> getSubastas();

    @Select("SELECT * FROM subasta WHERE id = #{id}")
    Subasta getSubasta(@Param("id") int id);

    @Insert("")
    void save(@Param("subasta") Subasta subasta);
}
