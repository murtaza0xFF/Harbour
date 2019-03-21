package com.murtaza0xff.harbour.algolia

import com.murtaza0xff.harbour.algolia.model.MatchingStory
import io.reactivex.Flowable

interface AlgoliaApi {

    fun getMatchingStories(): Flowable<MatchingStory>
}