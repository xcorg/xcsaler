package controllers;

import java.util.List;

import models.Auth;
import models.IUser;
import models.Role;
import models.Role_Auth;
import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import utils.Constants;
import utils.UploadUtil;

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
        Boolean b = models.Company.updatePassword(password, new_password);
        render("@index", b);
    }

    public static void personalpassword() {
        renderTemplate("/Settings/personalpassword.html");
    }

    /**
     * 添加用户页面
     */
    public static void userInitAdd() {
        models.Company company = User.initAdd();
        List<Role> roleSee = company.roles;
        String token = UploadUtil.getToken();
        render(roleSee, token, company);
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
        boolean b = models.User.isExist(username, id);
        return b;
    }

    /**
     * 验证用户邮箱是否存在
     * 
     * @param username
     * @return
     */
    public static boolean emailIsExist(String email, String id) {
        boolean b = models.User.isemailExist(email, id);
        return b;
    }

    /**
     * 修改用户页面
     */
    public static void userInitUpdate(User user) {
        models.Company company = User.initAdd();
        User init = User.initUpdate(user);
        List<Role> roleSee = init.company.roles;
        List<String> roleNames = init.roleNames();

        String token = UploadUtil.getToken();
        // String emailBefore=init.email;
        render(init, roleSee, roleNames, token, company);
    }

    /**
     * 角色列表
     */
    public static void roleSee() {
        List roleSee = Role.roleSee();
        List<Auth> authSee = Auth.authSee();
        render(roleSee, authSee);
    }

    /**
     * 添加角色
     */
    public static Long roleAdd(String name) {
        Long id = Role.roleAdd(name);
        return id;
    }

    /**
     * 删除角色
     */
    public static Long roleDel(Role role) {
        Long roleId = role.id;
        boolean sign = Role.delete(role);
        return roleId;
    }

    /**
     * 修改角色
     * 
     * @return
     */
    public static String roleUpdate(Role role) {
        String json = Role.update(role);
        return json;
    }

    /**
     * 添加权限
     */
    public static void authAdd(Role_Auth roleAuth) {
        Role_Auth.add(roleAuth);
    }

    /**
     * 删除权限
     */
    public static void authDel(Role_Auth roleAuth) {
        Role_Auth.delete(roleAuth);
    }

}
