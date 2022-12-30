package jp.room417.twitter4k

import jp.room417.twitter4k.api.TimelinesResources
import jp.room417.twitter4k.api.TimelinesResourcesImpl
import jp.room417.twitter4k.api.TweetsResources
import jp.room417.twitter4k.api.TweetsResourcesImpl
import jp.room417.twitter4k.auth.OAuthSupport
import jp.room417.twitter4k.util.letWith
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken

interface Twitter : OAuthSupport {
    fun timelines(): TimelinesResources
    fun tweets(): TweetsResources

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    class Builder(
        private var consumerKey: String?,
        private var consumerSecret: String?,
        private var accessToken: AccessToken?
    ) {
        constructor() : this(null, null, null)

        private val factory = TwitterFactory()

        fun setOAuthConsumer(
            consumerKey: String,
            consumerSecret: String
        ): Builder {
            this.consumerKey = consumerKey
            this.consumerSecret = consumerSecret
            return this
        }

        fun setOAuthAccessToken(accessToken: AccessToken): Builder {
            this.accessToken = accessToken
            return this
        }

        fun setOAuthAccessToken(token: String, tokenSecret: String) =
            setOAuthAccessToken(AccessToken(token, tokenSecret))

        fun build(): Twitter = TwitterImpl(factory.instance).apply {
            consumerKey?.letWith(consumerSecret) { key, secret ->
                setOAuthConsumer(key, secret)
            }
            accessToken?.let {
                setOAuthAccessToken(it)
            }
        }
    }
}

internal class TwitterImpl(private val twitter: twitter4j.Twitter) : Twitter {
    override fun timelines() = TimelinesResourcesImpl(twitter)
    override fun tweets() = TweetsResourcesImpl(twitter)

    // OAuthSupport
    override fun setOAuthConsumer(
        consumerKey: String,
        consumerSecret: String
    ) = twitter.setOAuthConsumer(
        consumerKey,
        consumerSecret
    )

    override suspend fun getOAuthRequestToken(): RequestToken = withContext(Dispatchers.IO) {
        twitter.oAuthRequestToken
    }

    override suspend fun getOAuthRequestToken(callbackURL: String): RequestToken =
        withContext(Dispatchers.IO) {
            twitter.getOAuthRequestToken(callbackURL)
        }

    override suspend fun getOAuthRequestToken(
        callbackURL: String,
        xAuthAccessType: String
    ): RequestToken = withContext(Dispatchers.IO) {
        twitter.getOAuthRequestToken(
            callbackURL,
            xAuthAccessType
        )
    }

    override suspend fun getOAuthRequestToken(
        callbackURL: String,
        xAuthAccessType: String,
        xAuthMode: String
    ): RequestToken = withContext(Dispatchers.IO) {
        twitter.getOAuthRequestToken(
            callbackURL,
            xAuthAccessType,
            xAuthMode
        )
    }

    override fun getOAuthAccessToken(): AccessToken = twitter.oAuthAccessToken

    override fun getOAuthAccessToken(oauthVerifier: String): AccessToken =
        twitter.getOAuthAccessToken(oauthVerifier)

    override fun getOAuthAccessToken(requestToken: RequestToken): AccessToken =
        twitter.getOAuthAccessToken(requestToken)

    override fun getOAuthAccessToken(
        requestToken: RequestToken,
        oauthVerifier: String
    ): AccessToken = twitter.getOAuthAccessToken(
        requestToken,
        oauthVerifier
    )

    override fun getOAuthAccessToken(
        screenName: String,
        password: String
    ): AccessToken = twitter.getOAuthAccessToken(
        screenName,
        password
    )

    override fun setOAuthAccessToken(accessToken: AccessToken) {
        twitter.oAuthAccessToken = accessToken
    }
}

