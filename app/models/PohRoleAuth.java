package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

/**
 * 角色_权限的链接
 * 
 * 用来给角色赋予权限
 * 
 * @author Administrator
 * 
 */
@Entity
public class PohRoleAuth extends Model {

    @ManyToOne(optional = false)
    public PohRole role;

    @ManyToOne(optional = false)
    public PohAuth auth;

    /**
     * 写了这么多代码，都是为了.grant(xxx).to(xxx)的语法。。。
     * 
     * @author Administrator
     * 
     */
    public static class GrantHelper {
        private Set<String> authNames = new HashSet<String>();

        public GrantHelper(String authName) {
            grant(authName);
        }

        public GrantHelper grant(String authName) {
            this.authNames.add(authName);
            return this;
        }

        public void to(String roleName) {
            for (String authName : authNames) {
                PohRole role = PohRole.get(roleName);
                PohAuth auth = PohAuth.get(authName);
                PohRoleAuth link = new PohRoleAuth();
                link.role = role;
                role.authlinks.add(link);
                link.auth = auth;
                auth.rolelinks.add(link);
                link.save();
            }
        }
    }

    /**
     * 写了这么多代码，只是为了.remove(xxx).from(xxx)的语法。。。
     * 
     * @author Administrator
     * 
     */
    public static class RemoveHelper {
        private Set<String> authNames = new HashSet<String>();

        public RemoveHelper(String authName) {
            remove(authName);
        }

        public RemoveHelper remove(String authName) {
            this.authNames.add(authName);
            return this;
        }

        public void from(String roleName) {
            List<String> list = new ArrayList<String>();
            list.addAll(this.authNames);
            List<PohRoleAuth> links = PohRoleAuth.find("role.name=? and auth.name in (?2)", roleName, list).fetch();
            System.out.println("To Delete Count:" + links.size());
            for (PohRoleAuth link : links) {
                link.role.authlinks.remove(link);
                link.auth.rolelinks.remove(link);
                link.delete();
            }
            // TODO 将这种先查询再删除的模式改为直接删除的模式
        }

    }

    public static GrantHelper grant(String authName) {
        return new GrantHelper(authName);
    }

    public static RemoveHelper remove(String authName) {
        return new RemoveHelper(authName);
    }

    /**
     * 添加权限
     */
    public static void add(PohRoleAuth roleAuth) {
        roleAuth.save();
    }

    /**
     * 删除权限
     */
    public static void delete(PohRoleAuth roleAuth) {
        roleAuth.delete("auth_id=? and role_id=?", roleAuth.auth.id, roleAuth.role.id);
    }
}
