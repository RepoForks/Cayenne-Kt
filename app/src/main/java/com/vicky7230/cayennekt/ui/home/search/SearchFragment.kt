package com.vicky7230.cayennekt.ui.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vicky7230.cayennekt.R
import com.vicky7230.cayennekt.ui.base.BaseFragment

class SearchFragment : BaseFragment(), SearchMvpView {
    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        return view
    }

    override fun setUp(view: View) {

    }
}
