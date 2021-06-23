/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.geometry.*;
import javafx.scene.shape.*;

/**
 *
 * @author jp015
 */
interface Accion
{

    public void Start();
    public void dect(Circle bullet,int damage);
    public void detectF(Circle bullet,int time);
    public void pausar();
     public void iniciar();
}
