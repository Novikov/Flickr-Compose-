package com.app.data.local_data_source.json

import com.squareup.moshi.Moshi
import java.io.InputStream
import java.lang.reflect.ParameterizedType

class MoshiJsonConverter(
    private val moshi: Moshi
) : JsonConverter {

    override fun <T> readValue(json: String, clazz: Class<T>): T =
        moshi.adapter(clazz).fromJson(json)!!

    override fun <T> readValue(json: String, type: ParameterizedType): T =
        moshi.adapter<T>(type).fromJson(json)!!

    override fun <T> readValue(stream: InputStream, clazz: Class<T>): T {
        val json = stream.readBytes().toString(Charsets.UTF_8)
        return readValue(json, clazz)
    }

    override fun writeValueAsString(any: Any): String = moshi.adapter(any.javaClass).toJson(any)

    override fun writeValueAsString(any: Any, type: ParameterizedType): String =
        moshi.adapter<Any>(type).toJson(any)
}
