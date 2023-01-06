package jp.room417.twitter4kt.api.internal

import jp.room417.twitter4kt.api.SuggestedUsersResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.Category
import twitter4j.ResponseList
import twitter4j.Twitter
import twitter4j.User

internal class SuggestedUsersResourcesImpl(private val twitter: Twitter) : SuggestedUsersResources {
    override suspend fun getUserSuggestions(categorySlug: String): ResponseList<User> =
        withContext(Dispatchers.IO) { twitter.getUserSuggestions(categorySlug) }

    override suspend fun getSuggestedUserCategories(): ResponseList<Category> =
        withContext(Dispatchers.IO) { twitter.suggestedUserCategories }

    override suspend fun getMemberSuggestions(categorySlug: String): ResponseList<User> =
        withContext(Dispatchers.IO) { twitter.getMemberSuggestions(categorySlug) }
}
