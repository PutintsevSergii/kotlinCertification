package com.certification.putintsevsergii.certification.networking.data

import com.squareup.moshi.Json

data class Feed(
        @Json(name = "results") val results:  List<Result>
)