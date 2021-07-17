package com.rahul.demo.app


import android.os.Bundle

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.rahul.demo.app.adapter.CustomerAdapter
import com.rahul.demo.app.collapsingavatar.DataFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var isCalculated = false
    private var mMaxWindoWidth = 0;
    var defaultLayoutWidth = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMaxWindoWidth = windowManager.defaultDisplay.width;
        val layoutParamMargin: ViewGroup.MarginLayoutParams =
            imgb_avatar_wrap.layoutParams as ViewGroup.MarginLayoutParams;
        defaultLayoutWidth = layoutParamMargin.width;
        val remainingWidth =
            mMaxWindoWidth - (defaultLayoutWidth + layoutParamMargin.leftMargin * 2);


        app_bar_layout.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, i ->
                if (isCalculated) {
                    isCalculated = false
                } else {
                    updateViews(i, appBarLayout.totalScrollRange, remainingWidth)
                }
            })

        recycleView.adapter= CustomerAdapter( DataFactory.getUserData())
    }

    private fun updateViews(i: Int, totalScrollRange: Int, remaingHeight: Int) {
        val heightFactorOnTotalScroll = -i * remaingHeight / totalScrollRange
        val perOnTotal = heightFactorOnTotalScroll + defaultLayoutWidth;
        if (i == 0) {
            imgb_avatar_wrap.apply {
                this.layoutParams.also {
                    it.width = perOnTotal.toInt();
                    this.layoutParams = it;
                }
            }
        } else {
            imgb_avatar_wrap.apply {
                this.layoutParams.also {
                    it.width = perOnTotal.toInt();
                    this.layoutParams = it;
                }
            }
        }
        isCalculated = true
    }

}