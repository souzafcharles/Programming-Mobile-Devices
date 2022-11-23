package br.edu.ifsp.ads.pdm.mycontacts.model.database

import br.edu.ifsp.ads.pdm.mycontacts.model.dao.ContactDAO
import br.edu.ifsp.ads.pdm.mycontacts.model.entity.Contact
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ContactDAOFirebase: ContactDAO {
    private val CONTACT_DATABASE_ROOT_NODE = "contacts"
    private val contactRealtimeDatabase = Firebase.database.getReference(CONTACT_DATABASE_ROOT_NODE)

    override fun createContact(contact: Contact): Int {
        TODO("Not yet implemented")
    }
    override fun retrieveContact(id: Int): Contact? {
        TODO("Not yet implemented")
    }

    override fun retrieveContacts(): MutableList<Contact> {
        TODO("Not yet implemented")
    }

    override fun updateContact(contact: Contact): Int {
        TODO("Not yet implemented")
    }

    override fun deleteContact(id: Int): Int {
        TODO("Not yet implemented")
    }
}


