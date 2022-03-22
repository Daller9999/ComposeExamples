package view

object HexToJetpackColor {
    fun getColor(colorString: String): androidx.compose.ui.graphics.Color {
        return androidx.compose.ui.graphics.Color(java.awt.Color.decode("#$colorString").rgb)
    }
}