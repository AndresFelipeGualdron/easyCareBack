package edu.eci.arsw.data.dao.mybatis;


import edu.eci.arsw.data.dao.ClienteDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.ClienteMapper;
import edu.eci.arsw.easycare.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisClienteDAO implements ClienteDAO {

    @Autowired
    private ClienteMapper cliente;


    @Override
    public List<Cliente> getClientes() throws PersistenceException{
        try{
            List<Cliente> li = cliente.getClientes();
            if (li.size() == 0) throw new PersistenceException("No hay clientes agregados");
            return li;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }

    }

    @Override
    public Cliente getCliente(String documento, String tdoc) throws PersistenceException{
        try {
            Cliente cli = cliente.getCliente(documento, tdoc);
            if(cli == null) throw new PersistenceException("No se encontro el cliente");
            return cli;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }

    }

    @Override
    public void save(Cliente cliente) throws PersistenceException{
        try{
            this.cliente.save(cliente);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }

    }


    //SET AND GETTERS
    public void setCliente(ClienteMapper cliente){
        this.cliente = cliente;
    }
}
