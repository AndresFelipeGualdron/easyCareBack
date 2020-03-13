package edu.eci.arsw.easycare.service;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;

public class ExceptionServiciosEasyCare extends Exception {
    public ExceptionServiciosEasyCare(String message, PersistenceException e) {

    }
}
