package edu.eci.arsw.easycare.service;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;

public class ExcepcionServiciosEasyCare extends Exception {

    public ExcepcionServiciosEasyCare(String string, PersistenceException e){
        e.printStackTrace();
    }
}
