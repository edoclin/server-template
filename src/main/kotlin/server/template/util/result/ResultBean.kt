package com.toolgeo.server.util.result

data class ResultBean(val code: Int, val message: String = "响应成功", val data: Any? = null) {

}