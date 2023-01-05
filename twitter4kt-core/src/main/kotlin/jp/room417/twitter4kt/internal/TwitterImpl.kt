package jp.room417.twitter4kt.internal

import jp.room417.twitter4kt.Twitter
import jp.room417.twitter4kt.api.internal.SearchResourceImpl
import jp.room417.twitter4kt.api.internal.TimelinesResourcesImpl
import jp.room417.twitter4kt.api.internal.TweetsResourcesImpl
import jp.room417.twitter4kt.api.internal.UsersResourcesImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken

internal class TwitterImpl(private val twitter: twitter4j.Twitter) : Twitter {
    override val origin = twitter

    override fun timelines() = TimelinesResourcesImpl(twitter)
    override fun tweets() = TweetsResourcesImpl(twitter)
    override fun search() = SearchResourceImpl(twitter)
    override fun users() = UsersResourcesImpl(twitter)

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

    override suspend fun getOAuthAccessToken(): AccessToken = withContext(Dispatchers.IO) { twitter.oAuthAccessToken }

    override suspend fun getOAuthAccessToken(oauthVerifier: String): AccessToken = withContext(Dispatchers.IO) {
        twitter.getOAuthAccessToken(oauthVerifier)
    }

    override suspend fun getOAuthAccessToken(requestToken: RequestToken): AccessToken = withContext(Dispatchers.IO) {
        twitter.getOAuthAccessToken(requestToken)
    }

    override suspend fun getOAuthAccessToken(
        requestToken: RequestToken,
        oauthVerifier: String
    ): AccessToken = withContext(Dispatchers.IO) {
        twitter.getOAuthAccessToken(
            requestToken,
            oauthVerifier
        )
    }

    override suspend fun getOAuthAccessToken(
        screenName: String,
        password: String
    ): AccessToken = withContext(Dispatchers.IO) {
        twitter.getOAuthAccessToken(
            screenName,
            password
        )
    }

    override fun setOAuthAccessToken(accessToken: AccessToken) {
        twitter.oAuthAccessToken = accessToken
    }
}
