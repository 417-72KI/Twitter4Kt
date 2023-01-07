package jp.room417.twitter4kt.auth

import twitter4j.HttpRequest
import java.io.Serializable

/** A wrapper of [twitter4j.auth.Authorization] */
interface Authorization : Serializable {
    /** A wrapper of [twitter4j.auth.Authorization.getAuthorizationHeader] */
    fun getAuthorizationHeader(req: HttpRequest): String

    /** A wrapper of [twitter4j.auth.Authorization.isEnabled] */
    fun isEnabled(): Boolean
}
