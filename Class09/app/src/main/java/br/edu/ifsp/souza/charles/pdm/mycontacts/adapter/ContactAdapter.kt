package br.edu.ifsp.souza.charles.pdm.mycontacts.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.edu.ifsp.souza.charles.pdm.mycontacts.R
import br.edu.ifsp.souza.charles.pdm.mycontacts.model.Contact

class ContactAdapter(
    context: Context,
    private val contactList: MutableList<Contact>
    ): ArrayAdapter<Contact>(context, R.layout.tile_contact, contactList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }

}