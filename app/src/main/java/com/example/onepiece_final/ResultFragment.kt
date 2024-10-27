package com.example.onepiece_final

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewResult = view.findViewById<TextView>(R.id.textViewResult)
        val buttonRestart = view.findViewById<Button>(R.id.buttonRestart)

        val args = ResultFragmentArgs.fromBundle(requireArguments())
        textViewResult.text = "Puntuación: ${args.puntuacionFinal}/${args.totalPreguntas}"

        buttonRestart.setOnClickListener {
            val accion = ResultFragmentDirections.actionResultFragmentToWelcomeFragment()
            findNavController().navigate(accion)
        }
    }
}
