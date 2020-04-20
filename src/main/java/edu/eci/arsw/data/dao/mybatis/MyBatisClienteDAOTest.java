package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.ClienteMapper;
import edu.eci.arsw.easycare.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisClienteDAOTest extends MyBatisClienteDAO{

    @Autowired
    @Qualifier("clientMapperTest")
    private ClienteMapper cliente;


    @Override
    public List<Cliente> getClientes() throws PersistenceException{
        super.setCliente(cliente);
        return super.getClientes();
    }

    @Override
    public Cliente getCliente(String documento, String tdoc) throws PersistenceException{
        super.setCliente(cliente);
        return super.getCliente(documento,tdoc);
    }

    @Override
    public Cliente getCliente(String correo) throws PersistenceException{
        super.setCliente(cliente);
        return super.getCliente(correo);
    }

    @Override
    public void save(Cliente cliente)throws PersistenceException {
        super.setCliente(this.cliente);
        super.save(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) throws PersistenceException {
        super.setCliente(this.cliente);
        super.updateCliente(cliente);
    }
}
