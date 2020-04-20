package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Cliente;

import java.util.List;

public interface ClienteDAO {

    List<Cliente> getClientes() throws PersistenceException;

    Cliente getCliente(String documento,String tdoc) throws PersistenceException;

    Cliente getCliente(String correo) throws PersistenceException;

    void save(Cliente cliente) throws PersistenceException;

    void updateCliente(Cliente cliente) throws PersistenceException;
}
