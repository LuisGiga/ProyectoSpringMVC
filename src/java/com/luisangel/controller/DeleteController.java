/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luisangel.controller;

import com.luisangel.modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Luis Angel
 */
public class DeleteController {
    private JdbcTemplate jdbcTemplate;
    public DeleteController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView home(HttpServletRequest request)
    {
      int id=Integer.parseInt(request.getParameter("id"));
      this.jdbcTemplate.update(
              "delete from usuarios "
              + "where"
              + "id=? ",
      id);
      return new ModelAndView("redirect:/home.htm");
    }
    
}
