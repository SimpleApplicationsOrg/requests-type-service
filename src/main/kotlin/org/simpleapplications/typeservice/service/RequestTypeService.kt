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

    fun findAll(): MutableIterable<RequestType> = requestTypeRepo.findAll()

    fun addRequestType(name: String, description: String) : RequestType {
        var requestType = RequestType(name = name, description = description)
        return requestTypeRepo.save(requestType)
    }

    fun removeRequestType(id: Long) {
        var requestType = requestTypeRepo.findOne(id)
        requestTypeRepo.delete(requestType)
    }

    fun addFieldType(requestTypeId: Long, name: String, required: Boolean) {
        var requestType = requestTypeRepo.findOne(requestTypeId)
        if (requestType.fieldType == null) requestType.fieldType = mutableListOf()
        requestType.fieldType!!.add(FieldType(name = name, required = required))
        requestTypeRepo.save(requestType)
    }

    fun removeFieldType(fieldTypeId: Long) {
        var fieldType = fieldTypeRepo.findOne(fieldTypeId)
        fieldTypeRepo.delete(fieldType)
    }

}
