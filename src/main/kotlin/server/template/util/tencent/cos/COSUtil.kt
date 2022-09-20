package server.template.util.tencent.cos

import cn.hutool.core.date.DateUtil
import cn.hutool.core.io.resource.ClassPathResource
import cn.hutool.setting.Setting
import com.tencent.cloud.CosStsClient
import com.tencent.cloud.Response
import com.toolgeo.server.util.result.ResultBean
import com.toolgeo.server.util.result.ResultUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import java.util.*


object COSUtil {
    var region: String? = null
    var bucket: String? = null
    var secretId: String? = null
    var secretKey: String? = null

    init {
        val setting = Setting("tencent.cos.config")
        region = setting["region"]
        bucket = setting["bucket"]
        secretId = setting["secretId"]
        secretKey = setting["secretKey"]
    }

    fun temporaryToken(durationSeconds: Number = 1800, allowPrefixes: Array<String> = arrayOf("*"), allowActions: Array<String> = arrayOf("*")): ResultBean {
        val config = TreeMap<String, Any?>()
        try {
            config["secretId"] = secretId
            config["secretKey"] = secretKey
            // 临时密钥有效时长，单位是秒，默认 1800 秒，目前主账号最长 2 小时（即 7200 秒），子账号最长 36 小时（即 129600）秒
            config["durationSeconds"] = durationSeconds
            config["bucket"] = bucket
            config["region"] = region

            // 这里改成允许的路径前缀，可以根据自己网站的用户登录态判断允许上传的具体路径
            // 列举几种典型的前缀授权场景：
            // 1、允许访问所有对象："*"
            // 2、允许访问指定的对象："a/a1.txt", "b/b1.txt"
            // 3、允许访问指定前缀的对象："a*", "a/*", "b/*"
            // 如果填写了“*”，将允许用户访问所有资源；除非业务需要，否则请按照最小权限原则授予用户相应的访问权限范围。
            config["allowPrefixes"] = allowPrefixes

            // 密钥的权限列表。必须在这里指定本次临时密钥所需要的权限。
            // 简单上传、表单上传和分块上传需要以下的权限，其他权限列表请看 https://cloud.tencent.com/document/product/436/31923
//            val allowActions = arrayOf(
//                "name/cos:PutObject",
//                "name/cos:PutBucket",
//                "name/cos:PostObject",
//                "name/cos:InitiateMultipartUpload",
//                "name/cos:ListMultipartUploads",
//                "name/cos:ListParts",
//                "name/cos:UploadPart",
//                "name/cos:CompleteMultipartUpload"
//            )
            config["allowActions"] = allowActions
            val startTime: Long = DateUtil.currentSeconds()
            val expiredTime: Long = startTime + durationSeconds.toLong()
            val response: Response = CosStsClient.getCredential(config)
            return ResultUtil.ok(COSTemporaryToken(response.credentials.tmpSecretId, response.credentials.tmpSecretKey, response.credentials.sessionToken, startTime, expiredTime))
        } catch (e: Exception) {
            e.printStackTrace()
            return ResultUtil.error()
        }
    }

    fun COSConfig(): ResultBean {
        return ResultUtil.ok(COSConfig(region, bucket))
    }
}