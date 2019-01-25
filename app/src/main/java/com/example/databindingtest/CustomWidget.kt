package com.example.databindingtest

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.*
import kotlinx.android.synthetic.main.custom_widget_layout.view.*




@BindingMethods(
    BindingMethod(
        type = CustomWidget::class,
        attribute = "app:show",
        method = "setShowContainer"
    ),
    BindingMethod(
        type = CustomWidget::class,
        attribute = "app:showAttrChanged",
        method = "setListener"
    )
)
@InverseBindingMethods(
    InverseBindingMethod(
        type = CustomWidget::class,
        attribute = "app:show",
        method = "isShowContainer"
    )
)
class CustomWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        View.inflate(context, R.layout.custom_widget_layout, this)
        hideContainer.setOnClickListener { hideContainer() }
    }

    var showed: Boolean = false

    fun setShowContainer(showed: Boolean) {
        this.showed = showed
        if(showed)
            showContainer()
        else
            hideContainer()
    }

    fun showContainer() {
        widgetContainer.visibility = View.VISIBLE
        showed = true
    }

    fun hideContainer() {
        widgetContainer.visibility = View.GONE
        showed = false
        if(listener != null)
            listener?.onChange()
    }

    fun isShowContainer(): Boolean {
        return showed
    }

    var listener: InverseBindingListener? = null
}

