/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lz77;

/**
 *
 * @author user
 */
public class Tag {
    private int position;
    private int length;
    private char next;

    public Tag() {
        position = 0;
        length = 0;
        next =' '; 
    }

    public Tag(int position, int length, char next) {
        this.position = position;
        this.length = length;
        this.next = next;
    }
    
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public char getNext() {
        return next;
    }

    public void setNext(char next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "<" + position + "," + length + "," + next + ">";
    }
    
}
