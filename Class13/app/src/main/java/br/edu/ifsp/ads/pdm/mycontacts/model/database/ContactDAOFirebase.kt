package br.edu.ifsp.ads.pdm.mycontacts.model.database

import br.edu.ifsp.ads.pdm.mycontacts.model.dao.ContactDAO
import br.edu.ifsp.ads.pdm.mycontacts.model.entity.Contact
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class ContactDAOFirebase: ContactDAO {
    private val CONTACT_DATABASE_ROOT_NODE = "contacts"
    private val contactRealtimeDatabase = Firebase.database.getReference(CONTACT_DATABASE_ROOT_NODE)

    //Simula uma consulta ao banco de dados

    private val contactList = mutableListOf<Contact>()
    init {
        contactRealtimeDatabase.addChildEventListener(object: ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val contact: Contact? = snapshot.getValue<Contact>()

                contact?.let { _contact ->
                    if (!contactList.any { _contact.id == it.id })
                        contactList.add(_contact)
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                val contact: Contact? = snapshot.getValue<Contact>()

                contact?.let { _contact ->
                    val position = contactList.indexOfFirst { _contact.id == it.id }
                    if (position != -1) {
                        contactList[position] = _contact
                    }
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                val contact: Contact? = snapshot.getValue<Contact>()
                contactList.remove(contact)
            }


            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                //This method does not apply in this application
            }

            override fun onCancelled(error: DatabaseError) {
                //This method does not apply in this application
            }


        })
    }
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


