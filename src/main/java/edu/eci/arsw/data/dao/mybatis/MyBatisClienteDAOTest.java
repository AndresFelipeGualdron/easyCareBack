package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.ClienteDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.ClienteMapper;
import edu.eci.arsw.easycare.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisClienteDAOTest implements ClienteDAO {

    @Autowired
    @Qualifier("clientMapperTest")
    private ClienteMapper cliente;


    @Override
    public List<Cliente> getClientes() {
        return cliente.getClientes();
    }

    @Override
    public Cliente getCliente(String documento, String tdoc) {
        return cliente.getCliente(documento,tdoc);
    }

    @Override
    public void save(Cliente cliente) {
        this.cliente.save(cliente);
    }
}
