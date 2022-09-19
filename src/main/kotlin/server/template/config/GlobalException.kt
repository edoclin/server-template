package server.template.config

import cn.dev33.satoken.exception.NotLoginException
import com.toolgeo.server.util.result.ResultBean
import com.toolgeo.server.util.result.ResultUtil
import com.toolgeo.server.util.result.ResultUtil.error
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.ResponseBody
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class GlobalException {

    @ModelAttribute
    @Throws(IOException::class)
    operator fun get(request: HttpServletRequest?) {
    }

    @ResponseBody
    @ExceptionHandler
    fun handlerException(e: Exception, request: HttpServletRequest?, response: HttpServletResponse?): ResultBean {
        e.printStackTrace()
        return if (e is NotLoginException) {
            ResultUtil.notLogin()
        } else error(e.message!!)
    }
}