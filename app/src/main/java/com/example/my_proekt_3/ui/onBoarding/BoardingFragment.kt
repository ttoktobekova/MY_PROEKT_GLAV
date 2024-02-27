package com.example.my_proekt_3.ui.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.my_proekt_3.DATA.LOCAL.Pref
import com.example.my_proekt_3.R
import com.example.my_proekt_3.databinding.FragmentBoardingBinding
import com.example.my_proekt_3.ui.onBoarding.Adapter.onBoardingAdapter


class BoardingFragment : Fragment() {
    private lateinit var binding: FragmentBoardingBinding
    private val adapter = onBoardingAdapter(this::onClick)

    private val pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
    }

    private fun onClick() {
        pref.onShowed()
        findNavController().navigateUp()
    }

}