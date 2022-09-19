package server.template.config

import cn.dev33.satoken.interceptor.SaInterceptor
import cn.dev33.satoken.stp.StpInterface
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class SaTokenConfigure : WebMvcConfigurer, StpInterface {
    /**
     *创建一个 Sa-Token 综合拦截器，默认带有注解鉴权能力
     */
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(SaInterceptor()).addPathPatterns("/**")
    }

    /**
     * 返回指定账号id所拥有的权限码集合
    Params:
    loginId – 账号id
    loginType – 账号类型
    Returns:
    该账号id具有的权限码集合
     */

    override fun getPermissionList(loginId: Any, loginType: String): List<String>? {
        return mutableListOf()
    }

    /**
     * 返回指定账号id所拥有的角色标识集合
    Params:
    loginId – 账号id
    loginType – 账号类型
    Returns:
    该账号id具有的角色标识集合
     */
    override fun getRoleList(loginId: Any, loginType: String): List<String>? {
        return mutableListOf()
    }


}