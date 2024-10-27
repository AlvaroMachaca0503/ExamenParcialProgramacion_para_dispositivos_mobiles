package com.example.onepiece_final

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.onepiece_final.viewmodel.QuestionViewModel

class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestionViewModel
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[QuestionViewModel::class.java]

        radioGroup = view.findViewById(R.id.radioGroupOptions)
        buttonSubmit = view.findViewById(R.id.buttonSubmit)

        // Obtener los argumentos pasados (si los hay)
        val args = QuestionFragmentArgs.fromBundle(requireArguments())
        viewModel.indicePreguntaActual = args.indicePreguntaActual
        viewModel.puntuacion = args.puntuacionActual

        cargarPregunta()

        buttonSubmit.setOnClickListener {
            val selectedOptionId = radioGroup.checkedRadioButtonId
            if (selectedOptionId != -1) {
                val selectedOptionIndex = radioGroup.indexOfChild(view.findViewById<RadioButton>(selectedOptionId))
                viewModel.verificarRespuesta(selectedOptionIndex)

                val accion = QuestionFragmentDirections.actionQuestionFragmentToAnswerFragment(
                    esCorrecto = viewModel.esCorrecta,
                    explicacion = viewModel.preguntaActual.explicacion,
                    puntuacionActual = viewModel.puntuacion,
                    totalPreguntas = RepositorioPreguntas.listaPreguntas.size,
                    indicePreguntaActual = viewModel.indicePreguntaActual,
                    questionText = viewModel.preguntaActual.texto,
                    noRespondioATiempo = false // O manejar según tu lógica
                )
                findNavController().navigate(accion)
            }
        }
    }

    private fun cargarPregunta() {
        val preguntaActual = viewModel.preguntaActual
        val textViewPregunta = view?.findViewById<TextView>(R.id.textViewQuestion)
        textViewPregunta?.text = preguntaActual.texto

        radioGroup.removeAllViews()
        for ((index, opcion) in preguntaActual.opciones.withIndex()) {
            val radioButton = RadioButton(requireContext()).apply {
                id = View.generateViewId()
                text = opcion
            }
            radioGroup.addView(radioButton)
        }
    }
}
