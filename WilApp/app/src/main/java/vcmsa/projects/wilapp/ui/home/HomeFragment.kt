package vcmsa.projects.wilapp.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import vcmsa.projects.wilapp.databinding.FragmentHomeBinding

import vcmsa.projects.wilapp.ui.donation.DonationFragment
import vcmsa.projects.wilapp.ui.volunteer.VolunteerFragment
import androidx.fragment.app.commit
import vcmsa.projects.wilapp.R
import vcmsa.projects.wilapp.ui.aboutus.AboutUsFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var carouselAdapter: CarouselAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Observe welcome text
        homeViewModel.text.observe(viewLifecycleOwner) {
            binding.textHome.text = it
        }

        // Set up carousel images
        viewPager = binding.carouselViewPager
        carouselAdapter = CarouselAdapter(
            listOf(
                R.drawable.ic_paypal,
                R.drawable.ic_zapper,
                R.drawable.ic_zapper
            )
        )
        viewPager.adapter = carouselAdapter

        // Navigation buttons
        binding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Join CareConnect!")
                putExtra(Intent.EXTRA_TEXT, "I'm supporting a great cause with CareConnect. Join me!")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        binding.cardContainer.findViewById<View>(R.id.btnVolunteer).setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.nav_host_fragment_content_main, VolunteerFragment())
                addToBackStack(null)
            }
        }

        binding.cardContainer.findViewById<View>(R.id.btnDonate).setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.nav_host_fragment_content_main, DonationFragment())
                addToBackStack(null)
            }
        }

        binding.cardContainer.findViewById<View>(R.id.btnAbout).setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.nav_host_fragment_content_main, AboutUsFragment())
                addToBackStack(null)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
