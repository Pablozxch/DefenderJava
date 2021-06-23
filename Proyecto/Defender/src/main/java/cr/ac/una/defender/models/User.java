/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.defender.models;

import java.io.*;
import java.math.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jp015
 */
@Entity
@Table(name = "DEF_USER" , catalog = "" , schema = "UNA")
@XmlRootElement
@NamedQueries(
          {
              @NamedQuery(name = "User.findAll" , query = "SELECT u FROM User u") ,
              @NamedQuery(name = "User.findByUserId" , query = "SELECT u FROM User u WHERE u.userId = :userId") ,
              @NamedQuery(name = "User.findByUserUsername" , query = "SELECT u FROM User u WHERE u.userUsername = :userUsername") ,
              @NamedQuery(name = "User.findByUserPass" , query = "SELECT u FROM User u WHERE u.userPass = :userPass") ,
              @NamedQuery(name = "User.findByUsernmaeandPass" , query = "SELECT u FROM User u WHERE u.userUsername = :userUsername and u.userPass = :userPass")

//    @NamedQuery(name = "User.findByUserLvl" , query = "SELECT u FROM User u WHERE u.userLvl = :userLvl") ,
//    @NamedQuery(name = "User.findByUserImguser" , query = "SELECT u FROM User u WHERE u.userImguser = :userImguser") ,
//    @NamedQuery(name = "User.findByUserImgballesta" , query = "SELECT u FROM User u WHERE u.userImgballesta = :userImgballesta") ,
//    @NamedQuery(name = "User.findByUserImgcastillo" , query = "SELECT u FROM User u WHERE u.userImgcastillo = :userImgcastillo") ,
//    @NamedQuery(name = "User.findByUserDinero" , query = "SELECT u FROM User u WHERE u.userDinero = :userDinero") ,
//    @NamedQuery(name = "User.findByUserEsmeraldas" , query = "SELECT u FROM User u WHERE u.userEsmeraldas = :userEsmeraldas") ,
//    @NamedQuery(name = "User.findByUserMvida" , query = "SELECT u FROM User u WHERE u.userMvida = :userMvida") ,
//    @NamedQuery(name = "User.findByUserMmana" , query = "SELECT u FROM User u WHERE u.userMmana = :userMmana") ,
//    @NamedQuery(name = "User.findByUserLvlfuerza" , query = "SELECT u FROM User u WHERE u.userLvlfuerza = :userLvlfuerza") ,
//    @NamedQuery(name = "User.findByUserLvlagilidad" , query = "SELECT u FROM User u WHERE u.userLvlagilidad = :userLvlagilidad") ,
//    @NamedQuery(name = "User.findByUserLvlretroceso" , query = "SELECT u FROM User u WHERE u.userLvlretroceso = :userLvlretroceso") ,
//    @NamedQuery(name = "User.findByUserLvldddamage" , query = "SELECT u FROM User u WHERE u.userLvldddamage = :userLvldddamage") ,
//    @NamedQuery(name = "User.findByUserLvltirodoble" , query = "SELECT u FROM User u WHERE u.userLvltirodoble = :userLvltirodoble") ,
//    @NamedQuery(name = "User.findByUserSfireball" , query = "SELECT u FROM User u WHERE u.userSfireball = :userSfireball") ,
//    @NamedQuery(name = "User.findByUserSfreeze" , query = "SELECT u FROM User u WHERE u.userSfreeze = :userSfreeze") ,
//    @NamedQuery(name = "User.findByUserSrayo" , query = "SELECT u FROM User u WHERE u.userSrayo = :userSrayo")
          })
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "DEF_USER_USER_ID_GENERATOR" , sequenceName = "una.DEF_USER_SEQ01" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "DEF_USER_USER_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Long userId;
    @Basic(optional = false)
    @Column(name = "USER_USERNAME")
    private String userUsername;
    @Basic(optional = false)
    @Column(name = "USER_PASS")
    private String userPass;
    @Basic(optional = false)
    @Column(name = "USER_LVL")
    private Long userLvl;
    @Basic(optional = false)
    @Column(name = "USER_IMGUSER")
    private Long userImguser;
    @Basic(optional = false)
    @Column(name = "USER_IMGBALLESTA")
    private Long userImgballesta;
    @Basic(optional = false)
    @Column(name = "USER_IMGCASTILLO")
    private Long userImgcastillo;
    @Basic(optional = false)
    @Column(name = "USER_DINERO")
    private Long userDinero;
    @Basic(optional = false)
    @Column(name = "USER_ESMERALDAS")
    private Long userEsmeraldas;
    @Basic(optional = false)
    @Column(name = "USER_MVIDA")
    private Long userMvida;
    @Basic(optional = false)
    @Column(name = "USER_MMANA")
    private Long userMmana;
    @Basic(optional = false)
    @Column(name = "USER_LVLFUERZA")
    private Long userLvlfuerza;
    @Basic(optional = false)
    @Column(name = "USER_LVLAGILIDAD")
    private Long userLvlagilidad;
    @Basic(optional = false)
    @Column(name = "USER_LVLRETROCESO")
    private Long userLvlretroceso;
    @Basic(optional = false)
    @Column(name = "USER_LVLDDDAMAGE")
    private Long userLvldddamage;
    @Basic(optional = false)
    @Column(name = "USER_LVLTIRODOBLE")
    private Long userLvltirodoble;
    @Basic(optional = false)
    @Column(name = "USER_SFIREBALL")
    private Long userSfireball;
    @Basic(optional = false)
    @Column(name = "USER_SFREEZE")
    private Long userSfreeze;
    @Basic(optional = false)
    @Column(name = "USER_SRAYO")
    private Long userSrayo;

    public User()
    {
    }

    public User(Long userId)
    {
        this.userId = userId;
    }

    public User(Long userId , String userUsername , String userPass , Long userLvl , Long userImguser , Long userImgballesta , Long userImgcastillo , Long userDinero , Long userEsmeraldas , Long userMvida , Long userMmana , Long userLvlfuerza , Long userLvlagilidad , Long userLvlretroceso , Long userLvldddamage , Long userLvltirodoble , Long userSfireball , Long userSfreeze , Long userSrayo)
    {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPass = userPass;
        this.userLvl = userLvl;
        this.userImguser = userImguser;
        this.userImgballesta = userImgballesta;
        this.userImgcastillo = userImgcastillo;
        this.userDinero = userDinero;
        this.userEsmeraldas = userEsmeraldas;
        this.userMvida = userMvida;
        this.userMmana = userMmana;
        this.userLvlfuerza = userLvlfuerza;
        this.userLvlagilidad = userLvlagilidad;
        this.userLvlretroceso = userLvlretroceso;
        this.userLvldddamage = userLvldddamage;
        this.userLvltirodoble = userLvltirodoble;
        this.userSfireball = userSfireball;
        this.userSfreeze = userSfreeze;
        this.userSrayo = userSrayo;
    }
      public User(UserDto userDto)
    {  //para general un empleado nuevo , debe estar lo que no se deberia editar
        this.userId = userDto.getId();
        //entra un dto sale una entidad---del otro lado en empleado dto pasa lo contrario
        actualizarUser(userDto);
    }

    public void actualizarUser(UserDto userDto)
    { //sirve para el momento de editar
        this.userUsername = userDto.getUsername();
        this.userPass = userDto.getPass();
        this.userLvl = userDto.getLvl();
        this.userImguser = userDto.getImgUser();
        this.userImgballesta = userDto.getImbCastillo();
        this.userImgcastillo = userDto.getImbCastillo();
        this.userDinero = userDto.getDinero();
        this.userEsmeraldas = userDto.getEsmeralda();
        this.userMvida = userDto.getmVida();
        this.userMmana = userDto.getmMana();
        this.userLvlfuerza = userDto.getLvlFuerza();
        this.userLvlagilidad = userDto.getLvlAgilidad();
        this.userLvlretroceso = userDto.getLvlRetroceso();
        this.userLvldddamage = userDto.getLvlDDamage();
        this.userLvltirodoble = userDto.getLvlTiroDoble();
        this.userSfireball = userDto.getLvlFireBall();
        this.userSfreeze = userDto.getLvlFreeze();
        this.userSrayo = userDto.getLvlRayo();
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUserUsername()
    {
        return userUsername;
    }

    public void setUserUsername(String userUsername)
    {
        this.userUsername = userUsername;
    }

    public String getUserPass()
    {
        return userPass;
    }

    public void setUserPass(String userPass)
    {
        this.userPass = userPass;
    }

    public Long getUserLvl()
    {
        return userLvl;
    }

    public void setUserLvl(Long userLvl)
    {
        this.userLvl = userLvl;
    }

    public Long getUserImguser()
    {
        return userImguser;
    }

    public void setUserImguser(Long userImguser)
    {
        this.userImguser = userImguser;
    }

    public Long getUserImgballesta()
    {
        return userImgballesta;
    }

    public void setUserImgballesta(Long userImgballesta)
    {
        this.userImgballesta = userImgballesta;
    }

    public Long getUserImgcastillo()
    {
        return userImgcastillo;
    }

    public void setUserImgcastillo(Long userImgcastillo)
    {
        this.userImgcastillo = userImgcastillo;
    }

    public Long getUserDinero()
    {
        return userDinero;
    }

    public void setUserDinero(Long userDinero)
    {
        this.userDinero = userDinero;
    }

    public Long getUserEsmeraldas()
    {
        return userEsmeraldas;
    }

    public void setUserEsmeraldas(Long userEsmeraldas)
    {
        this.userEsmeraldas = userEsmeraldas;
    }

    public Long getUserMvida()
    {
        return userMvida;
    }

    public void setUserMvida(Long userMvida)
    {
        this.userMvida = userMvida;
    }

    public Long getUserMmana()
    {
        return userMmana;
    }

    public void setUserMmana(Long userMmana)
    {
        this.userMmana = userMmana;
    }

    public Long getUserLvlfuerza()
    {
        return userLvlfuerza;
    }

    public void setUserLvlfuerza(Long userLvlfuerza)
    {
        this.userLvlfuerza = userLvlfuerza;
    }

    public Long getUserLvlagilidad()
    {
        return userLvlagilidad;
    }

    public void setUserLvlagilidad(Long userLvlagilidad)
    {
        this.userLvlagilidad = userLvlagilidad;
    }

    public Long getUserLvlretroceso()
    {
        return userLvlretroceso;
    }

    public void setUserLvlretroceso(Long userLvlretroceso)
    {
        this.userLvlretroceso = userLvlretroceso;
    }

    public Long getUserLvldddamage()
    {
        return userLvldddamage;
    }

    public void setUserLvldddamage(Long userLvldddamage)
    {
        this.userLvldddamage = userLvldddamage;
    }

    public Long getUserLvltirodoble()
    {
        return userLvltirodoble;
    }

    public void setUserLvltirodoble(Long userLvltirodoble)
    {
        this.userLvltirodoble = userLvltirodoble;
    }

    public Long getUserSfireball()
    {
        return userSfireball;
    }

    public void setUserSfireball(Long userSfireball)
    {
        this.userSfireball = userSfireball;
    }

    public Long getUserSfreeze()
    {
        return userSfreeze;
    }

    public void setUserSfreeze(Long userSfreeze)
    {
        this.userSfreeze = userSfreeze;
    }

    public Long getUserSrayo()
    {
        return userSrayo;
    }

    public void setUserSrayo(Long userSrayo)
    {
        this.userSrayo = userSrayo;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof User))
        {
            return false;
        }
        User other = (User) object;
        if((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "cr.ac.una.defender.models.User[ userId=" + userId + " ]";
    }

}
