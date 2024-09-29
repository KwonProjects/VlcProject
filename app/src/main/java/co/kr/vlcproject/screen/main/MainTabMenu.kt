package co.kr.vlcproject.screen.main

import androidx.annotation.IdRes
import co.kr.vlcproject.R


enum class MainTabMenu(@IdRes val menuId: Int) {
  PRODUCT(R.id.menu_prodcut) , CAMERA(R.id.menu_camera), SETTING(R.id.menu_setting), USER(R.id.menu_user)
}
