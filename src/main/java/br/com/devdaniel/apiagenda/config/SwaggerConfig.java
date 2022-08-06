package br.com.devdaniel.apiagenda.config;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//	@Bean
//	public Docket api(){
//		
//		Predicate<RequestHandler> basePackage = RequestHandlerSelectors.basePackage("br.com.devdaniel.apiagenda");
//		Predicate<String> apiUrls = PathSelectors.ant("/api/**");
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(getApiInfo())
//				.select()
//				.apis(basePackage)
//				.paths(apiUrls)
//				.paths(Predicates.not(PathSelectors.regex("/error.*")))
//				.build();
//	}
//
//	private ApiInfo getApiInfo() {
//
//		return new ApiInfoBuilder().title("Api do Serviço REST do sistema Agenda")
//				.description("Especificação de uso da api Agenda").version("1.0.0").build();
//	}

}
