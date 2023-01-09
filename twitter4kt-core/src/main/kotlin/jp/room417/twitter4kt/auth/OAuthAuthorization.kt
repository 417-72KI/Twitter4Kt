package jp.room417.twitter4kt.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.AccessToken
import twitter4j.RequestToken
import twitter4j.TwitterException

/** A wrapper of [twitter4j.OAuthAuthorization] */
@Suppress("unused")
class OAuthAuthorization(override val auth: twitter4j.OAuthAuthorization) : Authorization {
    constructor(consumerKey: String, consumerSecret: String) : this(twitter4j.OAuthAuthorization.getInstance(consumerKey, consumerSecret))
    constructor() : this(twitter4j.OAuthAuthorization.getInstance())

    /** A wrapper of [twitter4j.OAuthAuthorization.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(): RequestToken = withContext(Dispatchers.IO) { auth.oAuthRequestToken }

    /** A wrapper of [twitter4j.OAuthAuthorization.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(callbackURL: String): RequestToken = withContext(Dispatchers.IO) {
        auth.getOAuthRequestToken(callbackURL)
    }

    /** A wrapper of [twitter4j.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(): AccessToken = withContext(Dispatchers.IO) { auth.oAuthAccessToken }

    /** A wrapper of [twitter4j.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(oauthVerifier: String): AccessToken =
        withContext(Dispatchers.IO) { auth.getOAuthAccessToken(oauthVerifier) }

    /** A wrapper of [twitter4j.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(requestToken: RequestToken): AccessToken = withContext(Dispatchers.IO) {
        auth.getOAuthAccessToken(requestToken)
    }

    /** A wrapper of [twitter4j.OAuthAuthorization.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(
        requestToken: RequestToken,
        oauthVerifier: String
    ): AccessToken = withContext(Dispatchers.IO) {
        auth.getOAuthAccessToken(requestToken, oauthVerifier)
    }

    /** A wrapper of [twitter4j.OAuthAuthorization.invalidateOAuthToken] */
    @Throws(TwitterException::class)
    suspend fun invalidateOAuthToken() = withContext(Dispatchers.IO) { auth.invalidateOAuthToken() }

    override fun equals(other: Any?): Boolean = auth == (other as? OAuthAuthorization)?.auth
    override fun hashCode(): Int = auth.hashCode()
    override fun toString(): String = auth.toString()
}
