package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class PohUserRole extends Model {

    // @ManyToOne(optional = false)
    // public PohUsers user;
    //
    // @ManyToOne(optional = false)
    // public PohRole role;

    /**
     * 写了这么多代码，都是为了.grant(xxx).to(xxx)的语法。。。
     * 
     * @author Administrator
     * 
     */
    public static class GrantHelper {
        private Set<String> roleNames = new HashSet<String>();

        public GrantHelper(String roleName) {
            grant(roleName);
        }

        public GrantHelper grant(String authName) {
            this.roleNames.add(authName);
            return this;
        }

        public void to(PohUsers user) {
            if (user != null && user.isPersistent()) {
                for (String roleName : roleNames) {
                    PohUserRole link = new PohUserRole();
                    // link.user = user;
                    // Long cid = user.company.id;
                    // link.role = PohRole.gets(roleName, cid);
                    link.save();
                    // user.rolelinks.add(link);
                }
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
        private Set<String> roleNames = new HashSet<String>();

        public RemoveHelper(String roleName) {
            remove(roleName);
        }

        public RemoveHelper remove(String roleName) {
            this.roleNames.add(roleName);
            return this;
        }

        public void from(PohUsers user) {
            if (user != null && user.isPersistent()) {
                PohUserRole.delete("user=? and role.name in (?1)", user, roleNames);
                // FIXME 上面删除语句不能用。。参见BasicTest
                user.refresh();
            }
        }
    }

    public static GrantHelper grant(String roleName) {
        return new GrantHelper(roleName);
    }

    public static RemoveHelper remove(String roleName) {
        return new RemoveHelper(roleName);
    }

}
