package br.edu.ifsp.souza.charles.pdm.mycontacts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import br.edu.ifsp.souza.charles.pdm.mycontacts.R
import br.edu.ifsp.souza.charles.pdm.mycontacts.databinding.ActivityMainBinding
import br.edu.ifsp.souza.charles.pdm.mycontacts.model.Contact

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    // Data source
    private val contactList: MutableList<Contact> = mutableListOf()

    //Adaptar
    private val contactAdpater: ArrayAdapter<String> by lazy {
        ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            contactList.map{ it.name}
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        fillContactList()
        amb.contactsLv.adapter = contactAdpater
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.addContactMi -> {
                // Abre a tela de contato
                true
            }
            else -> {false}
        }
    }



    private fun fillContactList(){
        for ( i in 1 .. 50) {
            contactList.add(
                Contact(
                    id = i,
                    name = "Nome $i",
                    address = "Endereço $i",
                    phone = "Telefone $i",
                    email = "Email $i",
                )
            )
        }
    }
}