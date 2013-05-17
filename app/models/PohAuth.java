package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * 权限
 * 
 * 用来标识用户对一种资源是否有某种权限
 * 
 * @author Administrator
 * 
 */
@Entity
public class PohAuth extends Model {

    @Required
    @Column(nullable = false, unique = true)
    public String name;

    @OneToMany(mappedBy = "auth")
    public List<PohRoleAuth> rolelinks = new ArrayList<PohRoleAuth>();

    public PohAuth(String name) {
        this.name = name;
    }

    public static PohAuth get(String name) {
        PohAuth auth = null;
        if (auth == null) {
            auth = PohAuth.find("name=?", name).first();
        }
        if (auth == null) {
            auth = new PohAuth(name).save();
        }
        assert auth != null;
        return auth;
    }

    public static boolean check(String authName) {
        // return check((User) Security.currentUser(), authName);
        return true;
    }

    public static boolean check(PohUsers user, String authName) {
        // System.out.println("User:" + user);
        // if (user == null)
        // return false;
        // Set<String> auths = new HashSet<String>();
        // for (PohUserRole rolelink : user.rolelinks) {
        // PohRole role = rolelink.role;
        // for (PohRoleAuth authlink : role.authlinks) {
        // PohAuth auth = authlink.auth;
        // auths.add(auth.name);
        // }
        // }
        // System.out.println("User Auths:" + auths);
        // return auths.contains(authName);
        return true;
    }

    /**
     * 权限列表
     */
    public static List authSee() {
        List<PohAuth> auths = PohAuth.findAll();
        return auths;
    }

    public boolean check(PohUsers user) {
        return PohAuth.check(user, this.name);
    }
}
