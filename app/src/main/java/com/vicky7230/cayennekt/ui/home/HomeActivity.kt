package com.vicky7230.cayennekt.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import com.vicky7230.cayennekt.R
import com.vicky7230.cayennekt.ui.base.BaseActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class HomeActivity : BaseActivity(), HomeMvpView, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var presenter: HomeMvpPresenter<HomeMvpView>
    @Inject
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.onAttach(this)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = viewPagerAdapter
        toolbarTitle.text = "Recipes"

        bottomNavigationView.setOnNavigationItemSelectedListener({
            when (it.itemId) {
                R.id.recipes -> {
                    viewPager.setCurrentItem(0, true)
                    toolbarTitle.text = "Recipes"
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.likes -> {
                    viewPager.setCurrentItem(1, true)
                    toolbarTitle.text = "Bookmarks"
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    viewPager.setCurrentItem(2, true)
                    toolbarTitle.text = "Search"
                    return@setOnNavigationItemSelectedListener true
                }
            }

            false
        })

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
                when (position) {
                    0 -> toolbarTitle.text = "Recipes"
                    1 -> toolbarTitle.text = "Bookmarks"
                    2 -> toolbarTitle.text = "Search"
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.about ->
                //TODO
                true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
