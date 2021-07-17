package com.rahul.demo.app.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.demo.app.R
import com.rahul.demo.app.collapsingavatar.UserInfo
import kotlinx.android.synthetic.main.list_item_layout.view.*


class CustomerAdapter(val userData: List<UserInfo>) :
    RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private lateinit var userInfo: UserInfo

        fun setUserData(userInfo: UserInfo) {
            this.userInfo = userInfo;
            itemView.email_line?.setText(userInfo.email)
            itemView.name_line?.setText(userInfo.name)
            /* icon.set(userInfo.email)*/
            Glide.with(itemView.context).load(userInfo.image).placeholder(R.drawable.image_placeholder).into(itemView.icon!!)
            Log.e("userInfo.image", "${userInfo.image}")
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item_layout, viewGroup, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.setUserData(userData.get(index))

    }

    override fun getItemCount(): Int {
        return userData.size;
    }

}
