package server.template.entity

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableLogic
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.time.LocalDateTime

/**
 * <p>
 * 测试用户表
 * </p>
 *
 * @author edoclin
 * @since 2022-09-19
 */
@TableName("t_template_user")
class TemplateUser : Serializable {

    @TableId(value = "user_id", type = IdType.ASSIGN_UUID)
    var userId: String? = null

    /**
     * 测试信息字段
     */
    var info: String? = null

    /**
     * 记录创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    var createdTime: LocalDateTime? = null

    /**
     * 记录更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    var updatedTime: LocalDateTime? = null

    /**
     * 逻辑删除字段
     */
    @TableLogic
    var deleted: Boolean? = null

    override fun toString(): String {
        return "TemplateUser{" +
        "userId=" + userId +
        ", info=" + info +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        ", deleted=" + deleted +
        "}"
    }
}
