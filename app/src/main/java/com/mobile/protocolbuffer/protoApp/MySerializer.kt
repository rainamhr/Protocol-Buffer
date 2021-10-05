package com.mobile.protocolbuffer.protoApp

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.mobile.protocolbuffer.Person
import java.io.InputStream
import java.io.OutputStream

class MySerializer : Serializer<Person> {
    override val defaultValue: Person
        get() = Person.getDefaultInstance()

    override fun readFrom(input: InputStream): Person {
        try {
            return Person.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto : ", e)
        }
    }

    override fun writeTo(t: Person, output: OutputStream) {
        t.writeTo(output)
    }
}