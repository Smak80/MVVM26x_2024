package ru.smak.mvvm262_2024

class Filter {
    fun filterToInt(text: String): String{
        return text.trim().filterIndexed { i, v ->
            v in '0'..'9' || v == '-' && i == 0
        }
    }
}