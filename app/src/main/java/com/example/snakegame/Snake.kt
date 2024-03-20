package com.example.snakegame

import android.graphics.Color

class Snake {
    companion object {
        var headX = 0f
        var headY = 0f
        var bodyParts = mutableListOf(arrayOf(0f, 0f))
        var direction = "right"
        var alive = false
        var bodyColor = Color.GREEN

        fun possibleMove(): Boolean {
            if (headX < 0f || headX > 2200f || headY < 0f || headY > 1000f)
                return false
            return true
        }

        fun reset() {
            headX = 0f
            headY = 0f
            bodyParts = mutableListOf(arrayOf(0f, 0f))
            direction = "right"
        }

        fun changeBodyColor() {
            bodyColor = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
        }
    }
}