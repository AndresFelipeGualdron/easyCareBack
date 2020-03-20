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
    Cliente getCliente(@Param("documento") String documento, @Param("tdoc") String tdoc);

    @Select("SELECT * FROM cliente WHERE correo = #{correo}")
    Cliente getClienteCorreo(@Param("correo") String correo);

    @Insert("INSERT INTO cliente (documento , tipodocumento ,nombre ,correo ,telefono ,password ) VALUES (#{cliente.documento}, #{cliente.tipoDocumento}, #{cliente.nombre}, #{cliente.correo}, #{cliente.telefono}, #{cliente.password})")
    void save(@Param("cliente") Cliente cliente);

}
