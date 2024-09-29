package co.kr.vlcproject.screen.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.kr.vlcproject.screen.menu.CameraFragment
import co.kr.vlcproject.screen.menu.SettingFragment
import co.kr.vlcproject.screen.menu.UserFragment
import co.kr.vlcproject.R
import co.kr.vlcproject.databinding.ActivityMainBinding
import co.kr.vlcproject.screen.menu.ProductFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private val TAG = this.javaClass.simpleName

//    private lateinit var args: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        args.add("-vv")
        initViews()

    }

    private fun initViews() = with(binding) {

        bottomNav.setOnItemSelectedListener(this@MainActivity)
        showFragment(ProductFragment.newInstance(), ProductFragment.TAG)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_prodcut -> {
                showFragment(ProductFragment.newInstance(), ProductFragment.TAG)
                true
            }

            R.id.menu_camera -> {
                showFragment(CameraFragment.newInstance(), CameraFragment.TAG)
                true
            }

            R.id.menu_setting -> {
                showFragment(SettingFragment.newInstance(), SettingFragment.TAG)
                true
            }

            R.id.menu_user -> {
                showFragment(UserFragment.newInstance(), UserFragment.TAG)
                true
            }

            else -> false
        }
    }


    private fun showFragment(fragment: Fragment, tag: String) {
        val findFragment = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.fragments.forEach { fm ->
            supportFragmentManager.beginTransaction().hide(fm).commitAllowingStateLoss()
        }
        findFragment?.let {
            supportFragmentManager.beginTransaction().show(it).commitAllowingStateLoss()
        } ?: kotlin.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment, tag)
                .commitAllowingStateLoss()
        }
    }

}