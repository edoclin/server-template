package server.template.util.tencent.cos

object AllowActionsBuilder {
    private val allowActions: Array<String> = arrayOf()
    fun forPutObject(): AllowActionsBuilder {
        allowActions.plus("name/cos:PutObject")
        return this
    }

    fun forPutBucket(): AllowActionsBuilder {
        allowActions.plus("name/cos:PutBucket")
        return this
    }

    fun forPostObject(): AllowActionsBuilder {
        allowActions.plus("name/cos:PostObject")
        return this
    }
    fun forInitiateMultipartUpload(): AllowActionsBuilder {
        allowActions.plus("name/cos:InitiateMultipartUpload")
        return this
    }
    fun forListMultipartUploads(): AllowActionsBuilder {
        allowActions.plus("name/cos:ListMultipartUploads")
        return this
    }
    fun forListParts(): AllowActionsBuilder {
        allowActions.plus("name/cos:ListParts")
        return this
    }
    fun forUploadPart(): AllowActionsBuilder {
        allowActions.plus("name/cos:UploadPart")
        return this
    }
    fun forCompleteMultipartUpload(): AllowActionsBuilder {
        allowActions.plus("name/cos:CompleteMultipartUpload")
        return this
    }

    fun build(): Array<String> {
        return allowActions
    }
}