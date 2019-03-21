package com.murtaza0xff.harbour.algolia

import com.murtaza0xff.harbour.algolia.model.MatchingComment
import com.murtaza0xff.harbour.algolia.model.MatchingStory
import com.murtaza0xff.harbour.algolia.model.MatchingUrl
import com.murtaza0xff.harbour.algolia.remote.AlgoliaApi
import io.reactivex.Flowable
import javax.inject.Inject

class AlgoliaService @Inject constructor(val algoliaApi: AlgoliaApi) {

    fun getMatchingStories(query: String): Flowable<MatchingStory> {
        return algoliaApi
            .getMatchingStories(query)

    }

    fun getMatchingComments(query: String): Flowable<MatchingComment> {
        return algoliaApi
            .getMatchingComments(query)

    }

    fun getMatchingUrl(query: String): Flowable<MatchingUrl> {
        return algoliaApi
            .getMatchingUrl(query)

    }

}