package com.example.onepiece_final

data class Pregunta(
    val texto: String,
    val opciones: List<String>,
    val indiceRespuestaCorrecta: Int,
    val explicacion: String
)