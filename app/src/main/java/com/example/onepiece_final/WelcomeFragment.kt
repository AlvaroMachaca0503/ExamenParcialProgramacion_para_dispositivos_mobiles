package com.example.onepiece_final

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonStart = view.findViewById<Button>(R.id.buttonStart)

        buttonStart.setOnClickListener {
            val accion = WelcomeFragmentDirections.actionWelcomeFragmentToQuestionFragment()
            findNavController().navigate(accion)
        }
    }
}
