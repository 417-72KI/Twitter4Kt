package jp.room417.twitter4kt.v1.api

import twitter4j.*

/** A wrapper of [twitter4j.api.PlacesGeoResources] */
interface PlacesGeoResources {
    /** A wrapper of [twitter4j.api.PlacesGeoResources.getGeoDetails] */
    @Throws(TwitterException::class)
    suspend fun getGeoDetails(placeId: String): Place

    /** A wrapper of [twitter4j.api.PlacesGeoResources.reverseGeoCode] */
    @Throws(TwitterException::class)
    suspend fun reverseGeoCode(query: GeoQuery): ResponseList<Place>

    /** A wrapper of [twitter4j.api.PlacesGeoResources.searchPlaces] */
    @Throws(TwitterException::class)
    suspend fun searchPlaces(query: GeoQuery): ResponseList<Place>

    /** A wrapper of [twitter4j.api.PlacesGeoResources.getSimilarPlaces] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getSimilarPlaces(
        location: GeoLocation,
        name: String,
        containedWithin: String,
        streetAddress: String
    ): ResponseList<Place>
}
