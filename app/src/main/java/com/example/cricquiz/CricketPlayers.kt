package com.example.cricquiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cricquiz.databinding.FragmentCricketPlayersBinding


class CricketPlayers : Fragment() {
//   private  lateinit var  navController: NavController
   private lateinit var binding : FragmentCricketPlayersBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        navController= Navigation.findNavController(view)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCricketPlayersBinding.inflate(inflater, container, false)

        binding.buttonhere.setOnClickListener {
            Log.d("here","here")
            findNavController().navigate(R.id.action_cricketPlayers_to_footBallPlayers)
        }

        // Inflate the layout for this fragment
        return  binding.root
    }


}