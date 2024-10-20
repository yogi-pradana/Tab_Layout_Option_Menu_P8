package com.p3b1yogi.tablayoutoptionmenup8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.p3b1yogi.tablayoutoptionmenup8.databinding.FragmentDasboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDasboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) // Agar fragment bisa menampilkan menu
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDasboardBinding.inflate(inflater, container, false)

        // Ambil username dari argumen dan tampilkan di dashboard
        val username = arguments?.getString("username") ?: "User"
        binding.welcomeBack.text = "Welcome back, $username"

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; ini menambahkan item ke action bar jika ada.
        inflater.inflate(R.menu.menu_out, menu) // Ganti dengan nama file menu yang sesuai
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btn_logout -> {
                // Logika logout
                requireActivity().supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                (requireActivity() as MainActivity).setLoginStatus(false)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
