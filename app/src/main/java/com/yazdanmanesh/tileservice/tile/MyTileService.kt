package com.yazdanmanesh.tileservice.tile

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Icon
import android.preference.PreferenceManager
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.widget.Toast
import com.yazdanmanesh.tileservice.MainActivity
import com.yazdanmanesh.tileservice.R


class MyTileService : TileService() {
    var mSharedPreferences: SharedPreferences? = null
    override fun onClick() {
        super.onClick()
        val tile = qsTile
        val isActive = tile.state == Tile.STATE_ACTIVE
        if (isActive) {
            tile.state = Tile.STATE_INACTIVE
            val i = Intent(this, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityAndCollapse(i)

            tile.label = "Disabled"
            tile.contentDescription = "Test App"
            tile.icon = Icon.createWithResource(this, R.drawable.play)
        } else {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
            val counter = mSharedPreferences!!.getInt("counter", 0)
            tile.state = Tile.STATE_ACTIVE
            tile.icon = Icon.createWithResource(this, R.drawable.pause)
            tile.label = "music"
        }
        tile.updateTile()
    }

    override fun onTileAdded() {
        super.onTileAdded()
        val tile = qsTile
        tile.state = Tile.STATE_ACTIVE
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val counter = mSharedPreferences!!.getInt("counter", 0)
        tile.label = "music"
        tile.icon = Icon.createWithResource(this, R.drawable.pause)
        tile.updateTile()
        Toast.makeText(applicationContext, "tile added", Toast.LENGTH_SHORT).show()
    }

    override fun onTileRemoved() {
        super.onTileRemoved()
    }

    override fun onStartListening() {
        super.onStartListening()
        val tile = qsTile
        if (tile.state == Tile.STATE_ACTIVE) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
            var counter = mSharedPreferences!!.getInt("counter", 0)
            mSharedPreferences!!.edit().putInt("counter", ++counter).apply()
            tile.label = "music"
        }
        tile.updateTile()
    }

    override fun onStopListening() {
        super.onStopListening()
    }
}
