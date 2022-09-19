package com.toolgeo.server.util.result

enum class ResultCode(val code: Int, val message: String) {
    SUCCESS(2000, "响应成功"),
    ERROR(5000, "服务器繁忙"),
    NOT_LOGIN(5100, "用户未登录"),
    PARAM_ERROR(5200, "参数错误"),
}