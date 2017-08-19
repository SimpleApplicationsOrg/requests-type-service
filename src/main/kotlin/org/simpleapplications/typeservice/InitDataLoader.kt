package org.simpleapplications.typeservice

import org.simpleapplications.typeservice.service.RequestTypeService

fun loadData(requestTypeService: RequestTypeService) {
    var requestType = requestTypeService.addRequestType("SomeRequest", "Some administrative request")
    requestTypeService.addFieldType(requestType.id!!, "First Name", true)
    requestTypeService.addFieldType(requestType.id!!, "Last Name", true)
    requestTypeService.addFieldType(requestType.id!!, "Request", true)
}
