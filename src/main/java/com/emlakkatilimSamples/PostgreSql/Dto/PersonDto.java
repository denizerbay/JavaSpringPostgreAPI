package com.emlakkatilimSamples.PostgreSql.Dto;
import lombok.Data;

import java.util.List;

/*
Data ile default gelir
Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
 */
@Data
public class PersonDto {

    private  Long id;

    private String name;

    private  String surname;

    private List<String> addresses;
}
