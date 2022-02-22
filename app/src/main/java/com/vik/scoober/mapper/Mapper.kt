package com.vik.scoober.mapper

interface Mapper<I, O> {

    fun map(input: I): O

}