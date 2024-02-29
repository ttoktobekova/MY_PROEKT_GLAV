package com.example.my_proekt_3.Model

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.my_proekt_3.R

fun ImageView.loadImage(url:String?){
    Glide.with(this).load(url).placeholder(R.drawable.ic_profile).into(this)
}
fun Context.showToast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}fun Fragment.showToast(msg:String){
    Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()
}