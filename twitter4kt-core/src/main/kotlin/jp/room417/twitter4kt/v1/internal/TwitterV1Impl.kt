package jp.room417.twitter4kt.v1.internal

import jp.room417.twitter4kt.v1.TwitterV1
import jp.room417.twitter4kt.v1.api.internal.*

internal class TwitterV1Impl(private val twitterV1: twitter4j.v1.TwitterV1) : TwitterV1 {
    override fun timelines() = TimelinesResourcesImpl(twitterV1.timelines())
    override fun tweets() = TweetsResourcesImpl(twitterV1.tweets())
    override fun search() = SearchResourceImpl(twitterV1.search())
    override fun directMessages() = DirectMessagesResourcesImpl(twitterV1.directMessages())
    override fun friendsFollowers() = FriendsFollowersResourcesImpl(twitterV1.friendsFollowers())
    override fun users() = UsersResourcesImpl(twitterV1.users())
    override fun favorites() = FavoritesResourcesImpl(twitterV1.favorites())
    override fun list() = ListsResourcesImpl(twitterV1.list())
    override fun savedSearches() = SavedSearchesResourcesImpl(twitterV1.savedSearches())
    override fun placesGeo() = PlacesGeoResourcesImpl(twitterV1.placesGeo())
    override fun trends() = TrendsResourcesImpl(twitterV1.trends())
    override fun spamReporting() = SpamReportingResourceImpl(twitterV1.spamReporting())
    override fun help() = HelpResourcesImpl(twitterV1.help())
}
