package com.p3b1yogi.tablayoutoptionmenup8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1, // Register Tab
            R.string.tab_text_2  // Login Tab
        )
    }

    // Variabel untuk melacak status login
    private var isLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup ViewPager2 dan TabLayout
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        // Menghilangkan shadow pada ActionBar
        supportActionBar?.elevation = 0f
    }

    // Metode untuk menampilkan tab login dan registrasi
    fun showLoginRegisterTabs() {
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.currentItem = 0 // Arahkan kembali ke tab pertama (Register)
    }

    // Metode untuk mengubah status login
    fun setLoginStatus(status: Boolean) {
        isLoggedIn = status
        // Logika tambahan jika diperlukan, misalnya memperbarui tampilan
    }
}
