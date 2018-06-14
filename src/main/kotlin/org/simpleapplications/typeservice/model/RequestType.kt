package org.simpleapplications.typeservice.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.voodoodyne.jackson.jsog.JSOGGenerator
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
@JsonIdentityInfo(generator = JSOGGenerator::class)
data class RequestType (
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    @Relationship(type = "HAS_FIELD_TYPE", direction = Relationship.OUTGOING)
    var fieldTypes: MutableList<FieldType> = ArrayList()
)

