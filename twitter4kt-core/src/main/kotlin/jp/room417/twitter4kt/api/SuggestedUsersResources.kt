package jp.room417.twitter4kt.api

import twitter4j.Category
import twitter4j.ResponseList
import twitter4j.TwitterException
import twitter4j.User

/** A wrapper of [twitter4j.api.SuggestedUsersResources] */
interface SuggestedUsersResources {
    /** A wrapper of [twitter4j.api.SuggestedUsersResources.getUserSuggestions] */
    @Throws(TwitterException::class)
    suspend fun getUserSuggestions(categorySlug: String): ResponseList<User>

    /** A wrapper of [twitter4j.api.SuggestedUsersResources.getSuggestedUserCategories] */
    @Throws(TwitterException::class)
    suspend fun getSuggestedUserCategories(): ResponseList<Category>

    /** A wrapper of [twitter4j.api.SuggestedUsersResources.getMemberSuggestions] */
    @Throws(TwitterException::class)
    suspend fun getMemberSuggestions(categorySlug: String): ResponseList<User>
}
