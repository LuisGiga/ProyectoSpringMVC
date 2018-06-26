/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luisangel.modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Luis Angel
 */
public class Conectar {
    
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/prueba");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
    
}
