package org.simpleapplications.typeservice

import org.simpleapplications.typeservice.service.RequestTypeService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.PathSelectors.regex

@SpringBootApplication
@EnableNeo4jRepositories
class TypeServiceApplication {
    @Bean
    fun init(requestTypeService: RequestTypeService) = CommandLineRunner {
        if (requestTypeService.findAll().count() == 0) {
            loadData(requestTypeService)
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(TypeServiceApplication::class.java, *args)
}
