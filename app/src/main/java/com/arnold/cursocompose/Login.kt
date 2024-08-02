package com.arnold.cursocompose

import android.content.res.Resources.Theme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arnold.cursocompose.ui.theme.UrbanistFontFamily


@Composable
fun login(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 50.dp)
    ) {
        Text(
            text = "Inicie sesión en su cuenta",
            fontSize = 30.sp,
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .padding(vertical = 20.dp)
        )

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = email, onValueChange = { email = it },
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
            singleLine = true,
            textStyle = TextStyle(
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = password, onValueChange = { password = it },
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
                fontWeight = FontWeight.SemiBold),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val recordar = remember { mutableStateOf(true) }
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(if (recordar.value) Color(0xFF1AB65C) else Color.Transparent)
                    .border(
                        width = 3.dp,
                        color = Color(0xFF1AB65C),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { recordar.value = !recordar.value },
                contentAlignment = Alignment.Center
            ) {
                if (recordar.value){
                    Icon(painter = painterResource(id = R.drawable.ic_checkmark),
                        contentDescription = null,
                        tint = Color.White)
                }
            }
            Text(
                text = "Recordar contraseña",
                modifier = Modifier.padding(start = 8.dp),
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Bold

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1AB65C)
            )

        ) {
            Text(
                text = "Iniciar Sesión",
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Olvidate tu contraseña?",
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,

                color = Color(0xFF1AB65C)
            )
        }
        Spacer(modifier = Modifier.height(200.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¿No estas registado?",
                fontFamily = UrbanistFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp, color = Color.Gray
            )
            TextButton(onClick = {navController.navigate("registro")}) {
                Text(
                    text = "Registrate",
                    fontFamily = UrbanistFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF1AB65C)
                )
            }
        }


    }
}