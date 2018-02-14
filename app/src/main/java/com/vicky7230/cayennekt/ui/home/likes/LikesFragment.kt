package com.vicky7230.cayennekt.ui.home.likes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vicky7230.cayennekt.R

class LikesFragment : Fragment() {

    companion object {

        fun newInstance() = LikesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_likes, container, false)

    }
}
