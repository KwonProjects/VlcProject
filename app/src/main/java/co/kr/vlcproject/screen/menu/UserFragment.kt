package co.kr.vlcproject.screen.menu

import co.kr.vlcproject.base.BaseFragment
import co.kr.vlcproject.databinding.FragmentUserBinding


class UserFragment  : BaseFragment<FragmentUserBinding>() {


    override fun getViewBinding(): FragmentUserBinding  = FragmentUserBinding.inflate(layoutInflater)

    override fun initViews() = with(binding) {

        super.initViews()
    }

    companion object{

        fun newInstance() = UserFragment()
        const val TAG = "Menu4Fragment"
    }
}