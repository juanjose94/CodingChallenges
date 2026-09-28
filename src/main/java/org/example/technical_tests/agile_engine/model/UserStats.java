package org.example.technical_tests.agile_engine.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Optional;

@Data
@Builder
@ToString
public class UserStats {

    private Optional<Long> visitCount;
}
