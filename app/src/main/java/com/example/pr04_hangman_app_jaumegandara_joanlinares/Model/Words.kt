package com.example.pr04_hangman_app_jaumegandara_joanlinares.Model

class Words {
    private val easyWords = listOf(
        "cat", "dog", "sun", "book", "fish", "car", "hat", "tree", "milk", "moon",
        "ball", "apple", "water", "star", "rain", "shoe", "bird", "flower", "pen", "home"
    )
    private val mediumWords = listOf(
        "planet", "bridge", "guitar", "castle", "flower", "jungle", "orange", "rabbit", "window", "garden",
        "candle", "pencil", "butter", "circle", "tunnel", "market", "laptop", "forest", "camera", "blanket"
    )
    private val hardWords = listOf(
        "pneumonia", "rhythm", "asymmetry", "knapsack", "quizzical", "labyrinth", "phenomenon", "astronomy", "awkward", "butterfly",
        "misinterpret", "xylophone", "drought", "conscience", "lightning", "thumbprint", "paradoxical", "onomatopoeia", "dyslexia", "zigzag"
    )

    fun getRandomWords (difficulty: String): String {
        return when (difficulty) {
            "Easy" -> easyWords.random()
            "Medium" -> mediumWords.random()
            "Hard" -> hardWords.random()
            else -> throw IllegalArgumentException("Invalid difficulty")
        }
    }
}