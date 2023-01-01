package jp.room417.twitter4kt.auth

import twitter4j.TwitterException
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken

/** A wrapper of [twitter4j.auth.OAuthSupport] */
interface OAuthSupport {
    /** A wrapper of [twitter4j.auth.OAuthSupport.setOAuthConsumer] */
    fun setOAuthConsumer(consumerKey: String, consumerSecret: String)

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(): RequestToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(callbackURL: String): RequestToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(callbackURL: String, xAuthAccessType: String): RequestToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthRequestToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthRequestToken(
        callbackURL: String,
        xAuthAccessType: String,
        xAuthMode: String
    ): RequestToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(): AccessToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(oauthVerifier: String): AccessToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(requestToken: RequestToken): AccessToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(requestToken: RequestToken, oauthVerifier: String): AccessToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.getOAuthAccessToken] */
    @Throws(TwitterException::class)
    suspend fun getOAuthAccessToken(screenName: String, password: String): AccessToken

    /** A wrapper of [twitter4j.auth.OAuthSupport.setOAuthAccessToken] */
    fun setOAuthAccessToken(accessToken: AccessToken)
}
