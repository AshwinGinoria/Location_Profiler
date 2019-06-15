package com.ashwinginoria.locationprofiler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.media.AudioManager
import kotlinx.android.synthetic.main.activity_volume_control.*

class VolumeControl : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume_control)

        val audioManager: AudioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        VolumeUP.setOnClickListener {
            val maxVolume = audioManager.getStreamMaxVolume( AudioManager.STREAM_MUSIC )
            val currentVolume = audioManager.getStreamVolume( AudioManager.STREAM_MUSIC )
            if (currentVolume != maxVolume) audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume+1, 1)
        }
        VolumeDown.setOnClickListener {
            val currentVolume = audioManager.getStreamVolume( AudioManager.STREAM_MUSIC )
            if (currentVolume != 0) audioManager.setStreamVolume( AudioManager.STREAM_MUSIC, currentVolume - 1, 1)
        }
        MaxVol.setOnClickListener {
            val maxVolume = audioManager.getStreamMaxVolume( AudioManager.STREAM_MUSIC )
            val currentVolume = audioManager.getStreamVolume( AudioManager.STREAM_MUSIC )
            audioManager.setStreamVolume( AudioManager.STREAM_MUSIC, maxVolume, 1)
        }
        Silent.setOnClickListener {
            audioManager.setStreamVolume( AudioManager.STREAM_MUSIC, 0, 1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
