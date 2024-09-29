package co.kr.vlcproject.screen.splash

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.kr.vlcproject.R
import co.kr.vlcproject.databinding.ActivityMainBinding
import co.kr.vlcproject.databinding.ActivitySplashBinding
import co.kr.vlcproject.screen.main.MainActivity

class SplashActivity : AppCompatActivity() {



    private lateinit var binding: ActivitySplashBinding
    private var permission = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e(TAG,"onCreate step")

        onCheckContactsPermission()
        if (permission) {
            onCheckContactsPermission()
            initViews()
        }else{
            initViews()
        }
    }

    private fun initViews() = with(binding) {
        Log.e(TAG , "Splash Step Error")
        Handler().postDelayed(Runnable {
            val splash = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(splash)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }, 3000)

    }

    override fun onResume() {
        super.onResume()
        onCheckContactsPermission()
    }

    private fun onCheckContactsPermission() {
        val permissionDenied =
            checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_DENIED
                    || checkSelfPermission(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_DENIED


        if (permissionDenied){
            Toast.makeText(this@SplashActivity, getString(R.string.permissionReject), Toast.LENGTH_SHORT).show()
        }else{
            permission = true
        }

    }

    companion object{
        private  val TAG  = SplashActivity::class.java.simpleName
    }
}