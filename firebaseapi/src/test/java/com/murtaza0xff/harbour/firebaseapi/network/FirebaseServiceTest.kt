package com.murtaza0xff.harbour.firebaseapi.network

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.murtaza0xff.harbour.firebaseapi.models.HackerNewsItem
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(MockKExtension::class)
class FirebaseServiceTest {

    @MockK
    lateinit var firebaseDatabase: FirebaseDatabase
    @RelaxedMockK
    lateinit var databaseReference: DatabaseReference
    @MockK
    lateinit var dataSnapshot: DataSnapshot
    private lateinit var service: FirebaseService
    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()
    @MockK
    lateinit var hackerNewsItem: HackerNewsItem

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        service = FirebaseService(firebaseDatabase)
    }


    @Test
    fun testObserveHnRoute_valueOfDataSnapshotEmittedSameAsProvided() {
        val slot = CapturingSlot<ValueEventListener>()
        val childrenList = mockk<MutableList<DataSnapshot>>(relaxed = true)

        every { childrenList.size } returns 500
        every { dataSnapshot.children } returns childrenList
        every { dataSnapshot.value } returns 1L
        every { firebaseDatabase.getReference(any()) } returns databaseReference


        val testSubscriber = service
            .observeHnRoute(databaseReference)
            .test()

        verify {
            databaseReference.addValueEventListener(capture(slot))
        }
        slot.captured.onDataChange(dataSnapshot)

        testSubscriber
            .assertNoErrors()
            .assertValue {
                it.value == 1L
            }
            .dispose()
    }

    @Test
    fun testFetchHnItemFromId_retrieveHackerNewsItemFromIdProvided(){
        val slot = CapturingSlot<ValueEventListener>()
        every { hackerNewsItem.id } returns 19526679
        every { firebaseDatabase.getReference(any()) } returns databaseReference
        every { dataSnapshot.getValue(HackerNewsItem::class.java) } returns hackerNewsItem

        val testSubscriber = service
            .fetchHnItemFromId(Flowable.just(19526679))
            .test()

        verify {
            databaseReference.addValueEventListener(capture(slot))
        }
        slot.captured.onDataChange(dataSnapshot)

        testSubscriber
            .assertValue {
                it.id == 19526679L
            }
    }

}