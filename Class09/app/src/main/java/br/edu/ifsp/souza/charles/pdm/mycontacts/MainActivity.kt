package br.edu.ifsp.souza.charles.pdm.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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
    }

    private fun fillContactList(){
        for ( i in 1 .. 50) {
            contactList.add(
                Contact(
                    id = 1,
                    name = "Nome $1",
                    address = "Endereço $1",
                    phone = "Telefone $1",
                    email = "Email $1",
                )
            )
        }
    }
}