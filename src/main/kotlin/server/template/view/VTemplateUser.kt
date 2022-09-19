package server.template.view

import com.fasterxml.jackson.annotation.JsonInclude

// 转为JSON时忽略值为null的属性
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class VTemplateUser {
    var userId: String? = null
    var info: String? = null
    var createdTime: String? = null
    var updatedTime: String? = null
}