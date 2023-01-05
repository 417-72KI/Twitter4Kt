package jp.room417.twitter4kt.api.internal

import jp.room417.twitter4kt.api.SearchResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.Query
import twitter4j.QueryResult
import twitter4j.Twitter

class SearchResourceImpl(private val twitter: Twitter) : SearchResource {
    override suspend fun search(query: Query): QueryResult = withContext(Dispatchers.IO) {
        twitter.search(query)
    }
}
