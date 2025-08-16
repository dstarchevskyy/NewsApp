package com.droiddevstar.newsapp.presentation.screen.about

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
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
import com.droiddevstar.newsapp.presentation.ui.component.StyledButton

@Composable
fun AboutScreen() {
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

        Box(
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp),
                painter = painterResource(R.drawable.dima_photo),
                contentDescription = "Dima photo",
                contentScale = ContentScale.FillWidth
            )

            val alpha by animateFloatAsState(
                targetValue = if (viewModel.state) {
                    1f
                } else {
                    0f
                },
                animationSpec = tween(durationMillis = 1_000)
            )

            this@Column.AnimatedVisibility(
                visible = viewModel.state,
                enter = fadeIn(
                    animationSpec = tween(delayMillis = 2_000)
                ),
                exit = fadeOut(
                    animationSpec = tween(delayMillis = 2_000)
                )
            ) {
                BalabanovView(
                    modifier = Modifier.fillMaxWidth()
                        .alpha(alpha)
                )
            }

            EyeView(modifier = Modifier
                .fillMaxWidth(0.525f)
                .fillMaxHeight(0.11f)
                .align(Alignment.TopStart)
            )

            EyeView(modifier = Modifier
                .fillMaxWidth(0.485f)
                .fillMaxHeight(0.109f)
                .align(Alignment.TopStart)
            )
        }

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

        StyledButton(
            onClick = {
                viewModel.addMem()
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.add_mem)
            )
        }

        StyledButton(
            onClick = {
                viewModel.onCloseClick()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.close)
            )
        }

        StyledButton(
            onClick = {

            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.show_eyes),
                    modifier = Modifier.padding(end = 6.dp)
                )
                EyeView()
                EyeView()
            }
        }

    }
}

