package com.example.my_proekt_3.ui.Task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.my_proekt_3.Model.Task
import com.example.my_proekt_3.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {
private lateinit var binding: FragmentTaskBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener{
            val data = Task(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString()
            )
            setFragmentResult(RESULT_KEY, bundleOf(TASK_KEY to data))
            findNavController().navigateUp()
        }
    }
    companion object{
        const val RESULT_KEY = "result_key"
        const val TASK_KEY = "task_key"
    }


}
