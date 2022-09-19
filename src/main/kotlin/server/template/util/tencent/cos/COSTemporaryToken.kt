package server.template.util.tencent.cos

data class COSTemporaryToken(
    var tmpSecretId: String,
    var tmpSecretKey: String,
    var sessionToken: String,
    var startTime: Number,
    var expiredTime: Number,
)