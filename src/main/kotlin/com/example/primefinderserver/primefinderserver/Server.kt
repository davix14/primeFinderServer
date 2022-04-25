package com.example.primefinderserver.primefinderserver

import javafx.application.Platform
import javafx.scene.control.TextArea
import java.util.*
import java.io.*
import java.net.*;

class Server(textArea: TextArea) {

    companion object {
        val SOCKET_PORT = 8000
        var textView: TextArea? = null
        var status: Boolean = false
    }

    init {
        textView = textArea
    }

    fun startServer() {
        Thread {
            //  Create new SocketServer instance
            val server = ServerSocket(SOCKET_PORT)
            println("Started server in port $SOCKET_PORT")

            //  Create variables for reading/writing
            var flag = true
            var message: String?
            var socket: Socket? = null
            var inputStream: InputStream? = null
            var dataInputStream: BufferedReader? = null
            var outputStream: ObjectOutputStream? = null

            //  While user does not enter ! to exit, repeat loop
            while (flag != false) {

                try {
                    socket = server.accept()
                    message = null
                    // get the input stream from the connected socket
                    inputStream = socket.getInputStream()
                    // create a DataInputStream so we can read data from it.
                    dataInputStream = BufferedReader(InputStreamReader(inputStream))

                    try {
                        // read the message from the socket and trim excess chars
                        message = dataInputStream.readLine().substring(2)
                        message = message.substring(0, message.length - 2)
                        print("The message sent from the client was: " + message + "\n")
                        textView?.appendText("The message sent from the client was: $message \n")


                        //  if user enters ! end server
                        if (message == "!") {
                            flag = false;
                            break;
                        }

                        outputStream = ObjectOutputStream(socket.getOutputStream());
                        println("Sending response");
                        outputStream.writeObject(isPrime(message.toInt()));
                    } catch (e: Exception) {
                        println("Error! --- $e");

                    }
                } catch (e: Exception) {
                    println("Error! --- $e");
                }
            }
            println("Closing socket connection");
            dataInputStream?.close();
            inputStream?.close();
            socket?.close();
            server.close();
        }.start()
    }
}

private fun isPrime(input: Int): Boolean {
    for (i in 2..input / 2) {
        // condition for nonprime number
        if (input % i == 0) {
            return false
        }
    }

    return true
}
