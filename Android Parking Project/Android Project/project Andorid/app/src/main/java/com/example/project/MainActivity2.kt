package com.example.project

import android.app.Activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.project.databinding.ActivityMain2Binding

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.*

class MainActivity2 : AppCompatActivity() {

    private var active:Boolean=false
    private var data :String=""

    var thread = Thread()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        thread = Thread(
            kotlinx.coroutines.Runnable {

            var viewBinding = ActivityMain2Binding.inflate(layoutInflater)

            fun hide(){
                viewBinding.imageView.visibility=View.INVISIBLE

            }

            fun show (){
                viewBinding.imageView.visibility=View.VISIBLE
            }


            setContentView(viewBinding.root)


            val address="192.168.1.15"
            val port=8099






            CoroutineScope(IO).launch {
                while (true) {
                    val connection = Socket(address, port)


                    val reader = Scanner(connection.getInputStream())

                    while (reader.hasNext()) {
                        var input = ""

                        input = reader.nextLine()



                        runOnUiThread(Runnable {

                            if (input.startsWith("Available"))
                                hide()
                            else if (input.startsWith("ocupied"))
                                show()
                        })



                    }
                    reader.close()

                    connection.close()

                }
            }
        })
        thread.start()


    }



}