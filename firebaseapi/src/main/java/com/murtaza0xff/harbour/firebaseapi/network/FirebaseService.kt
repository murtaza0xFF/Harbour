package com.murtaza0xff.harbour.firebaseapi.network

import com.google.firebase.database.*
import com.murtaza0xff.harbour.firebaseapi.SealedStory
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable


class FirebaseService {

    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance(" https://hacker-news.firebaseio.com/")

    fun fetchPage(sealedStory: SealedStory) {
        when (sealedStory) {
            is SealedStory.NewStory -> observeValueEvent(
                firebaseDatabase.getReference(sealedStory.route),
                BackpressureStrategy.LATEST
            )
            is SealedStory.BestStory -> observeValueEvent(
                firebaseDatabase.getReference(sealedStory.route),
                BackpressureStrategy.LATEST
            )
            is SealedStory.TopStory -> observeValueEvent(
                firebaseDatabase.getReference(sealedStory.route),
                BackpressureStrategy.LATEST
            )
        }
    }

    private fun observeValueEvent(query: Query, strategy: BackpressureStrategy): Flowable<DataSnapshot> {
        return Flowable.create({ emitter ->
            val valueEventListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    emitter.onNext(dataSnapshot)
                }

                override fun onCancelled(error: DatabaseError) {
                    if (!emitter.isCancelled)
                        emitter.onError(Throwable(error.message))
                }
            }
            emitter.setCancellable {
                query.removeEventListener(valueEventListener)
            }
            query.addValueEventListener(valueEventListener)
        }, strategy)
    }

}