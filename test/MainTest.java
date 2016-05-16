import com.zhaoqi.controller.CommonController;
import com.zhaoqi.exercises.services.PutSkills;
import com.zhaoqi.model.hero.DotaHero;
import com.zhaoqi.model.skill.HeroSkill;
import com.zhaoqi.util.CouponCreateUtil;
import com.zhaoqi.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by zhaoqi on 2016/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations={"file:web/resources/META-INF/spring/spring*.xml"})
public class MainTest {

    @Resource
    private PutSkills putSkills;

    @Resource
    CommonController commonController;

    @Test
    public void test() {
        putSkills.putSkills(new DotaHero(),new HeroSkill(), new DotaHero());
    }

    @Test
    public void test2(){
        String str = "CnsKICAiaGVsbG8iOiAiaGVsbG8gd29ybGQhIgp9";
        byte[] buf = new byte[1024];
        try {
            int length=0;
            for (byte b : str.getBytes()) {
                buf[length]=b;
                length++;
            }

            System.out.println(buf.length);
            System.out.println(JsonUtil.toString(buf));
            byte[] shortBuf = Arrays.copyOf(buf,length);
            System.out.println(JsonUtil.toString(shortBuf));
            byte[] decodedBuf = Base64Utils.decode(shortBuf);
            System.out.println(JsonUtil.toString(decodedBuf));
            System.out.println(new String(decodedBuf));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        Properties prop = new Properties();

        try {
            prop.load(getClass().getResourceAsStream("META-INF/config/zk-server.properties"));
//            prop.load(new FileInputStream("META-INF/config/zk-server.properties"));
            System.out.println(prop.getProperty("zkServer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        BigInteger b = new BigInteger("245983498537923");
        for (int i=0;i<10;i++) {
            printObject(CouponCreateUtil.encodeCouponNumber(b.toString()));
            b=b.add(new BigInteger("3453452"));
        }
//        printObject(CouponCreateUtil.encodeCouponNumber(458945612));
    }

    public static void printObject(Object o){
        System.out.println(JsonUtil.toString(o));
    }

}
