package alex.klimchuk.simple.webflux.app.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;

}
