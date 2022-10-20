package com.example.corutine

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.corutine.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var preferencesMeneger: PreferencesMeneger;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencesMeneger = PreferencesMeneger(this)

        initActivity()
        connect()
        regist()


    }


    fun initActivity() {
        if (preferencesMeneger.getString("pass") == null) {
            binding.LL1Conecct.visibility = View.GONE
            binding.LL1Reg.visibility = View.VISIBLE
        } else {
            binding.LL1Reg.visibility = View.GONE
            binding.LL1Conecct.visibility = View.VISIBLE

        }
    }

    private fun regist() {
        binding.btnreg.setOnClickListener() {
            preferencesMeneger.putString("login", binding.editText.text.toString())
            preferencesMeneger.putString("pass", binding.editText2.text.toString())
            preferencesMeneger.putString("Email", binding.editText3.text.toString())
            preferencesMeneger.putString("Ключевое слово", binding.editText4.text.toString())

            var intent: Intent = Intent(this, PersonalArenaActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    fun connect() {
        binding.btnConnect.setOnClickListener(){
            var pass = preferencesMeneger.getString(("pass"))
            var email = preferencesMeneger.getString(("Email"))

            if (pass.toString() == binding.editTextPassConnect.text.toString() &&
                email.toString() == binding.editTextEmailConnect.text.toString()
            ) {
                var intent=Intent(this,PersonalArenaActivity::class.java)
                startActivity(intent)
                finish()

            }
        }

    }
}