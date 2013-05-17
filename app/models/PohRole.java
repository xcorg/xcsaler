package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import net.sf.json.JSONObject;
import play.data.validation.Required;
import play.db.jpa.Model;
import controllers.Company;
import controllers.Security;

/**
 * PohRole entity.
 */

@Entity
public class PohRole extends Model {

    // Fields
    // @Id
    // public Short roleId;
    // public String roleName;
    public String actionList;
    public String roleDescribe;

    @ManyToOne(optional = false)
    public Company company;

    @Required
    @Column(nullable = false)
    public String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<PohUserRole> userlinks = new ArrayList<PohUserRole>();

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<PohRoleAuth> authlinks = new ArrayList<PohRoleAuth>();

    public PohRole(String name) {
        this.name = name;
    }

    public static PohRole gets(String name, Long cid) {
        PohRole role = null;
        if (role == null) {
            role = PohRole.find("name=? and company_id=?", name, cid).first();
        }
        if (role == null) {
            role = new PohRole(name).save();
        }
        return role;
    }

    public static PohRole get(String name) {
        PohRole role = null;
        if (role == null) {
            role = PohRole.find("name=?", name).first();
        }
        if (role == null) {
            role = new PohRole(name).save();
        }
        return role;
    }

//    /**
//     * 角色列表
//     */
//    public static List roleSee() {
//        Company company = (Company) Security.currentUser();
//        List<PohRole> roles = company.roles;
//        return roles;
//    }

    public static Long roleAdd(String name) {
        PohRole role = new PohRole(name);
        role.company = (Company) Security.currentUser();
        try {
            if (role.save().isPersistent()) {
                return role.id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role.id;
    }

    /**
     * 删除角色
     */
    public static boolean delete(PohRole role) {
        boolean sign = role.delete().isPersistent();
        return sign;
    }

    /**
     * 修改角色
     */
    public static String update(PohRole role) {
        role.save();
        JSONObject obj = new JSONObject();
        obj.put("name", role.name);
        obj.put("id", role.id);
        return obj.toString();
    }
}