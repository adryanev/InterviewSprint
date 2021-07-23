package dev.adryanev.sprint.interviewsprint.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import dev.adryanev.sprint.interviewsprint.data.constants.Constants

object BindingAdapters {
    @BindingAdapter(
        value = [
            "imageUrl",
            "thumbnailUrl",
            "placeholder",
            "errorDrawable",
            "requestListener",
            "centerCrop",
            "fitCenter",
            "circleCrop",
            "skipMemoryCache",
            "diskCacheStrategy",
            "signatureKey"
        ],
        requireAll = false
    )
    @JvmStatic
    fun ImageView.loadImage(
        imageUrl: String? = null,
        thumbnailUrl: String? = null,
        placeHolderDrawable: Drawable? = null,
        errorDrawable: Drawable? = null,
        requestListener: RequestListener<Drawable>? = null,
        centerCrop: Boolean = false,
        fitCenter: Boolean = false,
        circleCrop: Boolean = false,
        skipMemoryCache: Boolean? = null,
        diskCacheStrategy: DiskCacheStrategy? = null,
        signatureKey: String? = null
    ) {
        if (imageUrl.isNullOrBlank()) {
            if (placeHolderDrawable != null) setImageDrawable(placeHolderDrawable)
            return
        }

        val requestOptions = RequestOptions().apply {
            if (skipMemoryCache != null) skipMemoryCache(skipMemoryCache)
            diskCacheStrategy(diskCacheStrategy ?: DiskCacheStrategy.RESOURCE)

            if (placeHolderDrawable != null) placeholder(placeHolderDrawable)
            if (errorDrawable != null) error(errorDrawable)

            // crop type
            if (centerCrop) centerCrop()
            if (fitCenter) fitCenter()
            if (circleCrop) circleCrop()

            if (!signatureKey.isNullOrBlank()) {
                signature(ObjectKey(signatureKey))
            }
        }

        Glide.with(context).load(imageUrl).apply {
            transition(DrawableTransitionOptions.withCrossFade())
            addListener(requestListener)
            apply(requestOptions)
        }.into(this)
    }

    @BindingAdapter("onSingleClick")
    @JvmStatic
    fun View.setSingleClick(execution: () -> Unit) {
        setOnClickListener(object : View.OnClickListener {
            var lastClickTime: Long = 0

            override fun onClick(p0: View?) {
                if (System.currentTimeMillis() - lastClickTime < Constants.THRESHOLD_CLICK_TIME) return
                lastClickTime = System.currentTimeMillis()
                execution.invoke()
            }
        })
    }

    @BindingAdapter("enableRefresh")
    @JvmStatic
    fun SwipeRefreshLayout.enableRefresh(enable: Boolean?) {
        isEnabled = enable == true
    }
}