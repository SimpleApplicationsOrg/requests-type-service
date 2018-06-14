package org.simpleapplications.typeservice

import org.simpleapplications.typeservice.service.RequestTypeService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TypeServiceApplication {
    @Bean
    fun init(requestTypeService: RequestTypeService) = CommandLineRunner {
        if (requestTypeService.findAllTypes().count() == 0) {
            loadData(requestTypeService)
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(TypeServiceApplication::class.java, *args)
}
