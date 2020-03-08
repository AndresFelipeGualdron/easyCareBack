package edu.eci.arsw.data.dao.mybatis.mappers;


import edu.eci.arsw.easycare.model.Cliente;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClienteMapper {

    @Select("SELECT * FROM cliente")
    List<Cliente> getClientes();

    @Select("SELECT * FROM cliente WHERE documento = #{documento} AND tipoDocumento = #{tdoc}")
    Cliente getCliente(@Param("documento") Long documento, @Param("tdoc") String tdoc);

    @Insert("")
    void save(@Param("cliente") Cliente cliente);

}
