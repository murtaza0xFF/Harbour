package com.murtaza0xff.harbour.firebaseapi.network

import com.google.firebase.database.*
import com.murtaza0xff.harbour.firebaseapi.models.HackerNewsItem
import com.murtaza0xff.harbour.firebaseapi.models.SealedStory
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class FirebaseService @Inject constructor(private val firebaseDatabase: FirebaseDatabase, private val moshi: Moshi) {

    fun fetchItems(sealedStory: SealedStory, page: Int, itemsPerPage: Long = 25): Observable<HackerNewsItem>? {
        return fetchItemIds(sealedStory, page, itemsPerPage)
            .map { it.value as Long }
            .concatMapEager(this::fetchDetailsFromItemId)
            .map(HackerNewsItem.Companion::create)
    }

    private fun fetchItemIds(sealedStory: SealedStory, page: Int, itemsPerPage: Long = 25): Observable<DataSnapshot> {
        return getSelectedFeed(sealedStory)
            .flattenAsObservable { it.children }
            .skip(page.plus(1).times(itemsPerPage).minus(itemsPerPage))
            .take(itemsPerPage)
    }

    private fun getSelectedFeed(sealedStory: SealedStory): Single<DataSnapshot> = observeValueEvent(
        firebaseDatabase.getReference(sealedStory.route)
    )

    private fun observeValueEvent(query: Query): Single<DataSnapshot> {
        return Single.create { emitter ->
            val valueEventListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    emitter.onSuccess(dataSnapshot)
                }

                override fun onCancelled(error: DatabaseError) {
                    emitter.onError(error.toException())
                }
            }
            emitter.setCancellable {
                query.removeEventListener(valueEventListener)
            }
            query.addValueEventListener(valueEventListener)
        }
    }

    private fun fetchDetailsFromItemId(id: Long): Observable<DataSnapshot> {
        return Observable.create<DataSnapshot> {
            val ref = firebaseDatabase.getReference("v0/item/$id")
            val listener = object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    it.onError(error.toException())
                }

                override fun onDataChange(data: DataSnapshot) {
                    it.onNext(data)
                    it.onComplete()
                }
            }
            it.setCancellable {
                ref.removeEventListener(listener)
            }
            ref.addValueEventListener(listener)
        }
    }
}