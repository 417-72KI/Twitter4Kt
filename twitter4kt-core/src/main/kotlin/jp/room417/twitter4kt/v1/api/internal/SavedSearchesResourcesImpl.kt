package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.SavedSearchesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.ResponseList
import twitter4j.v1.SavedSearch

internal class SavedSearchesResourcesImpl(private val savedSearches: twitter4j.v1.SavedSearchesResources) : SavedSearchesResources {
    override suspend fun getSavedSearches(): ResponseList<SavedSearch> = withContext(Dispatchers.IO) {
        savedSearches.savedSearches
    }

    override suspend fun showSavedSearch(id: Long): SavedSearch = withContext(Dispatchers.IO) {
        savedSearches.showSavedSearch(id)
    }

    override suspend fun createSavedSearch(query: String): SavedSearch = withContext(Dispatchers.IO) {
        savedSearches.createSavedSearch(query)
    }

    override suspend fun destroySavedSearch(id: Long): SavedSearch = withContext(Dispatchers.IO) {
        savedSearches.destroySavedSearch(id)
    }
}
