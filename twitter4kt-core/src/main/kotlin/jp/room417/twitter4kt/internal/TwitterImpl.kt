package jp.room417.twitter4kt.internal

import jp.room417.twitter4kt.Twitter
import jp.room417.twitter4kt.api.internal.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken

@Suppress("OverridingDeprecatedMember", "OVERRIDE_DEPRECATION")
internal class TwitterImpl(private val twitter: twitter4j.Twitter) : Twitter {
    override val origin = twitter

    override fun timelines() = TimelinesResourcesImpl(twitter)
    override fun tweets() = TweetsResourcesImpl(twitter)
    override fun search() = SearchResourceImpl(twitter)
    override fun directMessages() = DirectMessagesResourcesImpl(twitter)
    override fun friendsFollowers() = FriendsFollowersResourcesImpl(twitter)
    override fun users() = UsersResourcesImpl(twitter)
    override fun suggestedUsers() = SuggestedUsersResourcesImpl(twitter)
    override fun favorites() = FavoritesResourcesImpl(twitter)
    override fun list() = ListsResourcesImpl(twitter)
    override fun savedSearches() = SavedSearchesResourcesImpl(twitter)
    override fun placesGeo() = PlacesGeoResourcesImpl(twitter)
    override fun trends() = TrendsResourcesImpl(twitter)
    override fun spamReporting() = SpamReportingResourceImpl(twitter)
    override fun help() = HelpResourcesImpl(twitter)

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

    override fun clearOAuthAccessToken() {
        twitter.oAuthAccessToken = null
    }
}
