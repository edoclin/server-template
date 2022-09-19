### 使用说明

0. 修改配置文件`resources/application-*.yaml`
1. 执行 `resources/init.sql`
3. 修改参数&运行代码生成器`src/main/kotlin/server/template/config/CodeGenerator`
```kotlin
object CodeGenerator {
        var params: MutableMap<String, String> = HashMap()
        /**
         * 注解开启时整个项目存在两个main函数，gradle打包会报错
         */
//    @JvmStatic
        fun main(args: Array<String>) {
        params["host"] = "localhost"
        params["port"] = "3306"
        params["database"] = "server"
        params["username"] = "root"
        params["password"] = "nilcode"
        params["author"] = "edoclin"
        params["parent_pkg"] = "server"
        params["module_name"] = "template"
        params["like_table"] = "t_" // 需要生成的表的公共前缀
        params["table_prefix"] = "t_" // 生成时忽略前缀
        generate(params)
        }
    // 其他代码
}
```
3. 了解`src/main/kotlin/server/template/config`目录下配置文件的作用
4. 运行测试`src/test/kotlin/server/template/ServerTemplateApplicationTests`


