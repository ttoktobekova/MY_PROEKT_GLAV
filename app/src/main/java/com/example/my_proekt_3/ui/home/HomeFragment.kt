package com.example.my_proekt_3.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.my_proekt_3.Model.Task
import com.example.my_proekt_3.R
import com.example.my_proekt_3.databinding.FragmentHomeBinding
import com.example.my_proekt_3.ui.Task.TaskFragment.Companion.RESULT_KEY
import com.example.my_proekt_3.ui.Task.TaskFragment.Companion.TASK_KEY
import com.example.my_proekt_3.ui.home.Adapter.TaskAdapter

class HomeFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentHomeBinding? = null
    private val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter

        setFragmentResultListener(RESULT_KEY) { _, bundle ->
            val data = bundle.getSerializable(TASK_KEY) as? Task
            data?.let {
                adapter.addTask(data)
            }
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
