package com.example.onepiece_final

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AnswerFragment : Fragment() {

    private lateinit var questionText: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewResult = view.findViewById<TextView>(R.id.textViewResult)
        val textViewExplanation = view.findViewById<TextView>(R.id.textViewExplanation)
        val buttonNext = view.findViewById<Button>(R.id.buttonNext)

        val args = AnswerFragmentArgs.fromBundle(requireArguments())
        questionText = args.questionText

        // Asignar las variables necesarias
        val totalPreguntas = args.totalPreguntas
        val indicePreguntaActual = args.indicePreguntaActual
        val puntuacionActual = args.puntuacionActual

        if (args.noRespondioATiempo) {
            textViewResult.text = getString(R.string.tiempo_agotado)
            textViewResult.setTextColor(ContextCompat.getColor(requireContext(), R.color.incorrect_answer))
            textViewExplanation.text = getString(R.string.no_respondiste_a_tiempo, args.explicacion)
        } else if (args.esCorrecto) {
            textViewResult.text = getString(R.string.respuesta_correcta)
            textViewResult.setTextColor(ContextCompat.getColor(requireContext(), R.color.correct_answer))
            textViewExplanation.text = args.explicacion
        } else {
            textViewResult.text = getString(R.string.respuesta_incorrecta)
            textViewResult.setTextColor(ContextCompat.getColor(requireContext(), R.color.incorrect_answer))
            textViewExplanation.text = args.explicacion
        }

        buttonNext.setOnClickListener {
            if (indicePreguntaActual < totalPreguntas) {
                val accion = AnswerFragmentDirections.actionAnswerFragmentToQuestionFragment(
                    indicePreguntaActual = indicePreguntaActual + 1,
                    puntuacionActual = puntuacionActual
                )
                findNavController().navigate(accion)
            } else {
                val accion = AnswerFragmentDirections.actionAnswerFragmentToResultFragment(
                    puntuacionFinal = puntuacionActual,
                    totalPreguntas = totalPreguntas
                )
                findNavController().navigate(accion)
            }
        }
    }
}
