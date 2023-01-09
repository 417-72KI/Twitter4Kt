package jp.room417.twitter4kt.auth

import java.io.Serializable

/** A wrapper of [twitter4j.auth.Authorization] */
interface Authorization : Serializable {
    /** A wrapped instance */
    val auth: twitter4j.auth.Authorization
}
