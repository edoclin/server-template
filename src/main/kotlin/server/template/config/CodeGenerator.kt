package server.template.config

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.IFill
import com.baomidou.mybatisplus.generator.config.GlobalConfig
import com.baomidou.mybatisplus.generator.config.OutputFile
import com.baomidou.mybatisplus.generator.config.PackageConfig
import com.baomidou.mybatisplus.generator.config.StrategyConfig
import com.baomidou.mybatisplus.generator.config.po.LikeTable
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import com.baomidou.mybatisplus.generator.fill.Column
import java.util.*

/**
 * 代码生成器
 * 从数据库表生成controller、service、mapper、entity文件
 */
object CodeGenerator {
    var params: MutableMap<String, String> = HashMap()

    /**
     * 注解开启时整个项目存在两个main函数，gradle打包会报错
     */
    @JvmStatic
    fun main(args: Array<String>) {
        params["host"] = "localhost"
        params["port"] = "3306"
        params["database"] = "server_template"
        params["username"] = "root"
        params["password"] = "nilcode"
        params["author"] = "edoclin"
        params["parent_pkg"] = "server"
        params["module_name"] = "template"
        params["like_table"] = "t_" // 需要生成的表的公共前缀
        params["table_prefix"] = "t_" // 生成时忽略前缀
        generate(params)
    }

    private fun generate(params: Map<String, String>) {
        val path = System.getProperty("user.dir") + "/src/main"
        val url = String.format("jdbc:mysql://%s:%s/%s", params["host"], params["port"], params["database"])
        FastAutoGenerator.create(url, params["username"], params["password"])
            .globalConfig { builder: GlobalConfig.Builder ->
                builder.author( params["author"]!!)
                    .outputDir("$path/kotlin")
                    .enableKotlin()
            }
            .packageConfig { builder: PackageConfig.Builder ->
                builder.parent(
                    params["parent_pkg"]!!
                ) // 设置父包名
                    .moduleName(params["module_name"]!!) // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.xml, "$path/resources/mapper"))
            }
            .strategyConfig { builder: StrategyConfig.Builder ->
                builder.controllerBuilder().enableRestStyle()
                builder.mapperBuilder().enableMapperAnnotation()
                builder
                    .entityBuilder()
                    .enableRemoveIsPrefix()
                    .logicDeleteColumnName("deleted")
                    .idType(IdType.ASSIGN_UUID)
                    .addTableFills(mutableListOf<IFill>(Column("created_time", FieldFill.INSERT), Column("updated_time", FieldFill.UPDATE)))

                builder.likeTable(LikeTable(params["like_table"]))
                    .addTablePrefix(params["table_prefix"]!!)
            }
            .templateEngine(FreemarkerTemplateEngine())
            .execute()
    }
}