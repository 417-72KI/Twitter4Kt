package jp.room417.twitter4kt.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.HttpRequest
import twitter4j.TwitterException
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken
import twitter4j.conf.ConfigurationContext

/** A wrapper of [twitter4j.auth.OAuthAuthorization] */
@Suppress("unused")
class OAuthAuthorization(private val auth: twitter4j.auth.OAuthAuthorization) : Authorization {
    constructor() : this(twitter4j.auth.OAuthAuthorization(ConfigurationContext.getInstance()))

    /** A wrapper of [twitter4j.auth.OAuthAuthorization.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(): RequestToken = withContext(Dispatchers.IO) { auth.oAuthRequestToken }

    /** A wrapper of [twitter4j.auth.OAuthAuthorization.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(callbackURL: String): RequestToken =
        withContext(Dispatchers.IO) { auth.getOAuthRequestToken(callbackURL) }

    /** A wrapper of [twitter4j.auth.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(): AccessToken = withContext(Dispatchers.IO) { auth.oAuthAccessToken }

    /** A wrapper of [twitter4j.auth.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(oauthVerifier: String): AccessToken =
        withContext(Dispatchers.IO) { auth.getOAuthAccessToken(oauthVerifier) }

    /** A wrapper of [twitter4j.auth.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(requestToken: RequestToken): AccessToken =
        withContext(Dispatchers.IO) { auth.getOAuthAccessToken(requestToken) }

    /** A wrapper of [twitter4j.auth.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(requestToken: RequestToken, oauthVerifier: String): AccessToken =
        withContext(Dispatchers.IO) { auth.getOAuthAccessToken(requestToken, oauthVerifier) }

    // @Throws(TwitterException::class)
    // suspend fun invalidateOAuthToken() = withContext(Dispatchers.IO){auth.invalidateOAuthToken()}

    // fun encodeParameters(httpParams: List<HttpParameter>): String = auth.encodeParameters()

    /** A wrapper of [twitter4j.auth.OAuthAuthorization.setOAuthConsumer] */
    fun setOAuthConsumer(consumerKey: String, consumerSecret: String) =
        auth.setOAuthConsumer(consumerKey, consumerSecret)

    override fun getAuthorizationHeader(req: HttpRequest): String = auth.getAuthorizationHeader(req)
    override fun isEnabled(): Boolean = auth.isEnabled

    override fun equals(other: Any?): Boolean = auth == (other as? OAuthAuthorization)?.auth
    override fun hashCode(): Int = auth.hashCode()
    override fun toString(): String = auth.toString()
}
