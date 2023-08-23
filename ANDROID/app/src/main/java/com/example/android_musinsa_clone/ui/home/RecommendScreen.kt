package com.example.android_musinsa_clone.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_musinsa_clone.R
import com.example.android_musinsa_clone.ui.theme.Gray100
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Preview
@Composable
fun RecommendScreen(
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        AdPagerScreen()
        menuScreen()
        LiveScreen()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AdPagerScreen() {
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
                val resource = item.resource
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
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.Black)
    ) {
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

@Composable
fun menuScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(20.dp)
            .height(50.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            for (index in 0..4) {
                Item(MenuList.values()[index])
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            for (index in 5..9) {
                Item(MenuList.values()[index])
            }
        }
    }
}

@Composable
fun Item(item: MenuList) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .size(55.dp)
                .background(color = Gray100, shape = RoundedCornerShape(15.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = item.engText,
                textAlign = TextAlign.Center
            )
        }
        Text(text = item.koText)
    }
}

@Composable
fun LiveScreen() {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "무신사 라이브 편성표",
            fontWeight = FontWeight.Bold
        )
        Text(text = "패션 라이브 쇼핑도 무신사랑")
        LiveTable()
    }

}

@Composable
fun LiveTable() {
    LazyRow(
        modifier = Modifier.height(200.dp)
    ) {
        itemsIndexed(LiveList.values()) { index, item ->
            LiveItem(item = item)
        }
    }
}

@Composable
fun LiveItem(item: LiveList) {
    Column(
        modifier = Modifier.width(100.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box() {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = item.resource),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            Text(
                text = item.date,
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(5.dp),
                fontSize = 10.sp
            )
        }
        Text(text = item.title)

    }
}


enum class ImageList(val resource: Int, val title: String, val subTitle: String) {
    FIRST(R.drawable.img_main_1, "2023 아울렛 클리어런스", "최대 85% 깜짝 할인 ㅇ0ㅇ !!"),
    SECOND(R.drawable.img_main_2, "2023 이달의 트랙터", "최대 75% 깜짝 할인 + 쿠폰"),
    THIRD(R.drawable.img_main_3, "무탠다드 가방", "최대 95% 깜짝 할인 받아가세요"),
}

enum class MenuList(val engText: String, val koText: String) {
    SEASON_OFF("Season Off", "시즌오프"),
    LUXURY("Luxury", "럭셔리"),
    BEAUTY("Beauty", "뷰티"),
    PLAYER("Player", "스포츠"),
    OUTLET("Outlet", "아울렛"),
    KIDS("Kids", "키즈"),
    GOLF("Golf", "골프"),
    EARTH("Earth", "어스"),
    FASHION_TALK("Fashion Talk", "패션톡"),
    TRAVEL("Travle", "여행패션")
}

enum class LiveList(val resource: Int, val title: String, val date: String) {
    ONE(R.drawable.img_main_1, "주앙옴므 | 기획전 바로가기", "LIVE"),
    TWO(R.drawable.img_main_2, "스파오 | 최대 50% 할인", "오늘 오후 8시"),
    THREE(R.drawable.img_main_3, "스파오 | 최대 50% 할인", "오늘 오후 8시"),
    FOUR(R.drawable.img_main_1, "스파오 | 최대 50% 할인", "오늘 오후 8시"),
    FIVE(R.drawable.img_main_1, "스파오 | 최대 50% 할인", "오늘 오후 8시"),
    SIX(R.drawable.img_main_1, "스파오 | 최대 50% 할인", "오늘 오후 8시")
}