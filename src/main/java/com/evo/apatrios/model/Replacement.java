package com.evo.apatrios.model;

/**
 *  Решил создать класс хранящий в себе replacement и source.
 *  Пытался делать через Map<String, String> где ключ - replacement, значение - source
 *  Но из-за того что HashMap использует хэш , все пошло не так как должно.
 */
public class Replacement {

    private String replacement;
    private String source;

    public Replacement(String replacement, String source) {
        this.replacement = replacement;
        this.source = source;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "{" + '\n' +
                "replacement='" + replacement + '\''+
                ", \nsource='" + source + '\'' +"\n"+
                '}';
    }
}
