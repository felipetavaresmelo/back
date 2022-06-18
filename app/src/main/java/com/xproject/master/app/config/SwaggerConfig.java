//package com.xproject.master.app.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Tag;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfig {
//    private static final String BASE_PACKAGE = "com.xproject.master.app.entrypoint";
//    public static final String TAG_ENTRY_POINT = "xPROJECT";
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
//                .paths(PathSelectors.any())
//                .build();
//                //.apiInfo(getApiInfo());
//    }
//    private Tag getTagAppication(){
//        return new Tag(TAG_ENTRY_POINT, "Entrypoint to CRUD application.");
//    }
//    private ApiInfo getApiInfo() {
//        return new ApiInfoBuilder()
//                .title("X-Project")
//                .description("Project that explore Clean Architecture")
//                .version("1.0.0")
//                .build();
//    }
//
//}
