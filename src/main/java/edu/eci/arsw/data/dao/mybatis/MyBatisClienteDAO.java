package edu.eci.arsw.data.dao.mybatis;


import edu.eci.arsw.data.dao.ClienteDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.ClienteMapper;
import edu.eci.arsw.easycare.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class MyBatisClienteDAO implements ClienteDAO {

    @Autowired
    private ClienteMapper cliente;


    @Override
    public List<Cliente> getClientes() {
        return cliente.getClientes();
    }

    @Override
    public Cliente getCliente(String documento, String tdoc) {
        return cliente.getCliente(documento, tdoc);
    }

    @Override
    public void save(Cliente cliente) {
        this.cliente.save(cliente);
    }
}
