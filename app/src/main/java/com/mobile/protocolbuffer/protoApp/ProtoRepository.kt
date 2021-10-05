package com.mobile.protocolbuffer.protoApp

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.mobile.protocolbuffer.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

class ProtoRepository(context: Context) {

    private val dataStore: DataStore<Person> = context.createDataStore(
        "data",
        serializer = MySerializer()
    )

    val readProto: Flow<Person> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.d("Error", exception.message.toString())
                emit(Person.getDefaultInstance())
            } else {
                throw exception
            }
        }

    suspend fun updateFullName(fullName: String) {
        dataStore.updateData { preference ->
            preference.toBuilder().setFullName(fullName).build()
        }
    }

    suspend fun updateMobile(mobile: String) {
        dataStore.updateData { preference ->
            preference.toBuilder().setFullName(mobile).build()
        }
    }

    suspend fun updateAddress(address: String) {
        dataStore.updateData { preference ->
            preference.toBuilder().setFullName(address).build()
        }
    }
}