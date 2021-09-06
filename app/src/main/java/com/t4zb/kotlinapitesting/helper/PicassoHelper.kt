package com.t4zb.kotlinapitesting.helper

import android.content.Context
import android.widget.ImageView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.t4zb.kotlinapitesting.modelLayer.rest.core.ImageUrlCore
import java.lang.Exception

/**
 * Our main library for rendering images will be Picasso
 * We are going to use it with [com.squareup.picasso.OkHttp3Downloader]
 * Our builder is going to be utilized with [com.t4zb.kotlinapitesting.modelLayer.rest.core.ImageUrlCore]
 *
 * ###  You may check :
 *
 * [com.squareup.picasso.Picasso]
 *
 * @author o00559125
 * @since 2021-08-23
 */
object PicassoHelper {

    fun picassoUtils(context: Context,pictureUrl: String, imageView: ShapeableImageView){
        val builder = Picasso.Builder(context.applicationContext)
        Picasso.get().load(pictureUrl).networkPolicy(NetworkPolicy.OFFLINE)
            .fit().centerCrop().into(imageView, object: Callback{
                override fun onSuccess() {

                }

                override fun onError(e: Exception?) {

                }
            })
    }

    fun picassoOkhttp(context: Context, pictureUrl: String, imageView: ImageView) {
        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder
            .build()
            .load(ImageUrlCore.buildImageCore(pictureUrl))
            .into(imageView)
    }
}