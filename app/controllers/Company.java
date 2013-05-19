package controllers;

import models.IUser;
import models.PohCompany;
import models.PohRole;
import models.PohRoleAuth;
import models.PohUsers;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import utils.Constants;

@With(Secure.class)
@Check("Company")
public class Company extends Controller {
    @Before
    public static void loginInfo() {
        renderArgs.put(Constants.USER, Security.currentUser());
    }

    public static void index() {
        render();
    }

    /**
     * 验证当前密码
     * 
     * @param password
     *            旧密码
     * @return
     */
    public static boolean authPassword(String password) {
        IUser user = (IUser) Security.currentUser();
        return user.passwordMatches(password);
    }

    /**
     * 修改用户密码
     * <p>
     * 请求方式：POST
     * </p>
     * <p>
     * 渲染：render(true)
     * </p>
     * 
     * @param password
     *            旧密码 new_password新密码
     */
    public static void savePersonalPassword(String password, String new_password) {
        Boolean b = PohCompany.updatePassword(password, new_password);
        render("@index", b);
    }

    public static void personalpassword() {
        renderTemplate("/Settings/personalpassword.html");
    }

    /**
     * 添加用户页面
     */
    public static void userInitAdd() {
        // PohCompany company = PohUsers.initAdd();
        // List<PohRole> roleSee = company.roles;
        // String token = UploadUtil.getToken();
        // render(roleSee, token, company);

        render();
    }

    public static void ukeySuperPwdSee() {
        render();
    }

    /**
     * 验证用户名是否存在
     * 
     * @param username
     * @return
     */
    public static boolean userIsExist(String username, String id) {
        boolean b = PohUsers.isExist(username, id);
        return b;
    }

    /**
     * 验证用户邮箱是否存在
     * 
     * @param username
     * @return
     */
    public static boolean emailIsExist(String email, String id) {
        boolean b = PohUsers.isEmailExist(email, id);
        return b;
    }

    /**
     * 修改用户页面
     */
    public static void userInitUpdate(PohUsers user) {
        // PohCompany company = User.initAdd();
        // User init = User.initUpdate(user);
        // List<PohRole> roleSee = init.company.roles;
        // List<String> roleNames = init.roleNames();
        //
        // String token = UploadUtil.getToken();
        // // String emailBefore=init.email;
        // render(init, roleSee, roleNames, token, company);

        render();
    }

    /**
     * 角色列表
     */
    public static void roleSee() {
        // List roleSee = PohRole.roleSee();
        // List<PohAuth> authSee = PohAuth.authSee();
        // render(roleSee, authSee);
        render();
    }

    /**
     * 添加角色
     */
    public static Long roleAdd(String name) {
        Long id = PohRole.roleAdd(name);
        return id;
    }

    /**
     * 删除角色
     */
    public static Long roleDel(PohRole role) {
        Long roleId = role.id;
        boolean sign = PohRole.delete(role);
        return roleId;
    }

    /**
     * 修改角色
     * 
     * @return
     */
    public static String roleUpdate(PohRole role) {
        String json = PohRole.update(role);
        return json;
    }

    /**
     * 添加权限
     */
    public static void authAdd(PohRoleAuth roleAuth) {
        PohRoleAuth.add(roleAuth);
    }

    // /**
    // * 删除权限
    // */
    // public static void authDel(PohRoleAuth roleAuth) {
    // PohRoleAuth.delete(roleAuth);
    // }

}
