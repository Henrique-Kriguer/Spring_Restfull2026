package com.github.henriquekriguer.controllers;

import com.github.henriquekriguer.data.dto.v1.PersonDTO;
import com.github.henriquekriguer.data.dto.v2.PersonDTOV2;
import com.github.henriquekriguer.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
//http://localhost:9090/api/person/v1
@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People Endpoint", description = "Endpoints for managing people")
public class PersonController {

    @Autowired
    private PersonServices service;
    // private PersonServices service = new PersonServices();

    @GetMapping(
            produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )@Operation(summary = "Finds all people",
            description = "Finds all people",
            tags = {"People Endpoint"},
            responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
                    }),
            @ApiResponse(responseCode  = "204", description = "No Content"),
            @ApiResponse(responseCode  = "400", description = "Bad Request"),
            @ApiResponse(responseCode  = "401", description = "Unauthorized"),
            @ApiResponse(responseCode  = "404", description = "Not Found"),
            @ApiResponse(responseCode  = "500", description = "Internal Server Error"),
            })
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    //http://localhost:9090/person/1
    @GetMapping(value = "/{id}",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    )
    @Operation(summary = "Finds a person",
            description = "Finds a specific person by your ID number",
            tags = {"Person Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))
                            ),
                    @ApiResponse(responseCode  = "204", description = "No Content"),
                    @ApiResponse(responseCode  = "400", description = "Bad Request"),
                    @ApiResponse(responseCode  = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode  = "404", description = "Not Found"),
                    @ApiResponse(responseCode  = "500", description = "Internal Server Error"),
            })
    public PersonDTO findById(@PathVariable("id") Long id) {
//        var person = service.findById(id);
//        person.setBirthday(new Date());
//       // person.setPhoneNumber("+55 (12) 12345-6789");
//        person.setPhoneNumber("");
//        //person.setLastName(null);
//        person.setSensitiveData("password");
        return service.findById(id);
    }

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    ) @Operation(summary = "Create a person data",
            description = "Creating a person",
            tags = {"Create Person Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(responseCode  = "204", description = "No Content"),
                    @ApiResponse(responseCode  = "400", description = "Bad Request"),
                    @ApiResponse(responseCode  = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode  = "404", description = "Not Found"),
                    @ApiResponse(responseCode  = "500", description = "Internal Server Error"),
            })
    public PersonDTO create( @RequestBody PersonDTO person) {

        return service.create(person);
    }
//    @PostMapping( value = "/v2",
//        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
//        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
//    )
//    public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person) {
//
//        return service.createV2(person);
//    }

    @PutMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE}
    ) @Operation(summary = "Update a specific person´s data",
            description = "Update a person´s data by passing in a JSON, XML or YAML representation of the UPDATED person",
            tags = {"Person Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(responseCode  = "204", description = "No Content"),
                    @ApiResponse(responseCode  = "400", description = "Bad Request"),
                    @ApiResponse(responseCode  = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode  = "404", description = "Not Found"),
                    @ApiResponse(responseCode  = "500", description = "Internal Server Error"),
            })
    public PersonDTO update( @RequestBody PersonDTO person) {

        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a person",
            description = "Delete a specific person by your ID number",
            tags = {"Person Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(responseCode  = "204", description = "No Content"),
                    @ApiResponse(responseCode  = "400", description = "Bad Request"),
                    @ApiResponse(responseCode  = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode  = "404", description = "Not Found"),
                    @ApiResponse(responseCode  = "500", description = "Internal Server Error"),
            })
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
