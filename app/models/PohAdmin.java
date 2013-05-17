package models;

import javax.persistence.Column;

import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;
import play.libs.Crypto.HashType;
import controllers.Security;

public class PohAdmin extends Model implements IUser {

    @Required
    @Column(nullable = false)
    public String name;

    /**
     * 登录账号
     */
    @Required
    @Column(nullable = false, unique = true)
    public String username;

    public String password;

    public static PohAdmin get(String username) {
        return PohAdmin.find("username=?", username).first();
    }

    /**
     * 修改用户密码
     * 
     * @param password
     *            旧密码 new_password新密码
     * @return 成功true 否则false
     */
    public static Boolean updatePassword(String password, String new_password) {
        Boolean bool_re = false;
        IUser user = (IUser) Security.currentUser();
        PohAdmin administrator = PohAdmin.get(user.getUsername());
        Boolean b = administrator.passwordMatches(password);
        if (b) {
            administrator.setPassword(new_password);
            bool_re = administrator.save().isPersistent();
        }
        return bool_re;
    }

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
        if (password == null)
            password = "";
        return Crypto.passwordHash(password, HashType.SHA256).equals(this.password);
    }

    @Override
    public void setPassword(String password) {
        this.password = Crypto.passwordHash(password, HashType.SHA256);
    }

    @Override
    public UserType getType() {
        return UserType.Company;
    }

}
