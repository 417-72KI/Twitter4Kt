package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.SearchResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.Query
import twitter4j.v1.QueryResult

internal class SearchResourceImpl(private val search: twitter4j.v1.SearchResource) : SearchResource {
    override suspend fun search(query: Query): QueryResult = withContext(Dispatchers.IO) {
        search.search(query)
    }
}
