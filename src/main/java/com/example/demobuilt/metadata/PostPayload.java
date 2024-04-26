package com.example.demobuilt.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record PostPayload(
        @JsonProperty("title")
        String title,
        @JsonProperty("content")
        String content,
        @NotNull(message = "this field cannot be null")
        @JsonProperty("categoryId")
        Long categoryId) {

}
