package com.murtaza0xff.harbour.firebaseapi.network

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.murtaza0xff.harbour.firebaseapi.models.NewStory
import com.squareup.moshi.Moshi
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.Ignore
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class FirebaseServiceTest {

    init {
        MockKAnnotations.init(this)
    }

    @MockK
    lateinit var firebaseDatabase: FirebaseDatabase
    @MockK
    lateinit var moshi: Moshi
    @MockK
    lateinit var databaseReference: DatabaseReference

    private lateinit var service: FirebaseService

    @Ignore
    @Test
    @DisplayName("When page 0 is requested with elements per page = 25, should return the first 25 posts")
    fun retrieveFirst25Posts_givenPageNumber0AndItemsPerPage25() {
        service = FirebaseService(firebaseDatabase, moshi)

        every { firebaseDatabase.getReference(any()) } returns databaseReference
        every { databaseReference.removeEventListener(any<ValueEventListener>()) } answers { }

        service
            .fetchItem(NewStory(), 0, 25)
//            .concatMapEager {
//                service.fetchDetailsFromItemId(it)
//            }
            .test()

//        verify(exactly = 25) { service.fetchDetailsFromItemId(any()) }
    }
}