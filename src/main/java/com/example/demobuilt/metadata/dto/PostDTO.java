package com.example.demobuilt.metadata.dto;

import java.time.LocalDateTime;

public record PostDTO(Long id, String title, String contents, LocalDateTime timeStamp, Long category) {
}
