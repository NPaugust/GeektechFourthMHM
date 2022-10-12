package com.example.fourthmfirsthm.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.fourthmfirsthm.Prefs
import com.example.fourthmfirsthm.R
import com.example.fourthmfirsthm.databinding.FragmentBoardBinding
import com.example.fourthmfirsthm.model.Board

class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    private lateinit var adapter: BoardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            FragmentBoardBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardAdapter(requireContext(),findNavController())
        binding.viewPager.adapter = adapter
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            activity?.finish()
        }
        adapter.addItem(Board(R.raw.newslottie1, "Welcome to Task APP", "Let's schedule your life"))
        adapter.addItem(Board(R.raw.newslottie2, "Write your experiences", "Describe everything you want"))
        adapter.addItem(Board(R.raw.newslottie3, "Manage your lifestyle", "And upgrade yourself!"))

        binding.wormDotsIndicator.setViewPager2(binding.viewPager)
        binding.textSkip.setOnClickListener {
            Prefs(requireContext()).saveState()
            findNavController().navigateUp()
        }
    }
}