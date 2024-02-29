package com.example.my_proekt_3.ui.Profile

import android.app.Activity
import android.content.Intent
import android.graphics.Path.Direction
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.my_proekt_3.DATA.LOCAL.Pref
import com.example.my_proekt_3.Model.loadImage
import com.example.my_proekt_3.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private val pref by lazy {
        Pref(requireContext())
    }
    private val getCommentMedia =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                val selectedFileUri = result.data?.data

                pref.saveImg(selectedFileUri.toString())
                binding.imgProfile.loadImage(selectedFileUri.toString())
            }
        }
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgProfile.loadImage(pref.getImg())

        binding.imgProfile.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            getCommentMedia.launch(intent)


        }
        binding.etNames.setText(pref.getName())

        binding.btnOk.setOnClickListener {
            pref.setName(binding.etNames.text.toString())
        }
    }


}