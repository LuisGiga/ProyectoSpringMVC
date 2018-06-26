/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luisangel.controller;

import com.luisangel.modelos.Conectar;
import com.luisangel.modelos.Usuarios;
import com.luisangel.modelos.UsuariosValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Luis Angel
 */

@Controller
@RequestMapping("edit.htm")

public class EditController {
    
    UsuariosValidar usuariosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public EditController()
    {
        this.usuariosValidar=new UsuariosValidar();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    } 
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request)
    {
      ModelAndView mav=new ModelAndView();
      int id=Integer.parseInt(request.getParameter("id"));
      Usuarios datos=this.selectUsuario(id);
      mav.setViewName("edit");
      mav.addObject("usuarios", new Usuarios(id, datos.getNombre(), datos.getCorreo(),datos.getTelefono()));
      return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
            (
                    @ModelAttribute("usuarios")Usuarios u,
                    BindingResult result,
                    SessionStatus status,
                    HttpServletRequest request
            )
            {
                this.usuariosValidar.validate(u, result);
                if (result.hasErrors()) 
                {
                    ModelAndView mav=new ModelAndView();
                    int id=Integer.parseInt(request.getParameter("id"));
                    Usuarios datos=this.selectUsuario(id);
                    mav.setViewName("edit");
                    mav.addObject("usuarios",  new Usuarios(id, datos.getNombre(), datos.getCorreo(),datos.getTelefono()));
                    return mav;
                }else
                {
                    int id=Integer.parseInt(request.getParameter("id"));
                    this.jdbcTemplate.update(
                         "update usuarios"
                            +  "set nombre=?,"
                            +  "correo=?,"
                            +  "telefono=?"
                            +  "where "
                            +  "id=? ",
                    u.getNombre(), u.getCorreo(), u.getTelefono(),id);
                    return new ModelAndView("redirect:/home.htm");
                }
            }
    
    
    public Usuarios selectUsuario(int id)
    {
        final Usuarios user= new Usuarios();
        String quer="SELECT * FROM usuario WHERE id='"+id+"'";
        return (Usuarios) jdbcTemplate.query
        (quer, new ResultSetExtractor<Usuarios>() 
        {
          public Usuarios extractData(ResultSet rs) throws SQLException, DataAccessException{
              if(rs.next()){
                 user.setNombre(rs.getString("nombre"));
                 user.setCorreo(rs.getString("correo"));
                 user.setTelefono(rs.getString("telefono"));
              }
              return user;
          }  
        }
          );
        }
    
}
