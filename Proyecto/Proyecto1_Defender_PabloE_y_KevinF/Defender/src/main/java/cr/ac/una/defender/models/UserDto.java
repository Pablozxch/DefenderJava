/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.models;

import cr.ac.una.defender.clases.*;
import javafx.beans.property.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jp015
 */
public class UserDto
{

    @XmlTransient
    public SimpleStringProperty id;
    @XmlTransient
    public SimpleStringProperty username;
    @XmlTransient
    public SimpleStringProperty pass;
    @XmlTransient
    public SimpleStringProperty lvl;
    @XmlTransient
    public SimpleStringProperty imgUser;
    @XmlTransient
    public SimpleStringProperty imgBallesta;
    @XmlTransient
    public SimpleStringProperty imbCastillo;
    @XmlTransient
    public SimpleStringProperty dinero;
    @XmlTransient
    public SimpleStringProperty esmeralda;
    @XmlTransient
    public SimpleStringProperty mVida;
    @XmlTransient
    public SimpleStringProperty mMana;
    @XmlTransient
    public SimpleStringProperty lvlFuerza;
    @XmlTransient
    public SimpleStringProperty lvlAgilidad;
    @XmlTransient
    public SimpleStringProperty lvlRetroceso;
    @XmlTransient
    public SimpleStringProperty lvlDDamage;
    @XmlTransient
    public SimpleStringProperty lvlTiroDoble;
    @XmlTransient
    public SimpleStringProperty lvlFireBall;
    @XmlTransient
    public SimpleStringProperty lvlFreeze;
    @XmlTransient
    public SimpleStringProperty lvlRayo;

    public UserDto()
    {
        this.id = new SimpleStringProperty();
        this.username = new SimpleStringProperty();
        this.pass = new SimpleStringProperty();
        this.lvl = new SimpleStringProperty();
        this.imgUser = new SimpleStringProperty();
        this.imgBallesta = new SimpleStringProperty();
        this.imbCastillo = new SimpleStringProperty();
        this.dinero = new SimpleStringProperty();
        this.esmeralda = new SimpleStringProperty();
        this.mVida = new SimpleStringProperty();
        this.mMana = new SimpleStringProperty();
        this.lvlFuerza = new SimpleStringProperty();
        this.lvlAgilidad = new SimpleStringProperty();
        this.lvlRetroceso = new SimpleStringProperty();
        this.lvlDDamage = new SimpleStringProperty();
        this.lvlTiroDoble = new SimpleStringProperty();
        this.lvlFireBall = new SimpleStringProperty();
        this.lvlFreeze = new SimpleStringProperty();
        this.lvlRayo = new SimpleStringProperty();

    }

    public UserDto(User user)
    {
        this();
        this.id.set(user.getUserId().toString());
        this.username.set(user.getUserUsername());
        this.pass.set(user.getUserPass());
        this.lvl.set(user.getUserLvl().toString());
        this.imgUser.set(user.getUserImguser().toString());
        this.imgBallesta.set(user.getUserImgballesta().toString());
        this.imbCastillo.set(user.getUserImgballesta().toString());
        this.dinero.set(user.getUserDinero().toString());
        this.esmeralda.set(user.getUserEsmeraldas().toString());
        this.mVida.set(user.getUserMvida().toString());
        this.mMana.set(user.getUserMmana().toString());
        this.lvlFuerza.set(user.getUserLvlfuerza().toString());
        this.lvlAgilidad.set(user.getUserLvlagilidad().toString());
        this.lvlRetroceso.set(user.getUserLvlretroceso().toString());
        this.lvlDDamage.set(user.getUserLvldddamage().toString());
        this.lvlTiroDoble.set(user.getUserLvltirodoble().toString());
        this.lvlFireBall.set(user.getUserSfireball().toString());
        this.lvlFreeze.set(user.getUserSfreeze().toString());
        this.lvlRayo.set(user.getUserSrayo().toString());
    }

    public void setId(Long id)
    {
        this.id.set(id.toString());
    }

    public Long getId()
    {
        if(id.get() != null && !id.get().isEmpty())
        {
            return Long.valueOf(id.get());
        }
        else
        {
            return null;
        }
    }

    public void setUsername(String username)
    {
        this.username.set(username);
    }

    public String getUsername()
    {
        return username.get();
    }

    public void setPass(String pass)
    {
        this.pass.set(pass);
    }

    public String getPass()
    {
        return pass.get();
    }

    public void setLvl(String lvl)
    {
        this.lvl.set(lvl);
    }

    public Long getLvl()
    {
        if(lvl.get() != null && !lvl.get().isEmpty())
        {
            return Long.valueOf(lvl.get());
        }
        else
        {
            return 1L;
        }
    }

    public void setImgUser(String imgUser)
    {
        this.imgUser.set(imgUser);
    }

    public Long getImgUser()
    {
        if(imgUser.get() != null && !imgUser.get().isEmpty())
        {
            return Long.valueOf(imgUser.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setImgBallesta(String imgBallesta)
    {
        this.imgBallesta.set(imgBallesta);
    }

    public Long getImgBallesta()
    {
        if(imgBallesta.get() != null && !imgBallesta.get().isEmpty())
        {
            return Long.valueOf(imgBallesta.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setImbCastillo(String imbCastillo)
    {
        this.imbCastillo.set(imbCastillo);
    }

    public Long getImbCastillo()
    {
        if(imbCastillo.get() != null && !imbCastillo.get().isEmpty())
        {
            return Long.valueOf(imbCastillo.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setDinero(String dinero)
    {
        this.dinero.set(dinero);
    }

    public Long getDinero()
    {
        if(dinero.get() != null && !dinero.get().isEmpty())
        {
            return Long.valueOf(dinero.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setEsmeralda(String esmeralda)
    {
        this.esmeralda.set(esmeralda);
    }

    public Long getEsmeralda()
    {
        if(esmeralda.get() != null && !esmeralda.get().isEmpty())
        {
            return Long.valueOf(esmeralda.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setmVida(String mVida)
    {
        this.mVida.set(mVida);
    }

    public Long getmVida()
    {
        if(mVida.get() != null && !mVida.get().isEmpty())
        {
            return Long.valueOf(mVida.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setmMana(String mMana)
    {
        this.mMana.set(mMana);
    }

    public Long getmMana()
    {
        if(mMana.get() != null && !mMana.get().isEmpty())
        {
            return Long.valueOf(mMana.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlFuerza(String lvlFuerza)
    {
        this.lvlFuerza.set(lvlFuerza);
    }

    public Long getLvlFuerza()
    {
        if(dinero.get() != null && !lvlFuerza.get().isEmpty())
        {
            return Long.valueOf(lvlFuerza.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlAgilidad(String lvlAgilidad)
    {
        this.lvlAgilidad.set(lvlAgilidad);
    }

    public Long getLvlAgilidad()
    {
        if(lvlAgilidad.get() != null && !lvlAgilidad.get().isEmpty())
        {
            return Long.valueOf(lvlAgilidad.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlRetroceso(String lvlRetroceso)
    {
        this.lvlRetroceso.set(lvlRetroceso);
    }

    public Long getLvlRetroceso()
    {
        if(lvlRetroceso.get() != null && !lvlRetroceso.get().isEmpty())
        {
            return Long.valueOf(lvlRetroceso.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlDDamage(String lvlDDamage)
    {
        this.lvlDDamage.set(lvlDDamage);
    }

    public Long getLvlDDamage()
    {
        if(lvlDDamage.get() != null && !lvlDDamage.get().isEmpty())
        {
            return Long.valueOf(lvlDDamage.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlTiroDoble(String lvlTiroDoble)
    {
        this.lvlTiroDoble.set(lvlTiroDoble);
    }

    public Long getLvlTiroDoble()
    {
        if(lvlTiroDoble.get() != null && !lvlTiroDoble.get().isEmpty())
        {
            return Long.valueOf(lvlTiroDoble.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlFireBall(String lvlFireBall)
    {
        this.lvlFireBall.set(lvlFireBall);
    }

    public Long getLvlFireBall()
    {
        if(lvlFireBall.get() != null && !lvlFireBall.get().isEmpty())
        {
            return Long.valueOf(lvlFireBall.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlFreeze(String lvlFreeze)
    {
        this.lvlFreeze.set(lvlFreeze);
    }

    public Long getLvlFreeze()
    {
        if(lvlFreeze.get() != null && !lvlFreeze.get().isEmpty())
        {
            return Long.valueOf(lvlFreeze.get());
        }
        else
        {
            return 0L;
        }
    }

    public void setLvlRayo(String lvlRayo)
    {
        this.lvlRayo.set(lvlRayo);
    }

    public Long getLvlRayo()
    {
        if(lvlRayo.get() != null && !lvlRayo.get().isEmpty())
        {
            return Long.valueOf(lvlRayo.get());
        }
        else
        {
            return 0L;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("UserDto{id=").append(id);
        sb.append(", username=").append(username);
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
