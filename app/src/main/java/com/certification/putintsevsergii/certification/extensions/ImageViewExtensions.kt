package com.certification.putintsevsergii.certification.extensions

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.show(imageUrl: String? = "") {
    if (imageUrl == null) return

    if(imageUrl.isBlank()) return

    if (context == null) return

    val ctx = context
    if (ctx is Activity && (ctx.isFinishing || ctx.isDestroyed)) return

    Glide.with(ctx)
            .load(imageUrl)
            .into(this)
}

fun ImageView.show(imageUri: Uri) {
    if (context == null) return

    val ctx = context
    if (ctx is Activity && (ctx.isFinishing || ctx.isDestroyed)) return

    Glide.with(context)
            .load(imageUri)
            .into(this)
}