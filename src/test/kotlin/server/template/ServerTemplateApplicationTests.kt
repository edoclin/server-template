package server.template

import cn.hutool.core.bean.BeanUtil
import cn.hutool.core.thread.ThreadUtil
import cn.hutool.json.JSONUtil
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import server.template.entity.TemplateUser
import server.template.service.ITemplateUserService
import server.template.util.date.DateUtil
import server.template.view.VTemplateUser
import javax.annotation.Resource

@SpringBootTest
// 指定配置文件
@ActiveProfiles("dev")
class ServerTemplateApplicationTests {


    // 注入Bean
    @Resource
    lateinit var iTemplateUserService: ITemplateUserService

    /**
     * MyBatisPlus 以下简称MBP
     */
    @Test
    fun MBPEntityInsert() {
        val templateUser = TemplateUser()
        //id 由MBP配置项自动生成
//        templateUser.userId =
        templateUser.info = "TEST INFO"
        // sql 默认值
//        templateUser.createdTime =
//        templateUser.updatedTime =
//        templateUser.deleted =

        // 插入成功返回true
        println(iTemplateUserService.save(templateUser))
    }

    @Test
    fun MBPEntityRemove() {
        // 逻辑删除
        iTemplateUserService.remove(KtQueryWrapper(TemplateUser::class.java).eq(TemplateUser::deleted, false))

        println(iTemplateUserService.list())
    }

    @Test
    fun MBPEntityUpdate() {

        // kotlin lambda 构造条件查询
        var result =
            iTemplateUserService.list(KtQueryWrapper(TemplateUser::class.java).eq(TemplateUser::info, "TEST INFO"))

        println(result)
        result.forEach {
            // 默认迭代器变量名为it

            // 引用传递?
            it.info = "UPDATE"
        }

        ThreadUtil.safeSleep(1000)

        // 批量更新
        // 单条记录更新调用 update()
        println(iTemplateUserService.updateBatchById(result))

        result =
            iTemplateUserService.list(KtQueryWrapper(TemplateUser::class.java).eq(TemplateUser::info, "TEST INFO"))

        // 查看结果
        println(result)

        result =
            iTemplateUserService.list(KtQueryWrapper(TemplateUser::class.java).eq(TemplateUser::info, "UPDATE"))

        // 查看结果 注意更新时间
        println(result)
    }

    @Test
    fun buildViewData() {
        val result = mutableListOf<VTemplateUser>()

        // mapTo 语法
        // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map-to.html
        iTemplateUserService.list().mapTo(result) {
            val item = VTemplateUser()
            // https://hutool.cn/docs/#/core/JavaBean/Bean%E5%B7%A5%E5%85%B7-BeanUtil?id=bean%e8%bd%acbean
            BeanUtil.copyProperties(it, item)
            item.createdTime = DateUtil.yyyyMMdd(it.createdTime)
            item.updatedTime = DateUtil.yyyyMMddHHmm(it.updatedTime)
            item
        }

        println(JSONUtil.toJsonPrettyStr(result))
    }

}
