package com.app.data.local_data_source.json

import java.io.InputStream
import java.lang.reflect.ParameterizedType

interface JsonConverter {

    fun <T> readValue(json: String, clazz: Class<T>): T

    fun <T> readValue(json: String, type: ParameterizedType): T

    fun <T> readValue(stream: InputStream, clazz: Class<T>): T

    fun writeValueAsString(any: Any): String
    fun writeValueAsString(any: Any, type: ParameterizedType): String
}
