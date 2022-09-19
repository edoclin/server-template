package server.template.config

import com.toolgeo.server.util.slf4j.Slf4j
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync

/**
 * SpringBoot启动后执行run()
 */
@Configuration
@EnableAsync
@Slf4j
class InitApplicationRunner : ApplicationRunner {

    @Async
    override fun run(args: ApplicationArguments) {
    }
}