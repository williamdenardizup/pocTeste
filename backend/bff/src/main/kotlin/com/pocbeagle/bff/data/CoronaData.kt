package com.pocbeagle.bff.data

data class CoronaData(
        val confirmed: String,
        val recovered: String,
        val critical: String,
        val deaths: String,
        val lastChange: String,
        val lastUpdate: String
)

//"confirmed": 24709753,
//"recovered": 17133724,
//"critical": 61384,
//"deaths": 843289,
//"lastChange": "2020-08-28T14:23:22+02:00",
//"lastUpdate": "2020-08-28T14:30:03+02:00"