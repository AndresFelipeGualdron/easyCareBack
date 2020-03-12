package edu.eci.arsw.data.dao;

import edu.eci.arsw.easycare.model.Cliente;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClienteDAO {

    List<Cliente> getClientes();

    Cliente getCliente(String documento,String tdoc);

    void save(Cliente cliente);
}
