import com.xie.beans.Role;
import com.xie.beans.User;
import com.xie.controller.UserController;
import com.xie.service.UserService;
import com.xie.service.impl.RoleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Author xiehu
 * @Date 2022/8/30 22:34
 * @Version 1.0
 * @Description
 */
public class IocTest {
    ClassPathXmlApplicationContext ioc;

    @Before
    public void before(){
        ioc= new ClassPathXmlApplicationContext("spring_ioc.xml");

    }
    @Test
    public void test(){
        User bean = ioc.getBean(User.class);
        System.out.println(bean.getName());
        System.out.println(bean.getRoleName());
        System.out.println(bean.getBrotherName());

    }
    @Test
    public void test1(){
        UserController bean = ioc.getBean(UserController.class);
        bean.getUser();
    }
    @Test
    public void test2(){
        Role bean = ioc.getBean(Role.class);
        bean.getName();
        ioc.close();
    }
    @Test
    public void test3(){
        UserService bean = ioc.getBean(UserService.class);
        System.out.println(bean.getClass());

        RoleServiceImpl roleService = new RoleServiceImpl();
        if(roleService instanceof UserService){
            System.out.println("ok");
        };
    }

}
