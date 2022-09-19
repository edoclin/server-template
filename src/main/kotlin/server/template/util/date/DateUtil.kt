package server.template.util.date

import cn.hutool.core.date.DateUtil
import cn.hutool.core.util.ObjectUtil
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * 日期格式化类
 */
object DateUtil {
    fun yyyyMMddHHmm(dateTime: LocalDateTime?): String? {
        return if (ObjectUtil.isNull(dateTime)) {
            null
        } else dateTime?.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分"))
    }

    fun yyyyMMdd(dateTime: LocalDateTime?): String? {
        return if (ObjectUtil.isNull(dateTime)) {
            null
        } else dateTime?.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"))
    }

    fun yyyyMMdd(dateTime: Date?): String? {
        return if (ObjectUtil.isNull(dateTime)) {
            null
        } else yyyyMMdd(DateUtil.toLocalDateTime(dateTime))
    }
}