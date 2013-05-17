package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

/**
 * *
 * 
 * @author
 * 
 */
@Entity
public class PohForgetPass extends Model {

    public PohForgetPass(String username, String email, String token, Long time, Integer type) {
        super();
        this.username = username;
        this.email = email;
        this.token = token;
        this.time = time;
        this.state = 0;
        this.type = type;
    }

    /**
     * 用户邮箱
     */
    @Column(nullable = false)
    public String username;

    /**
     * 用户邮箱账号
     */
    @Column(nullable = false)
    public String email;

    /**
     * 用户token
     */
    @Column(nullable = true)
    public String token;

    /**
     * 发送验证链接的时间
     */
    @Column(nullable = false)
    public Long time;

    /**
     * 状态标识,1已验证，0未验证。
     */
    @Column(nullable = false)
    public Integer state;

    /**
     * 用户类型,1公司用户，0普通用户
     */
    @Column(nullable = false)
    public Integer type;

    /**
     * 根据用户名获得用户信息
     * 
     */
    public static List<PohCompany> getCompanyname(String username) {
        return PohCompany.find("flag=0 and username=?", username).fetch();
    }

    public static List<PohUsers> getUsername(String username) {
        return PohUsers.find("flag=0 and username=?", username).fetch();
    }

    public static List<PohForgetPass> findToken(String username) {
        return PohForgetPass.find("username=? and state=0", username).fetch();
    }

}
