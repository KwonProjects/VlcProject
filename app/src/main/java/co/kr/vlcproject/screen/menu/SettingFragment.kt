package co.kr.vlcproject.screen.menu

import co.kr.vlcproject.base.BaseFragment
import co.kr.vlcproject.databinding.FragmentSettingBinding

class SettingFragment  : BaseFragment<FragmentSettingBinding>() {



    override fun getViewBinding(): FragmentSettingBinding  = FragmentSettingBinding.inflate(layoutInflater)

    override fun initViews()  = with(binding){
        super.initViews()
    }

    companion object{

        fun newInstance() = SettingFragment()
        const val TAG = "Menu3Fragment"
    }
}