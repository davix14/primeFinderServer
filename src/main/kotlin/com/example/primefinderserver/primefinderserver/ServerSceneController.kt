package com.example.primefinderserver.primefinderserver

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class ServerSceneController {
    @FXML
    private lateinit var welcomeText: Label
    @FXML
    private lateinit var startServerButton: Button
    @FXML
    private lateinit var textArea: TextArea


    var server: Server? = null

    @FXML
    private fun onServerStartClick() {
        welcomeText.text = "Server Running"
        startServerButton.isDisable = true
        server = Server(textArea)
        server!!.startServer()
    }
}