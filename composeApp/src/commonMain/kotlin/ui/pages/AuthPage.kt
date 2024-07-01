package ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import music_player.composeapp.generated.resources.Res
import music_player.composeapp.generated.resources.invisible
import music_player.composeapp.generated.resources.visible
import org.jetbrains.compose.resources.painterResource
import ui.linkColor
import ui.mainBg

@Composable
fun AuthPage() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    val textFieldShape = RoundedCornerShape(28.dp)
    val textFieldColors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        cursorColor = Color.White,
        textColor = Color.White
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = mainBg), contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth(0.75f), horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = login,
                onValueChange = { login = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Login", style = TextStyle(color = Color.White)) },
                shape = textFieldShape,
                colors = textFieldColors,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f))
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Password", style = TextStyle(color = Color.White)) },
                shape = textFieldShape,
                colors = textFieldColors,
                visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { visible = !visible }) {
                        Icon(
                            painter = painterResource(if (visible) Res.drawable.visible else Res.drawable.invisible),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                maxLines = 1
            )
            Spacer(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.03f))
            Text(
                "Don't have an account? ",
                style = TextStyle(color = linkColor),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { }
            )
        }
    }
}