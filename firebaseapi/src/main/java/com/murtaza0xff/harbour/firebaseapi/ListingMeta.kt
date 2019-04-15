package com.murtaza0xff.harbour.firebaseapi

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.murtaza0xff.harbour.firebaseapi.models.SortOptions

data class ListingMeta(
    @StringRes val name: Int,
    @DrawableRes val icon: Int,
    val sortOption: SortOptions
)
