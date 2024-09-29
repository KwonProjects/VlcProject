package co.kr.vlcproject.screen.menu

import Data.uri
import android.content.Context
import co.kr.vlcproject.base.BaseFragment
import co.kr.vlcproject.databinding.FragmentCameraBinding
import org.videolan.libvlc.LibVLC
import org.videolan.libvlc.Media
import org.videolan.libvlc.MediaPlayer
import org.videolan.libvlc.util.VLCVideoLayout


class CameraFragment : BaseFragment<FragmentCameraBinding>() {

    private lateinit var mVideoLayout: VLCVideoLayout


    private lateinit var mLibVLC: LibVLC



    private lateinit var mMediaPlayer: MediaPlayer
    private lateinit var VLCVideoLayout: VLCVideoLayout

    private  var arg: MutableList<String> =  arrayListOf()

    override fun getViewBinding(): FragmentCameraBinding =
        FragmentCameraBinding.inflate(layoutInflater)

    override fun initViews() = with(binding) {
        super.initViews()
        val context: Context = requireContext()
        arg.add("-vv")
        mLibVLC = LibVLC(context, arg)
        mMediaPlayer = MediaPlayer(mLibVLC)


    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayer.release()
        mLibVLC.release()
    }

    override fun onStart() {
        super.onStart()
        val context: Context = requireContext()
        arg.add("-vv")
        mLibVLC = LibVLC(context, arg)
        mMediaPlayer = MediaPlayer(mLibVLC)
        mVideoLayout = binding.videoLayout
        mMediaPlayer.attachViews(mVideoLayout, null, ENABLE_SUBTITLES, USE_TEXTURE_VIEW)

        val media: Media = Media(mLibVLC, uri)
        mMediaPlayer.media = media
        media.release()
        mMediaPlayer.play()
    }

    override fun onStop() {
        super.onStop()

        mMediaPlayer.stop()
        mMediaPlayer.detachViews()
    }

    companion object {


        fun newInstance() = CameraFragment()
        const val TAG = "Menu2Fragment"

        private const val ENABLE_SUBTITLES = true
        private const val USE_TEXTURE_VIEW = false
    }
}