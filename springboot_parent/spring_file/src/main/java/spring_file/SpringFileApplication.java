package spring_file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringFileApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication springApplication = new SpringApplication(SpringFileApplication.class);
        /*//创建Properties
        Properties properties = new Properties();
        //通过当前类的ClassLoader加载
        InputStream inputStream = SpringFileApplication.class.getClassLoader()
                .getResourceAsStream("app.properties");
        //将输入流读取成properties
        properties.load(inputStream);

        springApplication.setDefaultProperties(properties);*/
        springApplication.run(args);
    }

}
