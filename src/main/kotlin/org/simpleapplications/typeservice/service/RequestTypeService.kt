package org.simpleapplications.typeservice.service

import org.simpleapplications.typeservice.model.FieldType
import org.simpleapplications.typeservice.model.RequestType
import org.simpleapplications.typeservice.repository.FieldTypeRepository
import org.simpleapplications.typeservice.repository.RequestTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RequestTypeService
@Autowired constructor(val requestTypeRepo: RequestTypeRepository, val fieldTypeRepo: FieldTypeRepository) {

    fun findAllTypes(): MutableIterable<RequestType> = requestTypeRepo.findAll()

    fun addRequestType(name: String, description: String) : RequestType {
        val requestType = RequestType(name = name, description = description)
        return requestTypeRepo.save(requestType)
    }

    fun removeRequestType(requestTypeId: Long) = requestTypeRepo.findById(requestTypeId).ifPresent(requestTypeRepo::delete)

    fun findAllFieldTypes(requestTypeId: Long) = requestTypeRepo.findById(requestTypeId).map { it.fieldTypes }!!

    fun addFieldType(requestTypeId: Long, name: String, required: Boolean) : RequestType {
        return requestTypeRepo.findById(requestTypeId)
                .takeIf { it.isPresent }
                .let { optionalRequestType ->
                    val requestType = optionalRequestType!!.get()
                    requestType.fieldTypes.add(FieldType(name = name, required = required))
                    return@let requestTypeRepo.save(requestType)
                }
    }

    fun removeFieldType(requestTypeId: Long, fieldTypeId: Long) =
        requestTypeRepo.findById(requestTypeId).ifPresent { requestType ->
            requestType.fieldTypes
                    .find { it.id == fieldTypeId }
                    ?.let(fieldTypeRepo::delete)
        }

}
