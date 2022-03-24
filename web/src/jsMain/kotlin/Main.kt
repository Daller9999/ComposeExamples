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
private val currentMovie = mutableStateOf(FlowerArray())

fun main() {
    renderComposable(rootElementId = "root") {
        movies()
    }
}

@Composable
private fun movies() {
    val dataJson: ArrayList<JsonMovie> = JSON.parse(MovieData.string)
    document.body?.style?.backgroundColor = "#2E4053"
    console.log(dataJson)
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
        for (data in FlowersData.flowerArray){
            Div({
                style {
                    width(100.percent)
                    height(440.px)
                    display(DisplayStyle.Block)
                    overflowX("auto")
                    whiteSpace("nowrap")
                }
            }) {
                for (movie in data.srcArray) {
                    Img(
                        src = movie,
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
    document.body?.style?.backgroundImage = "url(https://get.wallhere.com/photo/sunlight-sunset-nature-field-sunrise-morning-horizon-tundra-plateau-flower-dawn-grassland-plant-poppy-meadow-plain-wildflower-prairie-natural-environment-land-plant-flowering-plant-grass-family-86247.jpg)"
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
