package jp.room417.twitter4kt.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.OAuth2Token
import twitter4j.TwitterException

/** A wrapper of [twitter4j.OAuth2Authorization] */
@Suppress("unused")
class OAuth2Authorization(override val auth: twitter4j.OAuth2Authorization) : Authorization {
    constructor(consumerKey: String, consumerSecret: String) : this(twitter4j.OAuth2Authorization.getInstance(consumerKey, consumerSecret))
    constructor() : this(twitter4j.OAuth2Authorization.getInstance())

    /** A wrapper of [twitter4j.OAuth2Authorization.getOAuth2Token] */
    @Throws(TwitterException::class)
    suspend fun getOAuth2Token(): OAuth2Token = withContext(Dispatchers.IO) { auth.oAuth2Token }

    /** A wrapper of [twitter4j.OAuth2Authorization.invalidateOAuth2Token] */
    @Throws(TwitterException::class)
    suspend fun invalidateOAuth2Token() = withContext(Dispatchers.IO) { auth.invalidateOAuth2Token() }

    override fun equals(other: Any?): Boolean = auth == (other as? OAuth2Authorization)?.auth
    override fun hashCode(): Int = auth.hashCode()
    override fun toString(): String = auth.toString()
}
