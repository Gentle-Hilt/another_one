package gentle.hilt.data.screens_logic.login_screen

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

class RedHighlightVisualTransformation(
    private val isValid: (Char) -> Boolean
) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = buildAnnotatedString {
            text.forEachIndexed { index, char ->
                if (index >= 0) {
                    if (isValid(char)) {
                        append(char)
                    } else {
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Red)) {
                            append(char.toString())
                        }
                    }
                } else {
                    append(char.toString())
                }
            }
        }
        return TransformedText(transformedText, offsetMapping = OffsetMapping.Identity)
    }

}