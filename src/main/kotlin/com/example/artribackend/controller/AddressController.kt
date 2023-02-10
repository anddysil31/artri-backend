package com.example.artribackend.controller

import com.example.artribackend.model.Address
import com.example.artribackend.service.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/address")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class AddressController {
    @Autowired
    lateinit var addressService: AddressService

    @GetMapping
    fun list():List<Address>{
        return addressService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id:Long):ResponseEntity<*>{
        return ResponseEntity(addressService.findAddressById(id), HttpStatus.ACCEPTED)
    }

    @PostMapping
    fun save(@RequestBody address: Address):ResponseEntity<Address>{
        return ResponseEntity(addressService.save(address), HttpStatus.ACCEPTED)
    }

    @PutMapping
    fun update(@RequestBody address: Address):ResponseEntity<Address>{
        return ResponseEntity(addressService.update(address), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable ("id") id:Long):Boolean?{
        return addressService.delete(id)
    }
}