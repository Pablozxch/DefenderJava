/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.clases;

import javafx.beans.property.*;
import javax.xml.bind.annotation.*;

/**
 *
 * author jp015
 */
public class Datos
{

    private String username;
    private String pass;
    private String lvl;
    private String imgUser;
    private String imgBallesta;
    private String imbCastillo;
    private String dinero;
    private String esmeralda;
    private String mVida;
    private String mMana;
    private String lvlFuerza;
    private String lvlAgilidad;
    private String lvlRetroceso;
    private String lvlDDamage;
    private String lvlTiroDoble;
    private String lvlFireBall;
    private String lvlFreeze;
    private String lvlRayo;

    public Datos()
    {
        this.username = "";
        this.pass = "";
        this.lvl = "1";
        this.imgUser = "0";
        this.imgBallesta = "0";
        this.imbCastillo = "0";
        this.dinero = "0";
        this.esmeralda = "0";
        this.mVida = "0";
        this.mMana = "0";
        this.lvlFuerza = "0";
        this.lvlAgilidad = "0";
        this.lvlRetroceso = "0";
        this.lvlDDamage = "0";
        this.lvlTiroDoble = "0";
        this.lvlFireBall = "0";
        this.lvlFreeze = "0";
        this.lvlRayo = "0";

    }

    public Datos(String username , String pass , String lvl , String imgUser , String imgBallesta , String imbCastillo , String dinero , String esmeralda , String mVida , String mMana , String lvlFuerza , String lvlAgilidad , String lvlRetroceso , String lvlDDamage , String lvlTiroDoble , String lvlFireBall , String lvlFreeze , String lvlRayo)
    {
        this.username = username;
        this.pass = pass;
        this.lvl = lvl;
        this.imgUser = imgUser;
        this.imgBallesta = imgBallesta;
        this.imbCastillo = imbCastillo;
        this.dinero = dinero;
        this.esmeralda = esmeralda;
        this.mVida = mVida;
        this.mMana = mMana;
        this.lvlFuerza = lvlFuerza;
        this.lvlAgilidad = lvlAgilidad;
        this.lvlRetroceso = lvlRetroceso;
        this.lvlDDamage = lvlDDamage;
        this.lvlTiroDoble = lvlTiroDoble;
        this.lvlFireBall = lvlFireBall;
        this.lvlFreeze = lvlFreeze;
        this.lvlRayo = lvlRayo;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPass()
    {
        return pass;
    }

    public void setLvl(String lvl)
    {
        this.lvl = lvl;
    }

    public String getLvl()
    {
        return lvl;
    }

    public void setImgUser(String imgUser)
    {
        this.imgUser = imgUser;
    }

    public String getImgUser()
    {
        return imgUser;
    }

    public void setImgBallesta(String imgBallesta)
    {
        this.imgBallesta = imgBallesta;
    }

    public String getImgBallesta()
    {
        return imgBallesta;
    }

    public void setImbCastillo(String imbCastillo)
    {
        this.imbCastillo = imbCastillo;
    }

    public String getImbCastillo()
    {
        return imbCastillo;
    }

    public void setDinero(String dinero)
    {
        this.dinero = dinero;
    }

    public String getDinero()
    {
        return dinero;
    }

    public void setEsmeralda(String esmeralda)
    {
        this.esmeralda = esmeralda;
    }

    public String getEsmeralda()
    {
        return esmeralda;
    }

    public void setmVida(String mVida)
    {
        this.mVida = mVida;
    }

    public String getmVida()
    {
        return mVida;
    }

    public void setmMana(String mMana)
    {
        this.mMana = mMana;
    }

    public String getmMana()
    {
        return mMana;
    }

    public void setLvlFuerza(String lvlFuerza)
    {
        this.lvlFuerza = lvlFuerza;
    }

    public String getLvlFuerza()
    {
        return lvlFuerza;
    }

    public void setLvlAgilidad(String lvlAgilidad)
    {
        this.lvlAgilidad = lvlAgilidad;
    }

    public String getLvlAgilidad()
    {
        return lvlAgilidad;
    }

    public void setLvlRetroceso(String lvlRetroceso)
    {
        this.lvlRetroceso = lvlRetroceso;
    }

    public String getLvlRetroceso()
    {
        return lvlRetroceso;
    }

    public void setLvlDDamage(String lvlDDamage)
    {
        this.lvlDDamage = lvlDDamage;
    }

    public String getLvlDDamage()
    {
        return lvlDDamage;
    }

    public void setLvlTiroDoble(String lvlTiroDoble)
    {
        this.lvlTiroDoble = lvlTiroDoble;
    }

    public String getLvlTiroDoble()
    {
        return lvlTiroDoble;
    }

    public void setLvlFireBall(String lvlFireBall)
    {
        this.lvlFireBall = lvlFireBall;
    }

    public String getLvlFireBall()
    {
        return lvlFireBall;
    }

    public void setLvlFreeze(String lvlFreeze)
    {
        this.lvlFreeze = lvlFreeze;
    }

    public String getLvlFreeze()
    {
        return lvlFreeze;
    }

    public void setLvlRayo(String lvlRayo)
    {
        this.lvlRayo = lvlRayo;
    }

    public String getLvlRayo()
    {
        return lvlRayo;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos{username=").append(username);
        sb.append(", pass=").append(pass);
        sb.append(", lvl=").append(lvl);
        sb.append(", imgUser=").append(imgUser);
        sb.append(", imgBallesta=").append(imgBallesta);
        sb.append(", imbCastillo=").append(imbCastillo);
        sb.append(", dinero=").append(dinero);
        sb.append(", esmeralda=").append(esmeralda);
        sb.append(", mVida=").append(mVida);
        sb.append(", mMana=").append(mMana);
        sb.append(", lvlFuerza=").append(lvlFuerza);
        sb.append(", lvlAgilidad=").append(lvlAgilidad);
        sb.append(", lvlRetroceso=").append(lvlRetroceso);
        sb.append(", lvlDDamage=").append(lvlDDamage);
        sb.append(", lvlTiroDoble=").append(lvlTiroDoble);
        sb.append(", lvlFireBall=").append(lvlFireBall);
        sb.append(", lvlFreeze=").append(lvlFreeze);
        sb.append(", lvlRayo=").append(lvlRayo);
        sb.append('}');
        return sb.toString();
    }

}
