package com.arnold.cursocompose.ui.login

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arnold.cursocompose.R
import com.arnold.cursocompose.ui.theme.UrbanistFontFamily

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Header(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
        Body(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp), loginViewModel
        )
        Footer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 210.dp)
        )
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        SignUp()
    }
}

@Composable
fun SignUp() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "¿No tienes una cuenta?",
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFBDBDBD)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Registrate",
            Modifier
                .clickable { },
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1AB65C)
        )
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Column(modifier = modifier) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Cerrar Aplicacion",
            modifier = Modifier
                .align(Alignment.End)
                .clickable { activity.finish() }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Inicie sesión en su cuenta",
            fontFamily = UrbanistFontFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    var isChecked by rememberSaveable { mutableStateOf(false) }
    val isLoginEnabled: Boolean by loginViewModel.isLoginEnabled.observeAsState(initial = false)

    Column(modifier = modifier) {
        Email(email) {
            loginViewModel.onLoginChanged(email = it, password = password)
        }
        Spacer(modifier = Modifier.size(25.dp))
        Password(password) {
            loginViewModel.onLoginChanged(email = email, password = it)
        }
        Spacer(modifier = Modifier.size(25.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Checkbox(
                text = "Recordar Contraseña",
                checked = isChecked,
                onCheckedChange = { isChecked = it })
        }
        Spacer(modifier = Modifier.size(25.dp))
        LoginButton(isLoginEnabled, loginViewModel)
        Spacer(modifier = Modifier.size(25.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            ForgotPassword()
        }


    }
}

@Composable
fun LoginButton(loginEnable: Boolean, loginViewModel: LoginViewModel) {
    Button(
        onClick = {loginViewModel.onLoginSelected()},
        enabled = loginEnable,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (loginEnable) Color(0xFF1AB65C) else Color(0xFF76D39D),
            disabledContainerColor = Color(0xFF76D39D)
        )
    ) {
        Text(
            text = "Iniciar Sesión",
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White
        )
    }
}


@Composable
fun ForgotPassword() {
    Text(
        text = "¿Olvidaste tu contraseña?",
        fontFamily = UrbanistFontFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF1AB65C)
    )
}

private object CheckboxDefaults {
    val size = 24.dp
    val shape = RoundedCornerShape(8.dp)
    val checkedColor = Color(0xFF1AB65C)
    val uncheckedColor = Color(0xFF1AB65C)
    val checkmarkColor = Color.White
    val textColor = Color.Black
}


@Composable
fun Checkbox(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CheckboxDefaults.shape)
                .size(CheckboxDefaults.size)
                .border(
                    3.dp,
                    if (checked) CheckboxDefaults.checkedColor else CheckboxDefaults.uncheckedColor,
                    CheckboxDefaults.shape
                )
                .background(if (checked) CheckboxDefaults.checkedColor else Color.Transparent)
                .toggleable(
                    value = checked,
                    onValueChange = onCheckedChange
                ),
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_checkmark),
                    contentDescription = null,
                    tint = CheckboxDefaults.checkmarkColor,
                    modifier = Modifier.size(13.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            style = TextStyle(
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Bold
            ),
            color = CheckboxDefaults.textColor
        )
    }
}


@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        placeholder = {
            Text(
                text = "Email",
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Medium
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_message),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF1AB65C),
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = Color(0xFFE8F8EF),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            unfocusedPlaceholderColor = Color(0xFF9E9E9E),
            unfocusedLeadingIconColor = Color(0xFF9E9E9E),
            focusedLeadingIconColor = Color(0xFF1AB65C),
            focusedPlaceholderColor = Color(0xFF9E9E9E)
        ),
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Bold
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password, onValueChange = { onTextChanged(it) },
        placeholder = {
            Text(
                text = "Contraseña",
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Medium
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        vertical = 2.dp
                    )
                    .size(20.dp),
            )
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                Icon(
                    painter = painterResource(id = if (passwordVisible) R.drawable.ic_show else R.drawable.ic_hide),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        shape = RoundedCornerShape(20),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF1AB65C),
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = Color(0xFFE8F8EF),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedTrailingIconColor = Color(0xFF1AB65C),
            unfocusedTrailingIconColor = Color(0xFF9E9E9E),
            focusedLeadingIconColor = Color(0xFF1AB65C),
            unfocusedPlaceholderColor = Color(0xFF9E9E9E),
            focusedPlaceholderColor = Color(0xFF9E9E9E),
            unfocusedLeadingIconColor = Color(0xFF9E9E9E)
        ),
        textStyle = TextStyle(
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.SemiBold
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}


