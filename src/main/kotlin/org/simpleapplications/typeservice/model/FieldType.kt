package org.simpleapplications.typeservice.model

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
data class FieldType(
        @Id @GeneratedValue
        var id: Long? = null,
        var name: String? = null,
        var required: Boolean? = null
)

