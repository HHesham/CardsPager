package com.rubikal.cardspager.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rubikal.cardspager.R
import com.rubikal.cardspager.model.CardsInteraction
import com.rubikal.cardspager.model.DiscoverCard
import com.rubikal.cardspager.util.ARCHWAYS_LINK
import com.rubikal.cardspager.util.MCD_LINK
import com.rubikal.cardspager.util.PAGER_MARGIN
import com.rubikal.cardspager.util.convertDpToPixel
import kotlinx.android.synthetic.main.fragment_discover_cards.view.*
import java.util.*

class DiscoverCardsFragment :Fragment(), CardsInteraction {

    private val cards: ArrayList<DiscoverCard> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addCards()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_discover_cards, container, false)
        view.viewpager.adapter = CardsPagerAdapter(cards,this, context)
        val viewPagerMargin = PAGER_MARGIN
        view.viewpager.setPageTransformer(false) { page, _ ->
            when(view.viewpager.currentItem ){
                0 -> page.translationX = convertDpToPixel(-1*viewPagerMargin/2,context).toFloat()
                cards.size - 1 -> page.translationX = convertDpToPixel(viewPagerMargin/2,context).toFloat()
                else -> page.translationX = 0f
            }
        }
        return view
    }

    private fun addCards(){
        cards.clear()
        cards.add(DiscoverCard(0,resources.getText(R.string.card1_header).toString(),
            resources.getText(R.string.card1_detail).toString(),
            MCD_LINK
        ))
        cards.add(DiscoverCard(1,resources.getText(R.string.card2_header).toString(),
            resources.getText(R.string.card2_detail).toString(),
            ARCHWAYS_LINK
        ))
        cards.add(DiscoverCard(2,resources.getText(R.string.card3_header).toString(),
            resources.getText(R.string.card3_detail).toString(),
            ARCHWAYS_LINK
        ))
    }

    override fun openCareersActivity(){
//        this.startActivity(Intent(activity, RegisterActivity::class.java))
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DiscoverCardsFragment().apply { arguments = Bundle().apply {} }
    }
}
