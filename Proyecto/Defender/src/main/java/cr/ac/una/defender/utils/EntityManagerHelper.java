/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.utils;

import javax.persistence.*;

/**
 *
 * @author jp015
 */
public class EntityManagerHelper
{

    private static final EntityManagerHelper SINGLENTON = new EntityManagerHelper();
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static
    {
        try
        {
            emf = Persistence.createEntityManagerFactory("Defender");
            em = emf.createEntityManager();
        }
        catch(ExceptionInInitializerError e)
        {
            throw e;
        }
    }

    public static EntityManagerHelper getInstance()
    {

        return SINGLENTON;
    }

    public static EntityManager getManager()
    {
        if(em == null)
        {
            emf = Persistence.createEntityManagerFactory("Defender");
            em = emf.createEntityManager();
        }
        return em;
    }
}
