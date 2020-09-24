package com.jabustillo.webservice.model

data class CourseDetail (
    var name: String = "",
    var professor: StudentResume?,
    var student: Collection<StudentResume>?
)