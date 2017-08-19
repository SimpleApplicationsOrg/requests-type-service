package org.simpleapplications.typeservice.repository

import org.simpleapplications.typeservice.model.FieldType
import org.springframework.data.neo4j.repository.GraphRepository
import org.springframework.stereotype.Repository

@Repository
interface FieldTypeRepository : GraphRepository<FieldType>