package com.kono.kps_sample_app.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kono.kps_sample_app.R
import com.kono.kpssdk.core.KPS
import com.kono.kpssdk.core.openKPSContent

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.main_fragment, container, false)
        val tv = v.findViewById<TextView>(R.id.message)
        tv.text = "asdfaaa"

        KPS.openKPSContent("5e451b0004012eecf1615436"){ errMsg, folder, children, orderChildrenIncreaseRight ->
            Log.d("AAA", errMsg ?: "no error");
            Log.d("AAA", folder?.id ?: "null id");
            Log.d("AAA", folder?.type ?: "null type");
            Log.d("AAA", children?.get(0)?.id ?: "null child id");
            Log.d("AAA", children?.toString() ?: "null children");
            Log.d("AAA",  orderChildrenIncreaseRight.toString());

            if(folder != null){
                for(anImage in folder.images){
                    Log.d("AAA",  anImage.getUri(100));
                    Log.d("AAA",  "============");
                    Log.d("AAA",  anImage.getUri(200));
                    Log.d("AAA",  "============");
                    Log.d("AAA",  anImage.getUri(300));
                    Log.d("AAA",  "============");
                    Log.d("AAA",  anImage.getUri(400));
                    Log.d("AAA",  "============");
                    Log.d("AAA",  anImage.getUri(500));
                    Log.d("AAA",  "============");
                    Log.d("AAA",  anImage.getUri(600));
                }
            }

            Log.d("AAA", folder?.toString() ?: "Empty folder")
        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
