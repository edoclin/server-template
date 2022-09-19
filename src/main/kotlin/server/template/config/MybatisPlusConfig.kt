package server.template.config

import cn.hutool.core.util.IdUtil
import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.apache.ibatis.reflection.MetaObject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import server.template.entity.TemplateUser
import java.time.LocalDateTime


/**
 * MybatisPlus 配置项
 */
@Configuration
class MybatisPlusConfig : MetaObjectHandler, IdentifierGenerator {
    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    override fun insertFill(metaObject: MetaObject?) {
        this.strictInsertFill(
            metaObject, "createdTime",
            { LocalDateTime.now() },
            LocalDateTime::class.java
        )
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    override fun updateFill(metaObject: MetaObject?) {
        metaObject?.setValue("updatedTime", null)
        this.strictUpdateFill(
            metaObject, "updatedTime",
            { LocalDateTime.now() },
            LocalDateTime::class.java
        )
    }

    /**
     * 生成Id
     *
     * @param entity 实体
     * @return id
     */
    override fun nextId(entity: Any?): Number {
        TODO("Not yet implemented")
    }

    /**
     * 生成对应实体类ID前缀
     */
    override fun nextUUID(entity: Any): String {
        val prefix = when (entity) {
            is TemplateUser -> "TU"
            else -> "NONE"
        }
        return prefix + IdUtil.getSnowflakeNextIdStr()
    }

    /**
     * 分页插件
     */
    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        val interceptor = MybatisPlusInterceptor()
        interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))
        return interceptor
    }
}