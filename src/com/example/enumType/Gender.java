package com.example.enumType;

public enum Gender {
    MALE("XY"),
    FEMALE("XX");

    private String chromosome; //염색체

    Gender(String chromosome) {
        this.chromosome = chromosome;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "chromosome='" + chromosome + '\'' +
                '}';
    }
}
