/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.services;

import cr.ac.una.defender.models.*;
import cr.ac.una.defender.models.UserDto;
import cr.ac.una.defender.utils.*;
import java.util.logging.*;
import javax.persistence.*;

/**
 *
 * @author jp015
 */
public class UserService
{

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;  //se encarga del commit , rollback

    public Respuesta getUser(Long id)
    {
        try
        {
            Query gryUser = em.createNamedQuery("User.findByUserId" , User.class);
            gryUser.setParameter("id" , id);

            return new Respuesta(true , "" , "" , "User" , new UserDto((User) gryUser.getSingleResult()));

        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existe un usuario con el codigo ingresado." , "getUser NoResultException");

        }
        catch(NonUniqueResultException ex)
        {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE , "Ocurrio un error al consultar el usuario" , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el usuario." , "getUser  NonUniqueResultException ");

        }
        catch(Exception ex)
        {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE , "Error obteniendo el deporte [" + id + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta getUser(String userUsername , String userPass)
    {
        try
        {
            Query gryUser = em.createNamedQuery("User.findByUsernmaeandPass" , User.class);
            gryUser.setParameter("userUsername" , userUsername);
            gryUser.setParameter("userPass" , userPass);
            return new Respuesta(true , "" , "" , "both" , new UserDto((User) gryUser.getSingleResult()));

        }
        catch(NoResultException ex)
        {
            return new Respuesta(false , "No existe un usuario con el codigo ingresado." , "getUser NoResultException");

        }
        catch(NonUniqueResultException ex)
        {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE , "Ocurrio un error al consultar el usuario" , ex);
            return new Respuesta(false , "Ocurrio un error al consultar el usuario." , "getUser  NonUniqueResultException ");

        }
        catch(Exception ex)
        {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE , "Error obteniendo el deporte [" + userUsername + "]" , ex);
            return new Respuesta(false , "Error obteniendo el deporte ." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta guardarUser(UserDto userDto)
    {
        try
        {
            et = em.getTransaction();
            et.begin();
            User user;
            
            if(userDto.getId()!= null && userDto.getId() > 0)
            {
                user = em.find(User.class , userDto.getId());
                if(user == null)
                {
                    et.rollback();
                    return new Respuesta(false , "No se encontro el user a modificar" , "guardarUser NoResultExteption");
                }
                user.actualizarUser(userDto);
                user = em.merge(user);
            }
            else
            {

                user = new User(userDto);
                em.persist(user);
            }
            et.commit();
            return new Respuesta(true , "" , "" , "User" , new UserDto(user));
        }
        catch(Exception ex)
        {
            et.rollback();
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE , "Error guardando el user." , ex);
            return new Respuesta(false , "Error guardando el user." , "guardarUser " + ex.getMessage());
        }
    }

}
