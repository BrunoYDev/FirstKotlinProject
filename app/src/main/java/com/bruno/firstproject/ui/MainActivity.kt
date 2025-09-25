package com.bruno.firstproject.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bruno.firstproject.utils.AppConstants
import com.bruno.firstproject.R
import com.bruno.firstproject.business.UserBusiness
import com.bruno.firstproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val UserBusiness = UserBusiness()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSend.setOnClickListener(this)
        binding.magicButton.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if(v.id == R.id.buttonSend){
            val name = binding.inputName.text.toString()
            val password = binding.inputPassword.text.toString()

            if(UserBusiness.checkCredentials(name, password)){

                val bundle = Bundle()
                bundle.putString(AppConstants.Companion.NAME, name)

                val intent: Intent = Intent(this, HomeActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

            }else {
                Toast.makeText(this, "Insert a valid name and password", Toast.LENGTH_SHORT).show()
            }
        }
        else if (v.id == R.id.magicButton){
            Toast.makeText(this, "Rafael Homossexual!!", Toast.LENGTH_SHORT).show()
        }
    }

}