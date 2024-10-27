package com.example.onepiece_final.viewmodel

import androidx.lifecycle.ViewModel
import com.example.onepiece_final.RepositorioPreguntas

class QuestionViewModel : ViewModel() {
    private val preguntas = RepositorioPreguntas.listaPreguntas
    var indicePreguntaActual = 0
    var puntuacion = 0
    val esCorrecta: Boolean
        get() = _esCorrecta
    private var _esCorrecta = false

    val preguntaActual
        get() = preguntas[indicePreguntaActual]

    fun verificarRespuesta(indiceSeleccionado: Int) {
        _esCorrecta = indiceSeleccionado == preguntaActual.indiceRespuestaCorrecta
        if (_esCorrecta) puntuacion++
        indicePreguntaActual++
    }
}