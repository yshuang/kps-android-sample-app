package com.kono.kps_sample_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kono.kps_sample_app.ui.main.MainFragment
import com.kono.kpssdk.core.KPS
import com.kono.kpssdk.core.init


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KPS.init(this, "5dfafdc23682f5322ec92bcb")

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}
