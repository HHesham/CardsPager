package com.rubikal.cardspager.model

import android.content.Context
import com.rubikal.cardspager.util.openChromeCustomTab

interface CardsInteraction {

    fun onStaticCardClicked(card: DiscoverCard, context: Context){
        openChromeCustomTab(card, context)
    }

    fun openCareersActivity()
}