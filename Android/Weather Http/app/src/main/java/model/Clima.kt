package model

import android.graphics.drawable.Icon

/**
 * Created by Severiano Valdez on 04/08/17.
 */
data class Clima(var lugar : Lugar?= null,
                 var icon: String?= null,
                 var condicionActual: CondicionActual = CondicionActual(),
                 var temperatura: Temperatura = Temperatura(),
                 var viento: Viento = Viento(),
                 var nieve: Nieve = Nieve(),
                 var nubes: Nubes = Nubes())