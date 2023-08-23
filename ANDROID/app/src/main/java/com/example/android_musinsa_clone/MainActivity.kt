package com.example.android_musinsa_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_musinsa_clone.ui.home.RecommendScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToolbarWithMenu("MUSINSA")
        }
    }
}

@ExperimentalPagerApi
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ToolbarWithMenu(name: String) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = name) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Basket"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(scrollState),

                verticalArrangement = Arrangement.Center
            ) {

                val coroutineScope = rememberCoroutineScope()
                val pagerState = rememberPagerState()
//                pagerState.disableScrolling(scope = coroutineScope)

                androidx.compose.material.TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    backgroundColor = Color.White,
                    indicator = { tabPositions ->
                        androidx.compose.material.TabRowDefaults.Indicator(
                            Modifier.pagerTabIndicatorOffset(
                                pagerState,
                                tabPositions = tabPositions
                            )
                        )
                    }) {
                    PageList.values().forEachIndexed { index, title ->
                        Tab(
                            text = {
                                if (pagerState.currentPage == index) {
                                    Text(
                                        text = title.title,
                                        fontWeight = FontWeight.Bold
                                    )
                                } else {
                                    Text(
                                        text = title.title
                                    )
                                }

                            },
                            selected = pagerState.currentPage == index,
                            onClick = {
                                coroutineScope.launch {
//                                    pagerState.enableScrolling(coroutineScope)
//                                    delay(100)
                                    pagerState.scrollToPage(index)
//                                    pagerState.disableScrolling(coroutineScope)
                                }
                            },
                        )
                    }
                }
                HorizontalPager(
                    count = PageList.values().size,
                    state = pagerState
                ) { page ->
                    when (page) {
                        0 -> RecommendScreen()
                        1 -> Text(PageList.RANKING.name)
                        2 -> Text(PageList.STYLE.name)
                        3 -> Text(PageList.SALE.name)
                        4 -> Text(PageList.BEAUTY.name)
                    }
                }
            }

        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun PreviewScreen() {
    ToolbarWithMenu(name = "MUSINSA")

}

enum class PageList(val title: String) {
    RECOMMEND("추천"),
    RANKING("랭킹"),
    STYLE("스타일"),
    SALE("세일"),
    BEAUTY("뷰티")
}

@ExperimentalPagerApi
fun PagerState.disableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            // Await indefinitely, blocking scrolls
            awaitCancellation()
        }
    }
}

@ExperimentalPagerApi
fun PagerState.enableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            // Do nothing, just cancel the previous indefinite "scroll"

        }
    }
}