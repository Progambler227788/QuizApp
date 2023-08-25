package com.example.cricquiz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cricquiz.R
import com.example.cricquiz.databinding.FragmentHomeBinding
import com.example.cricquiz.databinding.FragmentLeaderBoardBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LeaderBoardFragment : Fragment() {
    private lateinit var binding : FragmentLeaderBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLeaderBoardBinding.inflate(inflater, container, false)
        return binding.root
      }

}