package com.evo.apatrios.model;

public abstract class Instruction {
    private String instruction;
    private String source;

    public Instruction(String instruction, String source) {
        this.instruction = instruction;
        this.source = source;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "instruction='" + instruction + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
