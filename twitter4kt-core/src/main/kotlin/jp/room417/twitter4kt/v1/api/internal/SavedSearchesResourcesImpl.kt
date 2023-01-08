package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.SavedSearchesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.ResponseList
import twitter4j.SavedSearch
import twitter4j.Twitter

internal class SavedSearchesResourcesImpl(private val twitter: Twitter) : SavedSearchesResources {
    override suspend fun getSavedSearches(): ResponseList<SavedSearch> = withContext(Dispatchers.IO) {
        twitter.savedSearches
    }

    override suspend fun showSavedSearch(id: Long): SavedSearch = withContext(Dispatchers.IO) {
        twitter.showSavedSearch(id)
    }

    override suspend fun createSavedSearch(query: String): SavedSearch = withContext(Dispatchers.IO) {
        twitter.createSavedSearch(query)
    }

    override suspend fun destroySavedSearch(id: Long): SavedSearch = withContext(Dispatchers.IO) {
        twitter.destroySavedSearch(id)
    }
}
