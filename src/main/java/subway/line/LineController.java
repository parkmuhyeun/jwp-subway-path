package subway.line;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import subway.line.dto.LineCreateDto;
import subway.line.dto.LineResponseDto;
import subway.section.SectionService;
import subway.station.dto.StationResponseDto;

@RestController
@RequestMapping("/lines")
public class LineController {

    private final LineService lineService;
    private final SectionService sectionService;

    public LineController(final LineService lineService, final SectionService sectionService) {
        this.lineService = lineService;
        this.sectionService = sectionService;
    }

    @GetMapping
    public ResponseEntity<List<LineResponseDto>> getLines() {
        return ResponseEntity.ok(lineService.findAllLines());
    }

    @GetMapping("/{lineId}")
    public ResponseEntity<List<StationResponseDto>> getStation(@PathVariable(name = "lineId") final Long lineId) {
        return ResponseEntity.ok(sectionService.findSortedStations(lineId));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody LineCreateDto lineCreateDto) {
        lineService.create(lineCreateDto);
        return ResponseEntity.ok().build();
    }
}
