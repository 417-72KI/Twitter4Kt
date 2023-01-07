package jp.room417.twitter4kt.v1.internal

import jp.room417.twitter4kt.api.internal.*
import jp.room417.twitter4kt.v1.TwitterV1
import twitter4j.Twitter

internal class TwitterV1Impl(private val twitter: Twitter) : TwitterV1 {
    override fun timelines() = TimelinesResourcesImpl(twitter)
    override fun tweets() = TweetsResourcesImpl(twitter)
    override fun search() = SearchResourceImpl(twitter)
    override fun directMessages() = DirectMessagesResourcesImpl(twitter)
    override fun friendsFollowers() = FriendsFollowersResourcesImpl(twitter)
    override fun users() = UsersResourcesImpl(twitter)

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember")
    override fun suggestedUsers() = SuggestedUsersResourcesImpl(twitter)
    override fun favorites() = FavoritesResourcesImpl(twitter)
    override fun list() = ListsResourcesImpl(twitter)
    override fun savedSearches() = SavedSearchesResourcesImpl(twitter)
    override fun placesGeo() = PlacesGeoResourcesImpl(twitter)
    override fun trends() = TrendsResourcesImpl(twitter)
    override fun spamReporting() = SpamReportingResourceImpl(twitter)
    override fun help() = HelpResourcesImpl(twitter)
}
