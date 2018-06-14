package org.simpleapplications.typeservice.repository

import org.simpleapplications.typeservice.model.RequestType
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestTypeRepository : Neo4jRepository<RequestType, Long>

