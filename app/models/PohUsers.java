package models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;
import play.libs.Crypto.HashType;
import utils.UtilValidate;

/**
 * PohUsers entity.
 */

@Entity
public class PohUsers extends Model implements IUser {

    // Fields
    // @Id
    // public Long userId;
    public String email;

    /**
     * 用户真实姓名
     */
    @Required
    @Column(nullable = true)
    public String name;

    /**
     * 登录用户名
     */
    @Column(nullable = false, unique = true)
    public String username;

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

    /**
     * 删除标示,1删除，0未删除。
     */
    @Column(nullable = false)
    public Short flag = 0;

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

    public static PohUsers get(String username) {
        return PohUsers.find("username=? and flag=0", username).first();
    }

    /**
     * 验证用户账号唯一
     * 
     * @param username
     * @param id
     *            修改时，该账号的id
     * @return true 不存在，false 存在该账号
     */
    public static boolean isExist(String username, String id) {
        PohUsers user = PohUsers.find("username=?", username).first();
        PohCompany company = PohCompany.find("username=?", username).first();
        boolean b = false;
        if (id == null || "".equals(id)) {
            b = (user == null) && (company == null);
        } else {
            if (user != null)
                b = (user.id == Integer.parseInt(id));
            else if (company != null)
                b = (company.id == Integer.parseInt(id));
            else
                b = true;
        }
        return b;
    }

    /**
     * 验证用户邮箱唯一
     * 
     * @param email
     * @param id
     *            修改时，该账号的id
     * @return true 不存在，false 存在该账号
     */
    public static boolean isEmailExist(String emails, String id) {
        PohUsers user = PohUsers.find("email=?", emails).first();
        PohCompany company = PohCompany.find("email=?", emails).first();
        boolean b = false;
        if (id == null || "".equals(id)) {
            b = (user == null) && (company == null);
        } else {
            if (user != null)
                b = (user.id == Integer.parseInt(id));
            else if (company != null)
                b = (company.id == Integer.parseInt(id));
            else
                b = true;
        }
        return b;
    }

    // @Override
    // public Long getId() {
    // return userId;
    // }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean passwordMatches(String password) {
        if (password == null) {
            password = "";
        }
        return Crypto.passwordHash(password, HashType.SHA256).equals(this.password);
    }

    @Override
    public void setPassword(String password) {
        if (UtilValidate.isNotEmpty(password)) {
            this.password = Crypto.passwordHash(password, HashType.SHA256);
        }
    }

    @Override
    public UserType getType() {
        return UserType.User;
    }
}