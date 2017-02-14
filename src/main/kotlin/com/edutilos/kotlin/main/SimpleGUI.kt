package com.edutilos.kotlin.main

import java.awt.Dimension
import javax.swing.*

/**
 * Created by edutilos on 14/02/2017.
 */
class SimpleGUI (title:String) : JFrame(title) {

    private var panelRoot:JPanel = JPanel()
    private var lblWelcome:JLabel = JLabel()
    private var btnClick:JButton = JButton()
    private var lblStatus:JLabel = JLabel()

    public fun prepareGUI() {
        this.size = Dimension(500, 500)
        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        addComponents()
        registerEvents()
    }
    public fun addComponents() {
        panelRoot.layout = BoxLayout(panelRoot, BoxLayout.Y_AXIS)
        this.contentPane.add(panelRoot)

        lblWelcome.text = "GUI in Kotlin"
        panelRoot.add(lblWelcome)

        btnClick.text = "Click me"
        panelRoot.add(btnClick)

        lblStatus.text = "Status: "
        panelRoot.add(lblStatus)

    }

    var counter = 0

    public fun registerEvents() {
        btnClick.addActionListener { l ->
            lblStatus.text =  "Clicked ${counter} times"
            ++counter
        }
    }
}