package org.simpleapplications.typeservice.controller

import io.swagger.annotations.Api
import org.simpleapplications.typeservice.service.RequestTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api
@RestController
@RequestMapping("/request")
class RequestTypeController
@Autowired constructor(val requestTypeService: RequestTypeService) {

    @RequestMapping(value = "/type/all", method = arrayOf(RequestMethod.GET))
    fun findAll() = requestTypeService.findAll()

    @RequestMapping(value = "/type/add", method = arrayOf(RequestMethod.POST))
    fun add(@RequestParam name: String, @RequestParam description: String) {
        requestTypeService.addRequestType(name, description)
    }

    @RequestMapping(value = "/type/remove/{requestTypeId}", method = arrayOf(RequestMethod.DELETE))
    fun remove(@PathVariable requestTypeId: Long) {
        requestTypeService.removeRequestType(requestTypeId)
    }

    @RequestMapping(value = "/type/add/fieldType", method = arrayOf(RequestMethod.POST))
    fun addFieldType(@RequestParam requestTypeId: Long, @RequestParam name: String, @RequestParam required: Boolean) {
        requestTypeService.addFieldType(requestTypeId, name, required)
    }

    @RequestMapping(value = "/type/remove/fieldType/{fieldTypeId}", method = arrayOf(RequestMethod.DELETE))
    fun removeFieldType(@PathVariable fieldTypeId: Long) {
        requestTypeService.removeFieldType(fieldTypeId)
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NullPointerException::class)
    fun notFoundExceptionHandler() {}

}
