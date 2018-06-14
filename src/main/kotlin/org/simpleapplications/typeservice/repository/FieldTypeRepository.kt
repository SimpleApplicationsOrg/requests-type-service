package org.simpleapplications.typeservice.repository

import org.simpleapplications.typeservice.model.FieldType
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface FieldTypeRepository : Neo4jRepository<FieldType, Long>