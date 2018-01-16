package com.abhinav.asthetic.utils

import java.io.IOException
import java.util.Date
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.google.gson.stream.JsonToken.NULL


/**
 * Created by abhinav.sharma on 16/01/18.
 */
class EpochTimeAdapter private constructor() : TypeAdapter<Date>() {

    @Throws(IOException::class)
    override fun read(`in`: JsonReader): Date? {
        return if (`in`.peek() !== NULL) Date(`in`.nextLong() * 1000) else null
    }

    @Throws(IOException::class)
    override fun write(out: JsonWriter, value: Date?) {
        if (value == null) {
            out.nullValue()
        } else {
            out.value(value.time)
        }
    }

    companion object {
        val epochTimeAdapter: TypeAdapter<Date> = EpochTimeAdapter()
    }

}