package com.toolgeo.server.util.result

object ResultUtil {
    private fun build(code: Int, message: String, data: Any?): ResultBean {
        return ResultBean(code, message, data)
    }

    fun ok(): ResultBean {
        return build(ResultCode.SUCCESS.code, ResultCode.SUCCESS.message, null)
    }


    fun ok(data: Any): ResultBean {
        return build(ResultCode.SUCCESS.code, ResultCode.SUCCESS.message, data)
    }

    fun ok(message: String, data: Any): ResultBean {
        return build(ResultCode.SUCCESS.code, message, data)
    }

    fun error(message: String): ResultBean {
        return build(ResultCode.ERROR.code, message, null)
    }

    fun error(): ResultBean {
        return build(ResultCode.ERROR.code, ResultCode.ERROR.message, null)
    }

    fun notLogin(): ResultBean {
        return build(ResultCode.NOT_LOGIN.code, ResultCode.NOT_LOGIN.message, null)
    }
}