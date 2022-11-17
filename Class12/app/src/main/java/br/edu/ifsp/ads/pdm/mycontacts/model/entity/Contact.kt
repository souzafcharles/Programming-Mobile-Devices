package br.edu.ifsp.ads.pdm.mycontacts.model.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @NonNull
    var name: String,
    @NonNull
    var address: String,
    @NonNull
    var phone: String,
    @NonNull
    var email: String,
): Parcelable