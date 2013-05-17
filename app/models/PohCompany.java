package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;

import play.Play;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;
import play.libs.Crypto.HashType;
import utils.EmailUtil;
import controllers.Security;

public class PohCompany extends Model implements IUser {

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

    /**
     * 删除标示,1删除，0未删除。
     */
    @Column(nullable = false)
    public Short flag = 0;

    /**
     * 邮箱
     */
    @Required
    @Column(nullable = false)
    public String email = "";

    /**
     * 是否激活
     */
    @Column(nullable = false)
    public boolean activation = true;

    public static PohCompany get(String username) {
        return PohCompany.find("username=?", username).first();
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
        PohCompany company = PohCompany.get(user.getUsername());
        Boolean b = company.passwordMatches(password);
        if (b) {
            company.setPassword(new_password);
            bool_re = company.save().isPersistent();
        }
        return bool_re;
    }

    public static PohCompany initUpdate(String companyId) {
        PohCompany account = PohCompany.findById(companyId);
        return account;
    }

    public static void update(PohCompany company) {
        company.save();
    }

    /**
     * 添加公司账号
     * 
     * @return
     */
    public static void Add(PohCompany account) {
        String token = Crypto.sign(UUID.randomUUID().toString());
        Long time = System.currentTimeMillis();
        PohForgetPass person = new PohForgetPass(account.username, account.email, token, time, 1);
        person.state = 0;
        person.save();

        account.save();

        // 这里增加发邮件功能！
        // PohForgetPass pass = PohForgetPass.find("username=? and state=0", account.username).first();
        String url = Play.configuration.getProperty("application.baseUrl") + "security/pass?type=com&token=" + token;
        String msg = "<div style='color: #039;'><span>亲爱的</span><span>" + account.email + "</span>:<p>"
                + "欢迎使用舆情产品设置密码功能。请点击以下链接设置您的密码(链接30分钟有效):</p>" + "<a href='" + url + "' target='_blank' title='点击重置您的密码'>" + url
                + "</a><p>如果点击以上链接没有反应，请将该网址复制并粘贴到新的浏览器窗口中。</p></div>";

        EmailUtil.sendEmail(msg, account.email, "");
    }

    /**
     * 公司账号列表
     * 
     * @return
     */
    public static List see() {
        List<PohCompany> list = new ArrayList<PohCompany>();
        List company_list = PohUsers.find(
                "select a ,(select count(user.id) from User user where delete_flag=0 and company_id=a.id) as count " + "from Company a "
                        + "where a.delete_flag=0").fetch();
        for (int i = 0; i < company_list.size(); i++) {
            Object[] obj = (Object[]) company_list.get(i);
            PohCompany company = (PohCompany) obj[0];
            // company.haveUserCount = Integer.valueOf(obj[1].toString());
            list.add(company);
        }
        return list;
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
