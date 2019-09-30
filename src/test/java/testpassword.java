import com.rimi.util.PWDUtils;

/**
 * 密码测试
 *
 * @author wjy
 * @date 2019/9/26 0026 22:20
 */
public class testpassword {
    public static void main(String[] args) {
        String pwd = PWDUtils.getPwd("admin123");
        System.out.println(pwd);
    }
}
