package com.example.corutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.corutine.databinding.ActivityMainBinding
import com.example.corutine.databinding.ActivityPersonalArenaBinding

class PersonalArenaActivity : AppCompatActivity() {
    lateinit var binding: ActivityPersonalArenaBinding
    lateinit var preferencesMeneger: PreferencesMeneger
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalArenaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencesMeneger = PreferencesMeneger( this)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = ""


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lk,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.acc -> {
                var intent = Intent(this,AccActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.setting -> {true}
            else ->onOptionsItemSelected(item)

        }
    }



}