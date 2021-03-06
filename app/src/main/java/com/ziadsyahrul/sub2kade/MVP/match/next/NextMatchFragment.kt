package com.ziadsyahrul.sub2kade.MVP.match.next


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.orhanobut.hawk.Hawk
import com.ziadsyahrul.sub2kade.MVP.detail.detailLeague.DetailLeagueActivity

import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.adapter.NextAdapter
import com.ziadsyahrul.sub2kade.model.EventsItem
import kotlinx.android.synthetic.main.fragment_next_match.*

/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment : Fragment(),  NextView{

    private val presenter: NextPresenter = NextPresenter(this)
    private var nextAdapter: NextAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idLeague = Hawk.get(DetailLeagueActivity.ID_LEAGUE, "")
        presenter.getNextEvent(idLeague)
        rv_next_match.layoutManager = LinearLayoutManager(context)
    }

    override fun getNextEvent(data: List<EventsItem?>?) {
        nextAdapter = NextAdapter(data)
        rv_next_match.adapter = nextAdapter

    }
}

