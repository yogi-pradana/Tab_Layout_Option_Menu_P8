package com.p3b1yogi.tablayoutoptionmenup8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.p3b1yogi.tablayoutoptionmenup8.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Set up listener for register button
        binding.btnRegister.setOnClickListener {
            // Dapatkan username dari input
            val username = binding.Username.text.toString()

            // Logika pendaftaran (tambahkan logika penyimpanan data pengguna di sini)

            // Setelah berhasil daftar, arahkan ke DashboardFragment
            val dashboardFragment = DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString("username", username) // Kirim username ke DashboardFragment
                }
            }

            // Pindah ke Dashboard
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_dash, dashboardFragment) // Ganti dengan fragment_container di layout Anda
                .addToBackStack(null) // Tambahkan ke back stack
                .commit()

            // Update status login di MainActivity
            (requireActivity() as MainActivity).setLoginStatus(true)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
