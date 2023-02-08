package alex.klimchuk.simple.webflux.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent {

    private  String movieId;

    private Date movieDate;

}
