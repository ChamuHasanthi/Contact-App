package com.example.contact

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.adapter.ContactAdapter
import com.example.contact.model.Contact

/**
 * MainActivity is the entry point of the application.
 * It displays a list of contacts using a RecyclerView.
 * When a contact is clicked, the user is navigated to DetailActivity
 * to view the contact's details.
 *
 * @property contactAdapter The adapter for the RecyclerView that binds contact data to the views.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var contactAdapter: ContactAdapter

    /**
     * Called when the activity is starting.
     * This is where most initialization should go: setting up the UI,
     * initializing the RecyclerView, and setting up the adapter.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     * being shut down, this Bundle contains the data it most recently supplied.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample data
        val contactList = listOf(
            Contact(1, "Aruni  Karunarathna", "074 5968586", "anruni.karuna25@gmail.com"),
            Contact(2, "Abhishek Gunawardhana", "076 6543210", "abhishekgunawardana89@gmail.com"),
            Contact(3, "Amila Hansanee", "074 7415555", "amilai56hansanee@gmail.com"),
            Contact(4, "Ashen jayaneththi", "071 231528", "ashen.Jayanetti1@gmail.com"),
            Contact(5, "Anupriya Avishka", "071 8175966", "avishkaanup61@gmail.com"),
            Contact(7, "Beenu Thambawita", "075 5624519", "beenu79thambawita@gmail.com"),
            Contact(8, "Chamudika Hasanthi", "077 3333044", "chamudika.hasanthi8@gmail.com"),
            Contact(9, "Chalani Dilshara", "077 5662832", "dilsh89chalani@gmail.com"),
            Contact(10, "Chamika Egodauyana", "071 9582223", "chamiegodauyana5@gmail.com"),
            Contact(11, "Dithya Movindi", "075 6452221", "dithya.movi74@gmail.com"),
            Contact(12, "Imashi Ruwandi", "074 5888714", "imasaharuwan.32@gmail.com"),
            Contact(13, "Indumini Prashansa", "070 2156240", "prashanindumini966@gmail.com"),
            Contact(14, "Iresha Sandamali", "070 3005889", "iresha50sandamali@gmail.com"),
            Contact(15, "Sehantha Thathsiluni", "076 5660444", "sehantha.thathsiluni8@gmail.com"),
            Contact(16, "Thilini Bandara", "077 2312588", "thilibandara23@gmail.com"),
            Contact(17, "Thipuni Himasha", "071 5419780", "himashathipu.15@gmail.com"),
            Contact(18, "Thiruni Imasha", "071 8148669", "thiruniimasha344@gmail.com"),
            Contact(19, "Visini Vidara", "034 3940680", "vidara582visini@gmail.com"),
            Contact(20, "Wageesha Samodani", "038 2280742", "wageesamodani647@gmail.com")
        )

        // Initialize RecyclerView
        contactAdapter = ContactAdapter(contactList) { contact ->
            // Navigate to DetailActivity
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("CONTACT_ITEM", contact)
            }
            startActivity(intent)
        }

        //refer to recycle view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //assign a layout manager
        recyclerView.adapter = contactAdapter


    }
}