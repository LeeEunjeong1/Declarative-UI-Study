package com.example.android_musinsa_clone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_musinsa_clone.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun RecommendScreen(
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = pagerState.currentPage) {
        launch {
            while (true) {
                delay(3000L)
                withContext(NonCancellable) {
                    if (pagerState.currentPage + 1 in 0 until ImageList.values().size) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        pagerState.animateScrollToPage(0)
                    }
                }
            }
        }
    }
    Column(modifier = Modifier.fillMaxHeight()) {
        HorizontalPager(
            state = pagerState,
            count = ImageList.values().size,
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()

        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            change.consume()
                            when {
                                dragAmount < 0 -> {
                                    coroutineScope.launch { /* right */
                                        if (pagerState.currentPage == ImageList.values().lastIndex) {
                                            pagerState.animateScrollToPage(0)
                                        } else {
                                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                        }
                                    }
                                }

                                dragAmount > 0 -> { /* left */
                                    coroutineScope.launch {
                                        if (pagerState.currentPage == 0) {
                                            pagerState.animateScrollToPage(ImageList.values().lastIndex)
                                        } else {
                                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                        }
                                    }
                                }
                            }
                        }
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    val item = ImageList.values().getOrNull(page) ?: ImageList.FIRST
                    val resource= item.resource
                    val title = item.title
                    val subTitle = item.subTitle

                    Image(
                        painter = painterResource(id = resource), contentDescription = "image",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = title,
                            fontSize = 22.sp,
                            color = Color.White
                        )
                        Text(
                            text = subTitle,
                            modifier = Modifier.padding(top = 10.dp),
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }


                }
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.Black)){
            Text(
                text = "단 3일, 무신사 스탠다드 50% 특가",
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Start,
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

    }

}


enum class ImageList(val resource: Int, val title: String, val subTitle: String) {
    FIRST(R.drawable.img_main_1, "2023 아울렛 클리어런스", "최대 85% 깜짝 할인 ㅇ0ㅇ !!"),
    SECOND(R.drawable.img_main_2, "2023 이달의 트랙터", "최대 75% 깜짝 할인 + 쿠폰"),
    THIRD(R.drawable.img_main_3, "무탠다드 가방", "최대 95% 깜짝 할인 받아가세요"),

}