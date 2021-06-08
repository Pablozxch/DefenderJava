/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.scene.image.*;
import javafx.scene.layout.*;

/**
 *
 * @author jp015
 */
public class Mapa
{
    private int [][]mapa;

    public Mapa()
    {
    }

    public Mapa(int[][] mapa)
    {
        this.mapa = mapa;
    }

    public int[][] getMapa()
    {
        return mapa;
    }

    public void setMapa(int[][] mapa)
    {
        this.mapa = mapa;
    }
    public void pintar(GridPane grid, Monstruo mostruo)
    {
       
    }
}
