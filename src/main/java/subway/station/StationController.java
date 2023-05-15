package subway.station;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import subway.station.dto.StationCreateDto;

@RestController
public class StationController {

    private final StationService stationService;

    public StationController(final StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/stations")
    public ResponseEntity<Void> create(@RequestBody StationCreateDto stationCreateDto) {
        stationService.create(stationCreateDto);
        return ResponseEntity.ok().build();
    }
}
