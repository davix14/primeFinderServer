package com.example.primefinderserver.primefinderserver

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import org.kordamp.bootstrapfx.BootstrapFX
import java.net.ServerSocket

class ServerApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(ServerApplication::class.java.getResource("server-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        scene.root.style = "-fx-font-family: 'serif'"
        scene.stylesheets.add(BootstrapFX.bootstrapFXStylesheet())
        stage.title = "PrimeFinder Server"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(ServerApplication::class.java)
    Thread {
        try {
            val serverSocket = ServerSocket()
        } catch (e: Exception) {

        }
    }
}