package vcmsa.projects.wilapp.ui.assistance

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import vcmsa.projects.wilapp.R

class ReqForAssistance : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_request_assistance)

        // Initialize all CardViews
        val disasterCard = findViewById<CardView>(R.id.cardDisasterResponse)
        val immediateCard = findViewById<CardView>(R.id.cardImmediateResponse)
        val donationCard = findViewById<CardView>(R.id.cardDonationResponse)
        val generalCard = findViewById<CardView>(R.id.cardGeneralInquiries)

        // Set click listeners for each card (without transitions)
        disasterCard.setOnClickListener {
            startActivity(Intent(this, DisasterResponseActivity::class.java))
        }

        immediateCard.setOnClickListener {
            startActivity(Intent(this, ImmediateResponseActivity::class.java))
        }

        donationCard.setOnClickListener {
            startActivity(Intent(this, DonationResponseActivity::class.java))
        }

        generalCard.setOnClickListener {
            startActivity(Intent(this, GeneralInquiriesActivity::class.java))
        }
    }
}