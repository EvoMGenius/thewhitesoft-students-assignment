package com.evo.apatrios.model;

/**
 *  Решил создать класс хранящий в себе replacement и source.
 *  Пытался делать через Map<String, String> где ключ - replacement, значение - source
 *  Но из-за того что HashMap использует хэш , все пошло не так как должно.
 */
public class Replacement extends Instruction{

    public Replacement(String instruction, String source) {
        super(instruction, source);
    }
}
