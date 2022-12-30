package jp.room417.twitter4k

import jp.room417.twitter4k.auth.OAuthSupport
import jp.room417.twitter4k.util.letWith
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken

interface Twitter : OAuthSupport {
    @Suppress("unused")
    class Builder(
        private var consumerKey: String?, private var consumerSecret: String?
    ) {
        constructor() : this(null, null)

        private val factory = TwitterFactory()

        fun setOAuthConsumer(consumerKey: String, consumerSecret: String): Builder {
            this.consumerKey = consumerKey
            this.consumerSecret = consumerSecret
            return this
        }

        fun build(): Twitter = TwitterImpl(factory.instance).apply {
            consumerKey?.letWith(consumerSecret) { key, secret ->
                setOAuthConsumer(key, secret)
            }
        }
    }
}

internal class TwitterImpl(internal val twitter: twitter4j.Twitter) : Twitter {
    // OAuthSupport
    override fun setOAuthConsumer(consumerKey: String, consumerSecret: String) =
        twitter.setOAuthConsumer(consumerKey, consumerSecret)

    override suspend fun getOAuthRequestToken(callbackURL: String): RequestToken =
        withContext(Dispatchers.IO) {
            twitter.getOAuthRequestToken(callbackURL)
        }

    override suspend fun getOAuthRequestToken(
        callbackURL: String,
        xAuthAccessType: String
    ): RequestToken = withContext(Dispatchers.IO) {
        twitter.getOAuthRequestToken(callbackURL, xAuthAccessType)
    }

    override suspend fun getOAuthRequestToken(
        callbackURL: String,
        xAuthAccessType: String,
        xAuthMode: String
    ): RequestToken = withContext(Dispatchers.IO) {
        twitter.getOAuthRequestToken(callbackURL, xAuthAccessType, xAuthMode)
    }

    override suspend fun getOAuthAccessToken(): AccessToken = withContext(Dispatchers.IO) {
        twitter.oAuthAccessToken
    }

    override suspend fun getOAuthAccessToken(oauthVerifier: String): AccessToken =
        withContext(Dispatchers.IO) {
            twitter.getOAuthAccessToken(oauthVerifier)
        }

    override suspend fun getOAuthAccessToken(requestToken: RequestToken): AccessToken =
        withContext(Dispatchers.IO) {
            twitter.getOAuthAccessToken(requestToken)
        }

    override suspend fun getOAuthAccessToken(
        requestToken: RequestToken,
        oauthVerifier: String
    ): AccessToken = withContext(Dispatchers.IO) {
        twitter.getOAuthAccessToken(requestToken, oauthVerifier)
    }

    override suspend fun getOAuthAccessToken(screenName: String, password: String): AccessToken =
        withContext(Dispatchers.IO) {
            twitter.getOAuthAccessToken(screenName, password)
        }

    override suspend fun setOAuthAccessToken(accessToken: AccessToken) =
        withContext(Dispatchers.IO) {
            twitter.oAuthAccessToken = accessToken
        }

    override suspend fun getOAuthRequestToken(): RequestToken = withContext(Dispatchers.IO) {
        twitter.oAuthRequestToken
    }
}

