package com.droiddevstar.newsapp.presentation.screen.about

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droiddevstar.newsapp.R
import com.droiddevstar.newsapp.presentation.navigation.Screen

@Composable
fun AboutScreen(
    onNavigate: (Screen) -> Unit
) {
    val viewModel: AboutViewModel = hiltViewModel<AboutViewModel>()
    val context: Context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.about),
            fontSize = 30.sp
        )

        Text(
            text = stringResource(id = R.string.my_name),
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 26.sp
        )

        Text(
            text = stringResource(id = R.string.android_developer),
            color = Color.Blue,
            fontSize = 26.sp,
        )

        Image(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 16.dp),
            painter = painterResource(R.drawable.dima_photo),
            contentDescription = "Dima photo",
            contentScale = ContentScale.FillWidth
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .clickable {
                viewModel.openTelegramOrBrowser(context)
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.telegram_title),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = stringResource(R.string.telegram_id),
                color = Color.Blue
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable {
                viewModel.openVkOrBrowser(context)
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.vk_title),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = stringResource(R.string.vk_id),
                color = Color.Blue
            )
        }
    }
}