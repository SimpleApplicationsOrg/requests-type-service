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

    fun findAllTypes()  = requestTypeRepo.findAll()

    fun addRequestType(name: String, description: String) : RequestType {
        val requestType = RequestType(name = name, description = description)
        return requestTypeRepo.save(requestType)
    }

    fun removeRequestType(id: Long) {
        val requestType = requestTypeRepo.findOne(id)
        requestTypeRepo.delete(requestType)
    }

    fun findAllFieldTypes(requestTypeId: Long) = requestTypeRepo.findOne(requestTypeId).fieldTypes

    fun addFieldType(requestTypeId: Long, name: String, required: Boolean) : RequestType {
        val requestType = requestTypeRepo.findOne(requestTypeId)
        requestType.fieldTypes?.add(FieldType(name = name, required = required))
        return requestTypeRepo.save(requestType)
    }

    fun removeFieldType(requestTypeId: Long, fieldTypeId: Long) {
        val fieldType = requestTypeRepo
                .findOne(requestTypeId)
                .fieldTypes?.find { fieldType -> fieldType.id == fieldTypeId }
        fieldTypeRepo.delete(fieldType)
    }

}
