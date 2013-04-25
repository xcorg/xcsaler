package models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohUsers entity.
 */

@Entity
public class PohUsers extends GenericModel {

    // Fields

    public Integer userId;
    public String email;
    public String userName;
    public String password;
    public String question;
    public String answer;
    public Boolean sex;
    public Date birthday;
    public Double userMoney;
    public Double frozenMoney;
    public Integer payPoints;
    public Integer rankPoints;
    public Integer addressId;
    public Integer regTime;
    public Integer lastLogin;
    public Timestamp lastTime;
    public String lastIp;
    public Short visitCount;
    public Short userRank;
    public Short isSpecial;
    public String ecSalt;
    public String salt;
    public Integer parentId;
    public Short flag;
    public String alias;
    public String msn;
    public String qq;
    public String officePhone;
    public String homePhone;
    public String mobilePhone;
    public Short isValidated;
    public Double creditLine;
    public String passwdQuestion;
    public String passwdAnswer;

}