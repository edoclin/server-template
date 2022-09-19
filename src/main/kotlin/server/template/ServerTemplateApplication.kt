package server.template

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
/**
 * mybatis mapper接口所在的包
 */
@MapperScan(basePackages = ["server.template.mapper"])
class ServerTemplateApplication

fun main(args: Array<String>) {
    runApplication<ServerTemplateApplication>(*args)
}
