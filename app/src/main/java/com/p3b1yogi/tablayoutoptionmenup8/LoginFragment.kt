package com.p3b1yogi.tablayoutoptionmenup8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.p3b1yogi.tablayoutoptionmenup8.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Set up listener for login button
        binding.btnLogin.setOnClickListener {
            // Dapatkan username dari input
            val username = binding.Username.text.toString().trim()

            // Logika login (tambahkan logika untuk memverifikasi data pengguna di sini)
            if (isValidUser(username)) { // Misalnya, cek username tidak kosong
                // Arahkan ke Dashboard dan set status login
                val dashboardFragment = DashboardFragment().apply {
                    arguments = Bundle().apply {
                        putString("username", username) // Kirim username ke DashboardFragment
                    }
                }

                // Pindah ke Dashboard
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_dash, dashboardFragment) // Ganti dengan ID container yang sesuai
                    .addToBackStack(null)
                    .commit()

                // Update status login di MainActivity
                (requireActivity() as MainActivity).setLoginStatus(true)
            } else {
                // Tampilkan pesan kesalahan jika login gagal
                binding.Username.error = "Username tidak valid"
            }
        }

        return binding.root
    }

    private fun isValidUser(username: String): Boolean {
        // Logika untuk memverifikasi username
        // Misalnya, username tidak boleh kosong
        return username.isNotEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
