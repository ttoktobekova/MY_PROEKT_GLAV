package com.example.my_proekt_3.ui.onBoarding.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.my_proekt_3.Model.loadImage
import com.example.my_proekt_3.Model.onBoarding
import com.example.my_proekt_3.databinding.ItemBoardingBinding

class onBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<onBoardingAdapter.onBoardingViewHolder>() {
    private val list = arrayListOf(
        onBoarding("Доставка Цветов", "desc1", "https://i.pinimg.com/564x/ba/64/c1/ba64c11a63ae888570687f552d94a38c.jpg"),
        onBoarding("Курьер быстро доставить", "desc2", "https://i.pinimg.com/564x/49/7e/3d/497e3dfdf7677652cc3155d8058259e9.jpg"),
        onBoarding("Спасибо что нас выбрали!", "desc3", "https://i.pinimg.com/564x/44/1b/eb/441bebda6f94dd50e5b8811000f8d75e.jpg"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class onBoardingViewHolder(private val binding: ItemBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: onBoarding) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            tvSkip.isVisible = adapterPosition != list.lastIndex
            btnStart.isVisible = adapterPosition == list.lastIndex
            btnStart.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }
            imgBoard.loadImage(onBoarding.img.toString())
        }

    }
}