package com.example.contact


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.contact.model.Contact
import de.hdodenhof.circleimageview.CircleImageView

/**
 * DetailActivity displays the details of a selected contact.
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve the Contact object from the intent
        val contact = intent.getParcelableExtra<Contact>("CONTACT_ITEM")

        // Set the profile image (if available)
        val profileImageView: CircleImageView = findViewById(R.id.profileImageView)

// Check if contact and profileImage are not null
        if (contact != null) {

            profileImageView.setImageResource(R.drawable.default_profile) // Drawable resource case
            // Display the details
            findViewById<TextView>(R.id.nameTextView).text = contact.name
            findViewById<TextView>(R.id.phoneTextView).text = contact.phoneNumber
            findViewById<TextView>(R.id.emailTextView).text = contact.email
        }

    }

    }

