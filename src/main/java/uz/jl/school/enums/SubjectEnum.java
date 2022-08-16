package uz.jl.school.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SubjectEnum {
    INGILIZ_TILI("Ingiliz tili oqtuvchisi"),
    ONA_TILI("Ona tili oqtuvchisi"),
    RUS_TILI("Rus tili oqtuvchisi"),
    ADABIYOT("Adabiyot oqtuvchisi"),
    ONA_TILI_ADABIYOT("Ona tili va Adabiyot oqtuvchisi"),
    MATEMATIKA("Matematika oqtuvchisi"),
    BIYALOGIYA("Biyalogiya oqtuvchisi"),
    TARIX("Tarix oqtuvchisi"),
    KIMYO("Kimyo oqtuvchisi"),
    FIZIKA("Fizika oqtuvchisi");
    private final String value;
}
