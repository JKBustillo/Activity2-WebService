package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.api

//  If you create a data class, you'll get automatic
//  implementations of the following functions: toString()
//  (which will produce a string containing all the property names and values),
//  equals() (which will do a per-property equals()), hashCode()
//  (which will hash the individual properties and combine the hashes)
data class Post (
    var title: String = "",
    var body: String = ""
)