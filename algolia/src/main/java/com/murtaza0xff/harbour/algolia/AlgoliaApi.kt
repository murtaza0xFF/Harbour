package com.murtaza0xff.harbour.algolia

import com.murtaza0xff.harbour.algolia.model.MatchingComment
import com.murtaza0xff.harbour.algolia.model.MatchingStory
import com.murtaza0xff.harbour.algolia.model.MatchingUrl
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface AlgoliaApi {

    @GET("/search?tags=story")
    fun getMatchingStories(@Query("query") query: String): Flowable<MatchingStory>

    @GET("/search?tags=comment")
    fun getMatchingComments(@Query("query") query: String): Flowable<MatchingComment>

    @GET("/search?restrictSearchableAttributes=url")
    fun getMatchingUrl(@Query("query") query: String): Flowable<MatchingUrl>

}