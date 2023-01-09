package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.PlacesGeoResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.GeoQuery
import twitter4j.v1.Place
import twitter4j.v1.ResponseList

internal class PlacesGeoResourcesImpl(private val placesGeo: twitter4j.v1.PlacesGeoResources) : PlacesGeoResources {
    override suspend fun getGeoDetails(placeId: String): Place = withContext(Dispatchers.IO) {
        placesGeo.getGeoDetails(placeId)
    }

    override suspend fun reverseGeoCode(query: GeoQuery): ResponseList<Place> = withContext(Dispatchers.IO) {
        placesGeo.reverseGeoCode(query)
    }

    override suspend fun searchPlaces(query: GeoQuery): ResponseList<Place> = withContext(Dispatchers.IO) {
        placesGeo.searchPlaces(query)
    }
}
