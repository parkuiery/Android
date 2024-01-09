package com.example.composeprac

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composeprac.ui.theme.ComposePracTheme
import com.example.composeprac.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel = ViewModelProvider(this)[MainViewModel::class.java]
            ComposePracTheme {
                LoginScreen(viewModel)
            }
        }
    }
}

@Composable
internal fun LoginScreen(
    viewModel: MainViewModel
) {
    //var uiState by remember { mutableStateOf(viewModel.loginState) }
    val uiState by viewModel.loginState.observeAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            BackKey()
            LoginTitle()
            Email(
                //email = viewModel.email,
                email = { uiState?.email ?: "" },
                onEmailChanged = {
                    //viewModel.updateEmail(email = it)
                    //uiState = uiState.value.copy(email = it)
                    //uiState = viewModel.updateEmail(email = it)
                    viewModel.updateEmail(email = it)
                }
            )
            Password()
            Spacer(modifier = Modifier.weight(1f))
            LoginBtn()
        }
    }
}

@Composable
internal fun BackKey() {
    val painter = painterResource(id = R.drawable.back_icon)
    val description = "back key"
    Row(
        modifier = Modifier.padding(
            start = 24.dp,
            top = 8.dp,
            bottom = 8.dp
        )
    ) {
        Image(
            painter = painter,
            contentDescription = description,
        )
    }
}

@Composable
private fun LoginTitle() {
    Row(
        modifier = Modifier
            .padding(
                start = 24.dp,
                top = 20.dp,
                bottom = 20.dp,
            )
    ) {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            ) {
                append("JOBIS")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
            ) {
                append("에 로그인하기")
            }
        }
        Text(text = annotatedString)
    }
}

@Composable
fun Email(
    //email :LiveData<String>,
    email: () -> String,
    //email:String,
    onEmailChanged: (String) -> Unit,
) {
    //val data by email
    Log.d("TEST","text"+email())
    Column(
        modifier = Modifier.padding(
            horizontal = 24.dp,
            vertical = 12.dp
        )
    ) {
        Text(text = "이메일")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(12.dp))
                .height(48.dp)
                .background(Color.LightGray)
        ) {
            BasicTextField(
                value = email(),
                onValueChange = onEmailChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    )
            )
            Text(
                text = "@dsm.hs.kr",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )
            if (email().isBlank()) {
                Text(
                    text = "example",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }
        }
    }
}

@Composable
private fun Password() {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    var visible by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)) {
        Text(
            text = "비밀번호"
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clip(RoundedCornerShape(12.dp))
                .height(48.dp)
                .background(Color.LightGray)
        ) {
            BasicTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                visualTransformation = if (visible) PasswordVisualTransformation() else VisualTransformation.None

            )
            if (textState.value.text.isEmpty()) {
                Text(
                    text = "비밀번호를 입력해주세요",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp),
                onClick = { visible = !visible },
            ) {
                Icon(
                    painter = painterResource(
                        id = if (visible) R.drawable.baseline_visibility_off_24
                        else R.drawable.baseline_visibility_24
                    ),
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
private fun LoginBtn() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = "로그인")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracTheme {

    }
}