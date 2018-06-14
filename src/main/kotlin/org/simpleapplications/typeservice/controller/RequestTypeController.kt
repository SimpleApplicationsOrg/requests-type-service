package org.simpleapplications.typeservice.controller

import io.swagger.annotations.Api
import org.simpleapplications.typeservice.service.RequestTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api
@RestController
@RequestMapping(value = ["/request"])
class RequestTypeController
@Autowired constructor(val requestTypeService: RequestTypeService) {

    @RequestMapping(value = ["/types/"], method = [RequestMethod.GET])
    fun findAllTypes() = requestTypeService.findAllTypes()

    @RequestMapping(value = ["/types/"], method = [RequestMethod.POST])
    fun add(@RequestParam name: String, @RequestParam description: String) = requestTypeService.addRequestType(name, description)

    @RequestMapping(value = ["/types/{requestTypeId}"], method = [RequestMethod.DELETE])
    fun remove(@PathVariable requestTypeId: Long) : ResponseEntity<Void> {
        requestTypeService.removeRequestType(requestTypeId)
        return ResponseEntity.noContent().build()
    }

    @RequestMapping(value = ["/types/{requestTypeId}/fieldTypes"], method = [RequestMethod.GET])
    fun findAllFieldTypes(@RequestParam requestTypeId: Long) = requestTypeService.findAllFieldTypes(requestTypeId)


    @RequestMapping(value = ["/types/{requestTypeId}/fieldTypes"], method = [RequestMethod.POST])
    fun addFieldType(@RequestParam requestTypeId: Long, @RequestParam name: String, @RequestParam required: Boolean) =
        requestTypeService.addFieldType(requestTypeId, name, required)

    @RequestMapping(value = ["/types/{requestTypeId}/fieldTypes/{fieldTypeId}"], method = [RequestMethod.DELETE])
    fun removeFieldType(@RequestParam requestTypeId: Long, @PathVariable fieldTypeId: Long) : ResponseEntity<Void> {
        requestTypeService.removeFieldType(requestTypeId, fieldTypeId)
        return ResponseEntity.noContent().build()
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NullPointerException::class)
    fun notFoundExceptionHandler() {}

}
