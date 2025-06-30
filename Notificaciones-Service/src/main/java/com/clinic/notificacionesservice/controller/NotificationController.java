package com.clinic.notificacionesservice.controller;
import com.clinic.notificacionesservice.domain.DTO.NotificationDto;
import com.clinic.notificacionesservice.kafka.Mapper.NotificationMapper;
import com.clinic.notificacionesservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getById(@PathVariable UUID id) {
        var notification = notificationService.findById(id);
        return ResponseEntity.ok(mapper.toDto(notification));
    }

    @PostMapping("/{id}/retry")
    public ResponseEntity<Void> retryNotification(@PathVariable UUID id) {
        notificationService.retryNotification(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAll() {
        var all = notificationService.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok(all);
    }

}