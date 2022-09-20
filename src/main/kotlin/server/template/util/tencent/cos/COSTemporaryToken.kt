package server.template.util.tencent.cos

data class COSTemporaryToken(
    var temporarySecretId: String,
    var temporarySecretKey: String,
    var sessionToken: String,
    var startTime: Number,
    var expiredTime: Number,
)