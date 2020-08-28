package com.pocbeagle.bff.components

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import com.pocbeagle.bff.data.CoronaData

class ScreenComponentIntro {

    fun getIntroComponent(
    ): Container {
        return Container(
                context = ContextData(
                        id = "coronaData",
                        value = arrayListOf(
                                CoronaData(
                                confirmed = "teste",
                                recovered = "teste",
                                critical = "teste" ,
                                deaths = "teste" ,
                                lastChange= "teste",
                                lastUpdate= "teste"
                        ))
                ),
                children = listOf(

                        title(),
                        makeContainersList(),
                        createButton()
                ))
    }


    fun createButton(): Button {
        return Button(
                text = "Update Cases",
                onPress = listOf(
                        SendRequest(
                                url = "https://covid-19-data.p.rapidapi.com/totals",
                                headers = mapOf("x-rapidapi-host" to "covid-19-data.p.rapidapi.com", "x-rapidapi-key" to "d5fcaeee39msh4ccd86eeb3f8db4p15338bjsn32b45a87d8ea"),
                                method = RequestActionMethod.GET,
                                onSuccess = listOf(
                                        SetContext(
                                                contextId = "coronaData",
                                                value = "@{onSuccess.data}"
                                        ),
                                Alert(
                                        title = "Teste",
                                        message = "@{onSuccess.data}"
                                ))
                        ))).applyStyle(Style
        (
                backgroundColor = "#C6C6C6",
                cornerRadius = CornerRadius(15.0),
                margin = EdgeValue(
                        top = UnitValue(15.0, UnitType.PERCENT),
                        left = UnitValue(20.0, UnitType.PERCENT),
                        right = UnitValue(20.0, UnitType.PERCENT)

                         ),
                flex = Flex(justifyContent = JustifyContent.CENTER, grow = 1.0)
        )
        )

    }

    fun title(): Text{
        return Text(
                text = "Coronavirus cases in the world"
        ).applyStyle(Style
        (
                backgroundColor = "#808080",
                margin = EdgeValue(
                        top = UnitValue(20.0, UnitType.PERCENT),
                        left = UnitValue(20.0, UnitType.PERCENT),
                        right = UnitValue(20.0, UnitType.PERCENT),
                        bottom = UnitValue(15.0,UnitType.PERCENT)
                ),
                flex = Flex(justifyContent = JustifyContent.CENTER, grow = 1.0)
        )
        )
    }



    fun makeContainersList(): Container {
                   return Container(
                            children = listOf(
                                    Text(
                                            text = "@{coronaData[0].confirmed}"


                                    ).applyStyle(
                                            Style(
                                                    padding = EdgeValue(all = 3.unitPercent())
                                            )
                                    ),
                                    Text(
                                            text = "@{coronaData[0].recovered}"


                                    ).applyStyle(
                                            Style(
                                                    padding = EdgeValue(all = 3.unitPercent())
                                            )
                                    ),
                                    Text(
                                            text = "@{coronaData[0].critical}"


                                    ).applyStyle(
                                            Style(
                                                    padding = EdgeValue(all = 3.unitPercent())
                                            )
                                    ),
                                    Text(
                                            text = "@{coronaData[0].deaths}"

                                    ).applyStyle(
                                            Style(
                                                    padding = EdgeValue(all = 3.unitPercent())
                                            )
                                    ),
                                    Text(
                                            text = "@{coronaData[0].lastChange}"

                                    ).applyStyle(
                                            Style(
                                                    padding = EdgeValue(all = 3.unitPercent())
                                            )
                                    ),
                                    Text(
                                            text = "@{coronaData.lastUpdate}"

                                    ).applyStyle(
                                            Style(
                                                    padding = EdgeValue(all = 3.unitPercent())
                                            )
                                    ))

                   ).applyStyle(
                            Style(
                                    backgroundColor = "#808080",
                                    margin = EdgeValue(all = 2.unitPercent())
                            )
                    )
        }
}

