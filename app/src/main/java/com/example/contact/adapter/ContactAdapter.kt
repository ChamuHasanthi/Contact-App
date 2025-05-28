package com.example.contact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.R
import com.example.contact.model.Contact

/**
 * Adapter for binding Contact items to a RecyclerView.
 *
 * This adapter is responsible for managing the list of contacts and binding them to the views
 * in the RecyclerView. It also handles item clicks by invoking a callback function.
 *
 * @property contactList The list of contacts to be displayed in the RecyclerView.
 * @property onItemClick A callback function that is invoked when a contact item is clicked.
 */
class ContactAdapter(
    private val contactList: List<Contact>,
    private val onItemClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    /**
     * ViewHolder for the ContactAdapter.
     *
     * This class holds references to the views in the item layout and binds contact data to them.
     *
     * @property itemView The root view of the item layout.
     */
    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TextView for displaying the contact's name
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        // TextView for displaying the contact's phone number
        private val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)

        /**
         * Binds a contact to the views in the ViewHolder.
         *
         * This method sets the contact's name and phone number to the respective TextViews
         * and sets up a click listener for the item view.
         *
         * @param contact The contact to bind to the views.
         */
        fun bind(contact: Contact) {
            nameTextView.text = contact.name
            phoneTextView.text = contact.phoneNumber
            itemView.setOnClickListener { onItemClick(contact) }
        }
    }

    /**
     * Called when the RecyclerView needs a new ViewHolder.
     *
     * This method inflates the item layout and returns a new ViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The type of the new View.
     * @return A new ContactViewHolder that holds the inflated item view.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    /**
     * Called by the RecyclerView to display the data at the specified position.
     *
     * This method binds the contact at the given position to the ViewHolder.
     *
     * @param holder The ViewHolder to bind the data to.
     * @param position The position of the contact in the list.
     */
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    /**
     * Returns the total number of contacts in the list.
     *
     * This method is used by the RecyclerView to determine how many items to display.
     *
     * @return The number of contacts in the list.
     */
    override fun getItemCount(): Int = contactList.size
}