package com.certification.putintsevsergii.certification.networking.data

import com.squareup.moshi.Json

data class ChartsResponse(
        @Json(name = "feed")  val feed: Feed
)