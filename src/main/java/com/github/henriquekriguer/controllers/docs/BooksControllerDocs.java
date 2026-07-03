package com.github.henriquekriguer.controllers.docs;

import com.github.henriquekriguer.data.dto.v1.BooksDTO;
import com.github.henriquekriguer.data.dto.v1.PersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BooksControllerDocs {

    @Operation(summary = "Finds all books",
            description = "Finds all books",
            tags = {"Books Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = BooksDTO.class)))
                            }),
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            })
    List<BooksDTO> findAll();

    //http://localhost:9090/Books/1
   @Operation(summary = "Finds a Book",
            description = "Finds a specific Books by your ID number",
            tags = {"Books Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = BooksDTO.class))
                    ),
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            })
    BooksDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Create a Books data",
            description = "Creating a Books",
            tags = {"Books Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = BooksDTO.class))
                    ),
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            })
    BooksDTO create(@RequestBody BooksDTO Books);

    @Operation(summary = "Update a specific Books´s data",
            description = "Update a Books´s data by passing in a JSON, XML or YAML representation of the UPDATED Books",
            tags = {"Books Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = BooksDTO.class))
                    ),
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            })
    BooksDTO update(@RequestBody BooksDTO Books);

    @Operation(summary = "Delete a Books",
            description = "Delete a specific Books by your ID number",
            tags = {"Books Endpoint"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(schema = @Schema(implementation = BooksDTO.class))
                    ),
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            })
    ResponseEntity<?> delete(@PathVariable("id") Long id);
}
