package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.project.databinding.ActivityMainBinding
import com.example.project.MainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBinding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        var helper=SQLite(applicationContext)
        var db=helper.readableDatabase



        viewBinding.btS.setOnClickListener {
            var args = listOf<String>(viewBinding.editTextTextEmailAddress.text.toString(),viewBinding.editTextTextPassword.text.toString()).toTypedArray()
            var rs= db.rawQuery("SELECT * FROM USERS WHERE UNAME = ? AND PWD = ?",args)
            if(rs.moveToNext()) {
               val intent=Intent(this,MainActivity2::class.java)
                startActivity(intent)
                Toast.makeText(applicationContext, "welcome", Toast.LENGTH_LONG).show()
            }
            if(args[0].isEmpty())
            {
                viewBinding.editTextTextEmailAddress.error = "cannot be empty"
            }
            if(args[1].isEmpty())
            {
                viewBinding.editTextTextPassword.error = "cannot be empty"
            }
            else
                Toast.makeText(applicationContext,"invalid",Toast.LENGTH_LONG).show()
        }


    }
}