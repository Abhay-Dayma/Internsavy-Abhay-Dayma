package com.example.buttonsound

import android.R
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var player: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(v: View?) {
        if (player == null) {
            player = MediaPlayer.create(this, R.drawable.song2)
            player!!.setOnCompletionListener(OnCompletionListener { stopPlayer() })
        }
        player!!.start()
    }

    fun pause(v: View?) {
        if (player != null) {
            player!!.pause()
        }
    }

    fun stop(v: View?) {
        stopPlayer()
    }

    private fun stopPlayer() {
        if (player != null) {
            player!!.release()
            player = null
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        stopPlayer()
    }
}