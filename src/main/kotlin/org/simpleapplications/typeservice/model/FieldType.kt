package org.simpleapplications.typeservice.model

import org.neo4j.ogm.annotation.GraphId
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
data class FieldType(
        @GraphId
        var id: Long? = null,
        var name: String? = null,
        var required: Boolean? = null
)

