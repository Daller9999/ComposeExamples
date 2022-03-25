import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import json.JsonMovie
import json.JsonMovieData
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignContent.Companion.Center
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

private val currentFlower = mutableStateOf(FlowerArray())
private val currentMovie = mutableStateOf(JsonMovieData.default())

fun main() {
    val int = window.location.search.substring(7).toIntOrNull()
    console.log(int)
    if (int != null) {
        currentMovie.value = MovieData.getMovie(int)
    }

    renderComposable(rootElementId = "root") {
        if (int == null)
            movies()
        else
            currentMovie()
    }
}

@Composable
private fun currentMovie() {
    document.body?.style?.backgroundColor = "#2E4053"
    val movie = currentMovie.value
    P(attrs = {
        style {
            width(100.percent)
            height(100.percent)
            alignContent(Center)
        }
    }) {
        Header {
            Label(attrs = {
                style {
                    fontSize(40.px)
                    textAlign(Center.toString())
                    display(DisplayStyle.Block)
                    color(Color.white)
                }
            }) {
                Text(movie.title)
            }
        }
        val height = window.screen.height * 0.7f
        val width = height * 3 / 4
        Div({
            style {
                display(DisplayStyle.Flex)
            }
        }) {
            Img(
                src = movie.imageUrl,
                attrs = {
                    style {
                        width(width.px)
                        height(height.px)
                        margin(50.px)
                        borderRadius(
                            topLeft = 20.px,
                            topRight = 20.px,
                            bottomLeft = 20.px,
                            bottomRight = 20.px
                        )
                    }
                }
            )
            Div(attrs = {
                style {
                    fontSize(20.px)
                    width(100.percent)
                    height(100.percent)
                    margin(50.px)
                    textAlign(Center.toString())
                    color(Color.white)
                }
            }) {
                Text(movie.overview)
            }
        }
    }
}

@Composable
private fun movies() {
    document.body?.style?.backgroundColor = "#2E4053"
    P(attrs = {
        style {
            width(100.percent)
            height(100.percent)
            alignContent(Center)
        }
    }) {
        Header {
            Label(attrs = {
                style {
                    fontSize(40.px)
                    textAlign(Center.toString())
                    display(DisplayStyle.Block)
                    color(Color.white)
                }
            }) {
                Text("Библиотека фильмов")
            }
        }
        for (data in MovieData.arrayMovies) {
            Div({
                style {
                    width(100.percent)
                    height(70.px)
                    display(DisplayStyle.Block)
                }
            }) {
                H2 {
                    Label(attrs = {
                        style {
                            fontSize(30.px)
                            margin(20.px)
                            display(DisplayStyle.Block)
                            color(Color.white)
                        }
                    }) {
                        Text(data.type)
                    }
                }
            }
            Div({
                style {
                    width(100.percent)
                    height(550.px)
                    display(DisplayStyle.Flex)
                    overflowX("scroll")
                }
            }) {
                for (movie in data.movies) {
                    A(attrs = {
                        href("${window.document.location}?movie=${movie.id}")
                        target(ATarget.Blank)

                        style {
                            width(300.px)
                            margin(30.px)
                            textDecoration("none")
                            textAlign(Center.toString())
                            backgroundColor(Color.transparent)
                        }
                    }) {
                        Img(
                            src = movie.imageUrl,
                            attrs = {
                                style {
                                    width(300.px)
                                    height(400.px)
                                    marginBottom(20.px)
                                    borderRadius(
                                        topLeft = 20.px,
                                        topRight = 20.px,
                                        bottomLeft = 20.px,
                                        bottomRight = 20.px
                                    )
                                }
                            }
                        )
                        Div(attrs = {
                            style {
                                fontSize(20.px)
                                width(300.px)
                                height(50.px)
                                textAlign(Center.toString())
                                color(Color.white)
                            }
                        }) {
                            Text(movie.title)
                        }
                    }
                }

            }
        }
    }
}

@Composable
private fun flowers() {
    val int = window.location.search.substring(8).toIntOrNull()
    if (int != null) {
        currentFlower.value = FlowersData.flowerArray[int]
    }
    renderComposable(rootElementId = "root") {
        if (int == null)
            renderMainPage()
        else
            showCurrentFlower()
    }
}

@Composable
private fun showCurrentFlower() {
    document.bgColor = Color.gray.toString()
    P(attrs = {
        style {
            width(100.percent)
            height(800.px)
            alignContent(Center)
        }
    }) {
        Header {
            Label(attrs = {
                style {
                    fontSize(40.px)
                    textAlign(Center.toString())
                    display(DisplayStyle.Block)
                    color(Color.white)
                }
            }) { Text(currentFlower.value.title) }
        }
        Div({
            style {
                width(100.percent)
                height(100.percent)
            }
        }) {
            Div {
                Label(
                    attrs = {
                        style {
                            display(DisplayStyle.TableRow)
                            width(100.percent)
                            height(100.percent)
                            padding(100.px)
                            margin(100.px)
                            textAlign(Center.toString())
                            fontSize(20.px)
                            color(Color.white)
                        }
                    }
                ) {
                    Text(currentFlower.value.titleFull)
                }
            }

            Div({
                style {
                    width(100.percent)
                    height(440.px)
                    display(DisplayStyle.Block)
                    overflowX("auto")
                    whiteSpace("nowrap")
                }
            }) {
                for (src in currentFlower.value.srcArray) {
                    Img(
                        src = src,
                        attrs = {
                            style {
                                width(400.px)
                                height(400.px)
                                margin(20.px)
                                borderRadius(
                                    topLeft = 20.px,
                                    topRight = 20.px,
                                    bottomLeft = 20.px,
                                    bottomRight = 20.px
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun renderMainPage() {
    document.body?.style?.backgroundImage =
        "url(https://get.wallhere.com/photo/sunlight-sunset-nature-field-sunrise-morning-horizon-tundra-plateau-flower-dawn-grassland-plant-poppy-meadow-plain-wildflower-prairie-natural-environment-land-plant-flowering-plant-grass-family-86247.jpg)"
    document.body?.style?.backgroundRepeat = "none"
    document.body?.style?.backgroundAttachment = "fixed"
    P(attrs = {
        style {
            width(100.percent)
            height(100.percent)
            alignContent(Center)
        }
    }) {
        Header {
            Label(attrs = {
                style {
                    fontSize(40.px)
                    textAlign(Center.toString())
                    display(DisplayStyle.Block)
                    color(Color.white)
                }
            }) {
                Text("Цветочная галлерея")
            }
        }
        for (flower in FlowersData.flowerArray) {
            A(attrs = {
                onClick {
                    FlowersData.currentCount++
                }
                href("${window.document.location}?flower=${flower.id}")
                target(ATarget.Blank)

                style {
                    width(100.percent)
                    textDecoration("none")
                    backgroundColor(Color.transparent)
                }
            }) {
                Div({ style { padding(25.px) } }) {
                    Label(
                        attrs = {
                            style {
                                display(DisplayStyle.Block)
                                width(200.px)
                                textAlign(Center.toString())
                                fontSize(20.px)
                                paddingBottom(20.px)
                                color(Color.white)
                            }
                        }
                    ) {
                        Text(flower.title)
                    }
                    Div({
                        style {
                            width(100.percent)
                            height(200.px)
                            display(DisplayStyle.Flex)
                        }
                    }) {
                        Img(
                            src = flower.src,
                            attrs = {
                                style {
                                    width(200.px)
                                    height(200.px)
                                    borderRadius(
                                        topLeft = 20.px,
                                        topRight = 20.px,
                                        bottomLeft = 20.px,
                                        bottomRight = 20.px
                                    )
                                }
                            }
                        )
                        Label(
                            attrs = {
                                style {
                                    alignContent(Center)
                                    display(DisplayStyle.Block)
                                    width(100.percent)
                                    height(200.px)
                                    paddingLeft(30.px)
                                    textAlign(Center.toString())
                                    fontSize(20.px)
                                    color(Color.white)
                                }
                            }
                        ) {
                            Text(flower.titleShort)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun renderMainPageMovie() {
    document.body?.style?.backgroundColor = "#2E4053"
    P(attrs = {
        style {
            width(100.percent)
            height(100.percent)
            alignContent(Center)
        }
    })
}
