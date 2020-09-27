package com.jabustillo.webservice.model

data class CourseDetail (
    var name: String = "",
    var professor: StudentResume?,
    var students: MutableList<StudentResume>
)