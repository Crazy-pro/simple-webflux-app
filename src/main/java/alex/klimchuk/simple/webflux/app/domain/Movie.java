package alex.klimchuk.simple.webflux.app.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Copyright Alex Klimchuk (c) 2023.
 */
@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;

}
