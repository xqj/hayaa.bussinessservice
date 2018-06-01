package hayaa;

import hayaa.bussiness.service.core.DataConfig;
import hayaa.serviceplatform.client.AppRoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class Application {
    public static void main(String[] args) throws Exception {
        AppRoot.StartApp();
        DataConfig dataConfig=new DataConfig();
        SpringApplication app=new SpringApplication(Application.class);
        app.setDefaultProperties(dataConfig.getConfig());
        app.run(args);
    }

}
