package co.kr.vlcproject.screen.menu

import co.kr.vlcproject.base.BaseFragment
import co.kr.vlcproject.databinding.FragmentProductBinding
import org.videolan.libvlc.LibVLC
import org.videolan.libvlc.MediaPlayer
import org.videolan.libvlc.util.VLCVideoLayout

class ProductFragment : BaseFragment<FragmentProductBinding>() {


    override fun getViewBinding(): FragmentProductBinding =
        FragmentProductBinding.inflate(layoutInflater)

    override fun initViews() = with(binding){
        super.initViews()
    }

    companion object {


        private const val REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 1

        private const val USE_TEXTURE_VIEW = false

        private const val ENABLE_SUBTITLES = true


        fun newInstance() = ProductFragment()
        const val TAG = "Menu1Fragment"
    }
}