package jp.room417.twitter4kt.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.TwitterException
import twitter4j.auth.OAuth2Token
import twitter4j.conf.ConfigurationContext

/** A wrapper of [twitter4j.auth.OAuth2Authorization] */
@Suppress("unused")
class OAuth2Authorization(override val auth: twitter4j.auth.OAuth2Authorization) : Authorization {
    constructor() : this(twitter4j.auth.OAuth2Authorization(ConfigurationContext.getInstance()))

    /** A wrapper of [twitter4j.auth.OAuth2Authorization.setOAuthConsumer] */
    fun setOAuthConsumer(consumerKey: String, consumerSecret: String) =
        auth.setOAuthConsumer(consumerKey, consumerSecret)

    /** A wrapper of [twitter4j.auth.OAuth2Authorization.getOAuth2Token] */
    @Throws(TwitterException::class)
    suspend fun getOAuth2Token(): OAuth2Token = withContext(Dispatchers.IO) { auth.oAuth2Token }

    /** A wrapper of [twitter4j.auth.OAuth2Authorization.setOAuth2Token] */
    fun setOAuth2Token(oauth2Token: OAuth2Token) {
        auth.oAuth2Token = oauth2Token
    }

    /** A wrapper of [twitter4j.auth.OAuth2Authorization.invalidateOAuth2Token] */
    @Throws(TwitterException::class)
    suspend fun invalidateOAuth2Token() = withContext(Dispatchers.IO) { auth.invalidateOAuth2Token() }

    override fun equals(other: Any?): Boolean = auth == (other as? OAuth2Authorization)?.auth
    override fun hashCode(): Int = auth.hashCode()
    override fun toString(): String = auth.toString()
}
