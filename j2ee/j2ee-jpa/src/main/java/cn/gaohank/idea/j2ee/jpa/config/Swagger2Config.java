package cn.gaohank.idea.j2ee.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// 表明这是一个配置类
@Configuration
// 开启swagger2
@EnableSwagger2
// 只在dev和test环境生成文档
@Profile({"dev", "test"})
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any()) // 指定controller存放的目录路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("springboot-01-jpa API文档")
                // 文档描述
                .description("springboot 学习文档")
                .termsOfServiceUrl("cn.gaohank") // 设置文档的License信息->1.3 License information
                .version("1.0.0").build();
    }
}
